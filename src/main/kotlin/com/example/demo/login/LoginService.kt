package com.example.demo.login

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class LoginService {
    fun validaLogin(credentials: Credentials): ResponseEntity<*> {
        val isLoginAuthorized = credentials.username.equals("cas") && credentials.password.equals("cas")
        return if(isLoginAuthorized) {
            ResponseEntity.status(HttpStatus.ACCEPTED).body("{\"status\":\"Autorizado\"}")
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Não autorizado")
        }
    }
}