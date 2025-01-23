package com.example.durymong.util

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable

//Parcelable 객체 전달을 위한 Bundle 확장 함수
inline fun <reified T : Parcelable> Bundle.getSafeParcelable(key: String): T? =
    when {
        SDK_INT >= 33 -> getParcelable(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelable(key) as? T
    }