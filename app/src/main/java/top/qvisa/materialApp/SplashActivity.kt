package top.qvisa.materialApp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity<MainActivity>()
        Log.d("Splash","Start")
        finish()

    }
}