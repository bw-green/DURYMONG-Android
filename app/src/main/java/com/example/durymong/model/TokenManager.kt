package com.example.durymong.model

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object TokenManager {
    private const val PREF_NAME = "durymong_prefs"
    private const val TOKEN_KEY = "auth_token"

    private lateinit var prefs: SharedPreferences
    private val _tokenLiveData = MutableLiveData<String?>()
    val tokenLiveData: LiveData<String?> get() = _tokenLiveData

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        _tokenLiveData.value = prefs.getString(TOKEN_KEY, null)
    }

    fun saveToken(token: String) {
        prefs.edit().putString(TOKEN_KEY, token).apply()
        _tokenLiveData.postValue(token)  // LiveData 업데이트
    }

    fun getToken(): String? = prefs.getString(TOKEN_KEY, null)

    fun clearToken() {
        prefs.edit().remove(TOKEN_KEY).apply()
        _tokenLiveData.postValue(null)
    }
}