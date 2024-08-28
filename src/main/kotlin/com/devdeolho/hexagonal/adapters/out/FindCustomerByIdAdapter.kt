package com.devdeolho.hexagonal.adapters.out

import com.devdeolho.hexagonal.adapters.out.repository.CustomerRepository
import com.devdeolho.hexagonal.aplication.core.domain.Customer
import com.devdeolho.hexagonal.aplication.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): FindCustomerByIdOutputPort {

    override fun find(id: String): Customer? =
         customerRepository.findById(id)
            .getOrNull()
            .let {
                return it?.toCustomer()  //se tiver nulo retorna null mesmo, senao retorna customer.
            }
}