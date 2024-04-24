package com.dongjun.APITEST.main.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

data class User(
    val email: String,
    val password: String
)

@RestController
class LoginController {
    private val users = mutableListOf<User>()

    @PostMapping("/login")
    fun login(
        @RequestBody loginRequest: User
    ): ResponseEntity<String> {
        // 사용자 인증 로직
        val user = users.find { it.email == loginRequest.email && it.password == loginRequest.password }
        return if (user != null) {
            ResponseEntity.ok().body("로그인 성공")
        } else {
            ResponseEntity.status(401).body("로그인 실패")
        }
    }
}