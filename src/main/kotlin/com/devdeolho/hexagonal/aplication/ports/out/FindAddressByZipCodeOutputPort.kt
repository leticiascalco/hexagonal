package com.devdeolho.hexagonal.aplication.ports.out

import com.devdeolho.hexagonal.aplication.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address

}