package com.devdeolho.hexagonal.application.core.usecase

import com.devdeolho.hexagonal.application.core.domain.Customer
import com.devdeolho.hexagonal.application.ports.`in`.InsertCustomerInputPort
import com.devdeolho.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.devdeolho.hexagonal.application.ports.out.InsertCustomerOutputPort
import com.devdeolho.hexagonal.application.ports.out.SendCpfForValidationOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
): InsertCustomerInputPort {

    //funcao do tipo void/Unit
    override fun insert(customer: Customer, zipCode:String){
        customer.apply { //apply executa um bloco de codigo e retorna o proprio objeto depois
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let { //let serve para realizar operações dentro do objeto e em seguida encadear novas operações nesse resultado
            insertCustomerOutputPort.insert(it)
            sendCpfForValidationOutputPort.send(it.cpf)
        }
    }
}