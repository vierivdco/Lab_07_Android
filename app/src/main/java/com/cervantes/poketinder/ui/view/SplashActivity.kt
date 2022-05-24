package com.cervantes.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.cervantes.poketinder.databinding.ActivitySplashBinding
import com.cervantes.poketinder.util.SharedPreferenceUtil

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate){

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }

        Handler(Looper.getMainLooper()).postDelayed(
            {

                val isIntroAvailable = sharedPreferenceUtil.getIntroShow()
                if (!isIntroAvailable) {
                    startActivity(Intent(this, OnboardingActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                finish()
            },
            3000
        )
    }
}