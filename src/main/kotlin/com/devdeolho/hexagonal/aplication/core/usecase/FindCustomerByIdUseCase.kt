package com.devdeolho.hexagonal.aplication.core.usecase

import com.devdeolho.hexagonal.aplication.core.exceptions.ObjectNotFoundException
import com.devdeolho.hexagonal.aplication.ports.`in`.FindCustomerByIdInputPort
import com.devdeolho.hexagonal.aplication.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
): FindCustomerByIdInputPort {

    override fun find(id: String) =
        findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")

}