package com.dongjun.APITEST.main.api.model.dto

import kotlin.random.Random

data class LottoDTO(
    val numbers: List<List<String>>
) {
    init {
        require(numbers.size == 5) { "로또 번호는 5줄이어야 합니다." }
        numbers.forEach {
            require(it.size == 6) { "각 줄은 6개의 숫자로 이루어져야 합니다." }
        }
    }

    companion object {
        fun generateRandomNumbers(): List<List<String>> {
            val random = Random
            val generatedNumbers = mutableListOf<List<String>>()
            repeat(5) {
                val lineNumbers = mutableListOf<String>()
                repeat(6) {
                    var randomNumber: String
                    do {
                        randomNumber = random.nextInt(1, 46).toString()
                    } while (randomNumber in lineNumbers)
                    lineNumbers.add(randomNumber)
                }
                generatedNumbers.add(lineNumbers)
            }
            return generatedNumbers
        }
    }
}