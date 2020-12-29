package br.com.twofa.server.service

import br.com.twofa.server.dto.TokenDTO
import br.com.twofa.server.model.Token
import br.com.twofa.server.utils.TokenGenerator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TokenService {

    fun validateToken(tokenToValidate: Token): ResponseEntity<TokenDTO> {

        val tokenGenerator = TokenGenerator()

        val currentTime = System.currentTimeMillis() / 30000

        val lastToken = tokenGenerator.generateToken(currentTime - 1)
        val currentToken = tokenGenerator.generateToken(currentTime)
        val nextToken = tokenGenerator.generateToken(currentTime + 1)

        val isTokenValid = tokenGenerator.compareTokens(tokenToValidate.token, lastToken, currentToken, nextToken)
        println(isTokenValid)

        return if (isTokenValid) {
            ResponseEntity.status(HttpStatus.ACCEPTED).body(TokenDTO(true))
        } else {
            ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(TokenDTO(false))
        }
    }
}