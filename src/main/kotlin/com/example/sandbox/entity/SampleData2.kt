package com.example.sandbox.entity

data class SampleData2(val name: String,
                       val year: Int,
                       val maker: String) {
    constructor(list: List<String>) : this(
            name = list[1],
            year = Integer.parseInt(list[2]),
            maker = list[3])
}