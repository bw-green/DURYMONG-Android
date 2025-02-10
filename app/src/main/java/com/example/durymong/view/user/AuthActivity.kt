package com.example.durymong.view.user

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.durymong.MainActivity
import com.example.durymong.databinding.ActivityDurymongMainBinding
import com.example.durymong.view.user.viewmodel.AuthViewModel

class AuthActivity : AppCompatActivity(){

    private lateinit var binding: ActivityDurymongMainBinding
    private val viewModel: AuthViewModel by viewModels()
    var isLoggedIn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDurymongMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: 로그인 여부 판단 로직 이후에 추가(sharedPreference 사용?)

        if(isLoggedIn){
            // 로그인 되어있을 경우 MainActivity로 이동
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        initButtons()
    }

    private fun initButtons(){
        binding.btnDurymongMainLogin.setOnClickListener {
            // 임의로 테스트용 함수 호출, 이후에는 수정해서 사용
            loginTest()
        }
    }

    private fun navigateToRegister() {
        TODO("Not yet implemented")
    }


    private fun navigateToLogin(){
        TODO("Not yet implemented")
    }

    private fun loginTest(){
        // 로그인 테스트
        viewModel.loginTest()
    }

}