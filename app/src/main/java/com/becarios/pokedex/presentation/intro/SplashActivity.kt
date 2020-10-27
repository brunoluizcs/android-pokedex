package com.becarios.pokedex.presentation.intro

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import com.becarios.pokedex.R
import com.becarios.pokedex.presentation.pokemons.PokemonsActivity
import java.util.*

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    private var timer: Timer? = null
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        hideStatusBarAndFullScreen()

        timer = Timer()
        handler = Handler()

        handler.postDelayed(object : Runnable {
            override fun run() {
                startActivity(
                    Intent(
                        this@SplashActivity, PokemonsActivity::class.java
                    )
                )
                finish()
            }
        }, 3000)
    }
    //Thread.sleep(3000)

    private fun hideStatusBarAndFullScreen() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}