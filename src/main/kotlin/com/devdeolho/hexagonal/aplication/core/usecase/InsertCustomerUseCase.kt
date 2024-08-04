package com.devdeolho.hexagonal.aplication.core.usecase

import com.devdeolho.hexagonal.aplication.core.domain.Customer
import com.devdeolho.hexagonal.aplication.ports.`in`.InsertCustomerInputPort
import com.devdeolho.hexagonal.aplication.ports.out.FindAddressByZipCodeOutputPort
import com.devdeolho.hexagonal.aplication.ports.out.InsertCustomerOutputPort

class InsertCustomerUseCase(
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val insertCustomerOutputPort: InsertCustomerOutputPort
): InsertCustomerInputPort {

    //funcao do tipo void/Unit
    override fun insert(customer: Customer, zipCode:String){
        customer.apply { //apply executa um bloco de codigo e retorna o proprio objeto depois
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let { //let serve para realizar operações dentro do objeto e em seguida encadear novas operações nesse resultado
            insertCustomerOutputPort.insert(it)
        }
    }
}