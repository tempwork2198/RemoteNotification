package com.example.test.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test.R
import com.example.test.utils.Store

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)





        if (Store(applicationContext).getFirstTime()){



            Store(applicationContext).setFirstTime(false)

        }else{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}