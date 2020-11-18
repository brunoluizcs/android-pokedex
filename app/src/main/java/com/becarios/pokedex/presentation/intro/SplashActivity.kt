package com.becarios.pokedex.presentation.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import com.becarios.pokedex.R
import com.becarios.pokedex.presentation.pokemons.PokemonsActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        hideStatusBarAndFullScreen()
        delayStartActivity()
    }

    private fun hideStatusBarAndFullScreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }

    private fun delayStartActivity() {
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, PokemonsActivity::class.java))
            finish()
        }, 3000)
    }
}