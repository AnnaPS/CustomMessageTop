package com.novadev.snackbartop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_motion.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_motion)

//        btn.setOnClickListener {
//            messageView.initAnimation("Texto de prueba para el componente con animacion, slide in" +
//                    "y slide out", android.R.color.holo_orange_dark, 3000)
//
//
//        }

                btnMotion.setOnClickListener {
                messageViewMotion.initAnimation("Texto de prueba para el componente con animacion, slide in" +
                    "y slide out", android.R.color.holo_orange_dark, 3000)


        }

    }



}
