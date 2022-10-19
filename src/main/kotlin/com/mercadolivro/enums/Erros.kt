package com.mercadolivro.enums

enum class Erros(
    val code: String,
    val message: String
) {
    ML000("ML000", "Unauthorized"),
    ML001("ML001", "Invalid request"),

    ML101("ML-101", "Book [%s] not exists"),
    ML102("ML-102", "Cannot update book with status [%s]"),

    ML201("ML-201", "Customer [%s] not exists"),
    ML202("ML-202", "Can not purchase the book with status [%s]."),
}