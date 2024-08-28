package com.devdeolho.hexagonal.aplication.ports.`in`

import com.devdeolho.hexagonal.aplication.core.domain.Customer

interface FindCustomerByIdInputPort {

    fun find(id: String): Customer
}