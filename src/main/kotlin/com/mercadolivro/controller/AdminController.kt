package com.mercadolivro.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("admin")
class AdminController(
) {

    @GetMapping("/report")
    fun getAll(@RequestParam name: String?): String {
        return "This is the report"
    }
}