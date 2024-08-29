package com.devdeolho.hexagonal.adapters.out.client

import com.devdeolho.hexagonal.adapters.out.repository.CustomerRepository
import com.devdeolho.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.devdeolho.hexagonal.aplication.core.domain.Customer
import com.devdeolho.hexagonal.aplication.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component


@Component
class UpdateCustomerAdapter (
    private val customerRepository: CustomerRepository
): UpdateCustomerOutputPort {

    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}