package br.com.twofa.server.service

import br.com.twofa.server.dto.LoginDTO
import br.com.twofa.server.model.Credentials
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class LoginService {
    fun validateLogin(credentials: Credentials): ResponseEntity<LoginDTO> {
        val isLoginAuthorized = credentials.username == "cas" && credentials.password == "cas"
        return if(isLoginAuthorized) {
            ResponseEntity.status(HttpStatus.ACCEPTED).body(LoginDTO(true))
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(LoginDTO(false))
        }
    }
}