package com.example.uas_ppapb

data class Account(
    // Menyimpan data dengan nilai default string kosong
    var email: String = "",
    var username: String = "",
    var password: String = "",
    var phone: String = "",
    var role: String = "user"
)
