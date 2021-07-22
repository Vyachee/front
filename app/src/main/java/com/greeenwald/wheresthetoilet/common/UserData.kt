package com.greeenwald.wheresthetoilet.common

import java.io.Serializable

data class UserData(

    val nickname: String,
    val email: String,
    val password: String,
    val password_repeat: String

    ): Serializable
