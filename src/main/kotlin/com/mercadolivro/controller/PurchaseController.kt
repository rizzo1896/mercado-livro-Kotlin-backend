package com.mercadolivro.controller

import com.mercadolivro.controller.mapper.PurchaseMapper
import com.mercadolivro.controller.request.PostPurchaseRequest
import com.mercadolivro.enums.BookStatus
import com.mercadolivro.enums.Erros
import com.mercadolivro.exception.BadRequestException
import com.mercadolivro.service.BookService
import com.mercadolivro.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/purchase")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper,
    private val bookService: BookService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody @Valid request: PostPurchaseRequest) {
        request.bookIds.map {
            val book = bookService.findById(it)
            if (book.status == BookStatus.DELETADO || book.status == BookStatus.CANCELADO || book.status == BookStatus.VENDIDO) {
                throw BadRequestException(Erros.ML202.message.format(book.status), Erros.ML202.code)
            }
        }
        purchaseService.create(purchaseMapper.toModel(request))
    }
}