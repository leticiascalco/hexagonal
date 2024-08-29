package com.devdeolho.hexagonal.aplication.ports.out

interface SendCpfForValidationOutputPort {

    fun send(cpf: String)
}