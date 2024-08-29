package com.devdeolho.hexagonal.adapters.out.repository.entity

import com.devdeolho.hexagonal.aplication.core.domain.Customer
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.MongoId

@Document
data class CustomerEntity(
    @MongoId val id: String?,
    val name: String,
    val address: AddressEntity,
    val cpf: String,
    val isValidCpf: Boolean
) {
    constructor(customer: Customer): this(
        customer.id,
        customer.name,
        AddressEntity(customer.address!!),
        customer.cpf,
        customer.isValidCpf
    )

    fun toCustomer() = Customer(id, name, address.toAddress(), cpf, isValidCpf)
}
