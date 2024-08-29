package com.devdeolho.hexagonal.config

import com.devdeolho.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.devdeolho.hexagonal.adapters.out.SendCpfForValidationAdapter
import com.devdeolho.hexagonal.adapters.out.client.UpdateCustomerAdapter
import com.devdeolho.hexagonal.aplication.core.usecase.FindCustomerByIdUseCase
import com.devdeolho.hexagonal.aplication.core.usecase.UpdateCustomerUseCase
import com.devdeolho.hexagonal.aplication.ports.`in`.UpdateCustomerInputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter,
        sendCpfForValidationAdapter: SendCpfForValidationAdapter
    ): UpdateCustomerInputPort {
        return UpdateCustomerUseCase(
            findCustomerByIdUseCase,
            findAddressByZipCodeAdapter,
            updateCustomerAdapter,
            sendCpfForValidationAdapter
        )
    }

}