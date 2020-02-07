package com.novadev.snackbartop

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlinx.android.synthetic.main.custom_top_message.view.*
import kotlinx.android.synthetic.main.custom_top_message.view.ivClose
import kotlinx.android.synthetic.main.custom_top_message.view.tvTextMessage
import kotlinx.android.synthetic.main.custom_top_message_motion.view.*
import java.util.*
import kotlin.concurrent.schedule


class CustomMessageTopMotion :
    CoordinatorLayout {

    private lateinit var timerTask: TimerTask

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()

    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        initView()
    }

    private fun initView() =
        LayoutInflater.from(context).inflate(R.layout.custom_top_message_motion, this, true)


    fun initAnimation(text: String, color: Int, time: Long) {
        initLayoutAnim(text, color, time)
        initListeners()
    }

    private fun initListeners() {
        ivClose.setOnClickListener {
            motion_container.transitionToStart()
            timerTask.cancel()
        }
    }

    private fun initLayoutAnim(text: String, color: Int, time: Long) {
        tvTextMessageMotion.text = text
        clRootMotion.setBackgroundColor(motion_container.resources.getColor(color))
        motion_container.transitionToEnd()


        motion_container.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
            override fun allowsTransition(p0: MotionScene.Transition?): Boolean = true

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                timerTask = Timer("timer", false).schedule(time) {
                    motion_container.transitionToStart()
                    timerTask.cancel()
                }

            }

        })
    }

}



