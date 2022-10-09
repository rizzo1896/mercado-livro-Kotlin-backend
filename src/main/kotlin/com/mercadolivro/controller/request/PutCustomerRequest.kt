package com.mercadolivro.controller.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PutCustomerRequest(
    @field:NotEmpty(message = "Name cannot be empty")
    var name: String,

    @field:Email(message = "Email cannot be empty")
    var email: String
)