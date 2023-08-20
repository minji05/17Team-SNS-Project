package com.example.snsproject.detailpage

object DetailManager {
    private val details: MutableList<DetailInfo> = mutableListOf()

    fun addDetail(detail: DetailInfo) {
        details.add(detail)
    }

    fun getAllDetails(): List<DetailInfo> {
        return details.toList()
    }

    fun clearDetails() {
        details.clear()
    }
}