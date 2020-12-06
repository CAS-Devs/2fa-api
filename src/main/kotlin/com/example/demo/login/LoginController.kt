package com.example.demo.login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("login")
@CrossOrigin
class LoginController {

    @Autowired
    lateinit var service: LoginService

    @PostMapping
    fun login(@RequestBody credentials: Credentials): ResponseEntity<*> {
        return service.validaLogin(credentials)
    }
}