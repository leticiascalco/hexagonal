package com.devdeolho.hexagonal.aplication.ports.out

import com.devdeolho.hexagonal.aplication.core.domain.Customer

interface FindCustomerByIdOutputPort {

    fun find(id:String): Customer?
}