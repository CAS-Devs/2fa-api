package br.com.twofa.server.controller

import br.com.twofa.server.dto.TokenDTO
import br.com.twofa.server.model.Token
import br.com.twofa.server.service.TokenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/token")
@CrossOrigin
class TokenController {

    @Autowired
    lateinit var tokenService: TokenService;

    @PostMapping
    fun validateToken(@RequestBody tokenToValidate: Token): ResponseEntity<TokenDTO>{
        return tokenService.validateToken(tokenToValidate)
    }
}