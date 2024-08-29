package com.devdeolho.hexagonal.aplication.core.usecase

import com.devdeolho.hexagonal.aplication.ports.`in`.DeleteCustomerByIdInputPort
import com.devdeolho.hexagonal.aplication.ports.`in`.FindCustomerByIdInputPort
import com.devdeolho.hexagonal.aplication.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdInputPort,
    private val deleteCustomerOutputPort: DeleteCustomerByIdOutputPort
): DeleteCustomerByIdInputPort {

    override fun delete(id: String) {
        findCustomerByIdInputPort.find(id)
        deleteCustomerOutputPort.delete(id)
    }
}