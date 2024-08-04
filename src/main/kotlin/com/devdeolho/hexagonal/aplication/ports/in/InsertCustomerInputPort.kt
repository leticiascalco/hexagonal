package com.devdeolho.hexagonal.aplication.ports.`in`

import com.devdeolho.hexagonal.aplication.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)
}