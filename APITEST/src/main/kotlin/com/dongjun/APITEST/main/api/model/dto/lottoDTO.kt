package com.dongjun.APITEST.main.api.model.dto

data class LottoDTO(
    val numbers: List<String>
) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개의 숫자로 이루어져야 합니다." }
    }
}
