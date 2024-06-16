package com.example.visitrussia


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val videoView: VideoView = findViewById(R.id.videoView)
        val h1Text: TextView = findViewById(R.id.h1Text)
        val h3Text: TextView = findViewById(R.id.h3Text)

        val videoUri: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.splash_video1)
        videoView.setVideoURI(videoUri)
        videoView.setOnCompletionListener {
            // After the video ends, start the next activity
            val SPLASH_SCREEN_DELAY = 2000 // 3 seconds

            Handler().postDelayed({
                val intent = Intent(this, MainActivityStarter::class.java)
                startActivity(intent)
                finish() // Finish the splash screen activity so it's not shown again when back button is pressed
            }, SPLASH_SCREEN_DELAY.toLong())

        }

        videoView.start()
    }
}
