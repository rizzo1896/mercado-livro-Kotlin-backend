package com.mercadolivro.service

import com.mercadolivro.enums.BookStatus
import com.mercadolivro.events.PurchaseEvent
import com.mercadolivro.model.PurchaseModel
import com.mercadolivro.repository.BookRepository
import com.mercadolivro.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val bookRepository: BookRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {
    @Transactional
    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }

}
