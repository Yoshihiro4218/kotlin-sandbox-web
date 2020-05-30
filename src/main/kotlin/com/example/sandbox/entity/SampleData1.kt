package com.example.sandbox.entity

data class SampleData1(val lastName: String,
                       val firstName: String,
                       val gender: String,
                       val phoneNumber: String) {
    constructor(list: List<String>) : this(
            lastName = list[1],
            firstName = list[2],
            gender = list[3],
            phoneNumber = list[4])
}