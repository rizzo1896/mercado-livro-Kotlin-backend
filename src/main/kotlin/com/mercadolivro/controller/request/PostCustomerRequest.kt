package com.mercadolivro.controller.request

import com.mercadolivro.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty(message = "Name cannot be empty")
    var name: String,

    @field:Email(message = "Email should be valid")
    @EmailAvailable
    var email: String
)