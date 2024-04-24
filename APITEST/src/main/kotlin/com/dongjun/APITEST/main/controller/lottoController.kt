package com.dongjun.APITEST.main.controller

import com.dongjun.APITEST.main.api.model.dto.LottoDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class LottoController {
    private val tickets = mutableListOf<LottoDTO>()

    @PostMapping("/ticket")
    fun buyTicket(): ResponseEntity<LottoDTO> {
        val randomNumbers = LottoDTO.generateRandomNumbers()
        val ticket = LottoDTO(numbers = randomNumbers)
        tickets.add(ticket)
        return ResponseEntity.ok().body(ticket)
    }

    @GetMapping("/winning-numbers")
    fun generateWinningNumbers(): ResponseEntity<LottoDTO> {
        val randomNumbers = LottoDTO.generateRandomNumbers()
        val winningNumbers = LottoDTO(numbers = randomNumbers)
        return ResponseEntity.ok().body(winningNumbers)
    }

    @GetMapping("/LottoCheck")
    fun checkTicket(): ResponseEntity<List<LottoDTO>> {
        return ResponseEntity.ok().body(tickets)
    }

}