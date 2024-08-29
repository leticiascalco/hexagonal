package com.devdeolho.hexagonal.aplication.ports.out

interface DeleteCustomerByIdOutputPort {

    fun delete(id: String)
}