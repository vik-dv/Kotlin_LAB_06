package com.example.myapp


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // 1. Сначала устанавливаем SplashScreen (должно быть до super.onCreate)
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)

        // 2. Определяем условие «продолжать показывать» и время задержки (в миллисекундах)
        var keepSplash = true
        val delayMillis = 4000L  // например, задержка 1.5 секунды, можно изменить на 2000L (2 секунды)

        // 3. Устанавливаем условие: пока keepSplash == true, SplashScreen остаётся на экране
        splashScreen.setKeepOnScreenCondition { keepSplash }

        // 4. По истечении задержки переключаем условие, SplashScreen автоматически исчезает
        Handler(Looper.getMainLooper()).postDelayed({
            keepSplash = false
        }, delayMillis)

        setContentView(R.layout.activity_main)
    }
}