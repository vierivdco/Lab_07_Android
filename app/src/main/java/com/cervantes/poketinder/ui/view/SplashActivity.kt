package com.cervantes.poketinder.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.cervantes.poketinder.databinding.ActivitySplashBinding
import com.cervantes.poketinder.util.SharedPreferenceUtil

class SplashActivity : BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate) {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }

        Handler(Looper.getMainLooper()).postDelayed(
            {
                //Evaluar si mostrar intro o no
                val isIntroAvailable = sharedPreferenceUtil.getIntroShow()
                val isUserAvailable = sharedPreferenceUtil.getUser()
                if(!isIntroAvailable && (isUserAvailable==null)) {
                    startActivity(Intent(this, OnboardingActivity::class.java))
                }else if(isIntroAvailable && (isUserAvailable==null)) {
                    startActivity(Intent(this, OnboardingActivity::class.java))
                }else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
                finish()
            },
            3000 //value in milliseconds
        )
    }
}