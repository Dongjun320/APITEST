package com.dongjun.APITEST.main.controller

import com.dongjun.APITEST.main.api.model.dto.createDTO
import com.dongjun.APITEST.main.api.model.dto.createDtoRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class createController {
    private val tests = mutableListOf<createDTO>()

    @PostMapping("/test")
    fun postTestDto(
        @RequestBody testDtoRequest: createDtoRequest
    ): ResponseEntity<createDTO> {
        val test = createDTO(
            fullname = testDtoRequest.fullname,
            email = testDtoRequest.email,
            password = testDtoRequest.password
        )
        tests.add(test)
        return ResponseEntity.ok().body(test)
    }
}