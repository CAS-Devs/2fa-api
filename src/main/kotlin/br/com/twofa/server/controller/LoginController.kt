package br.com.twofa.server.controller

import br.com.twofa.server.dto.LoginDTO
import br.com.twofa.server.model.Credentials
import br.com.twofa.server.service.LoginService
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
    fun validateLogin(@RequestBody credentials: Credentials): ResponseEntity<LoginDTO> {
        return service.validateLogin(credentials)
    }
}