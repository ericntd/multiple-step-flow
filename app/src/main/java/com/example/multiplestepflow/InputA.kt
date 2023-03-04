package com.example.multiplestepflow

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InputA(
    val data: String
): Parcelable