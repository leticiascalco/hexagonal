package com.devdeolho.hexagonal.adapters.`in`.consumer

import com.devdeolho.hexagonal.adapters.`in`.message.CustomerMessage
import com.devdeolho.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component


@Component
class ReceiveValidatedCustomerDataConsumer(
    private val updateCustomerInputPort: UpdateCustomerInputPort
) {

    @KafkaListener(topics = ["tp-cpf-validated"], groupId = "consumer-group-id")
    fun receive(customerMessage: CustomerMessage){
        with(customerMessage){
            updateCustomerInputPort.update(toCustomer(), zipCode)
        }
    }

}