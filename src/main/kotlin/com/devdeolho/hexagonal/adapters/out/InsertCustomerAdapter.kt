package com.devdeolho.hexagonal.adapters.out

import com.devdeolho.hexagonal.adapters.out.repository.CustomerRepository
import com.devdeolho.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.devdeolho.hexagonal.aplication.core.domain.Customer
import com.devdeolho.hexagonal.aplication.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
): InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}