package com.devdeolho.hexagonal.config

import com.devdeolho.hexagonal.adapters.out.FindCustomerByIdAdapter
import com.devdeolho.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(findCustomerByIdAdapter: FindCustomerByIdAdapter) =
         FindCustomerByIdUseCase(findCustomerByIdAdapter)

}