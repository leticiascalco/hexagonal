package com.devdeolho.hexagonal.aplication.ports.`in`

import com.devdeolho.hexagonal.aplication.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)
}