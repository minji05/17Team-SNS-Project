package com.example.snsproject.signinanduppage

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInfo(
    val name: String,
    val id: String,
    val password: String,
    val mbti: String,
    var profile: String? = null
) : Parcelable

