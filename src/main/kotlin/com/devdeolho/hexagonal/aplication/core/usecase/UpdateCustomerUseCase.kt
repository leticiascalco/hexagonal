package com.devdeolho.hexagonal.aplication.core.usecase

import com.devdeolho.hexagonal.aplication.core.domain.Customer
import com.devdeolho.hexagonal.aplication.ports.`in`.FindCustomerByIdInputPort
import com.devdeolho.hexagonal.aplication.ports.`in`.UpdateCustomerInputPort
import com.devdeolho.hexagonal.aplication.ports.out.FindAddressByZipCodeOutputPort
import com.devdeolho.hexagonal.aplication.ports.out.UpdateCustomerOutputPort

/**
 * Aqui não é utilizada nenhuma lib ou framework, por isso é necesária a criação dos Beans em config
 */
class UpdateCustomerUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String){
        if(customer.id == null) throw IllegalArgumentException("The id field cannot be bull")
        findCustomerByIdInputPort.find(customer.id)

        customer.apply { //retorna uma instancia do próprio customer
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
        }
    }
}