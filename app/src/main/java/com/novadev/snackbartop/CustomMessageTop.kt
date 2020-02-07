package com.novadev.snackbartop

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlinx.android.synthetic.main.custom_top_message.view.*
import java.util.*
import kotlin.concurrent.schedule


class CustomMessageTop :
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
        LayoutInflater.from(context).inflate(R.layout.custom_top_message, this, true)


    fun initAnimation(text: String, color: Int, time: Long) {
        initLayoutAnim(text, color, time)
        initListeners()
    }

    private fun initListeners() {
        ivClose.setOnClickListener {
            animateSlideOut(coordinatorRoot, 500)
            timerTask.cancel()
        }
    }

    private fun initLayoutAnim(text: String, color: Int, time: Long) {
        animateSlideOut(coordinatorRoot, 0)
        tvTextMessage.text = text
        coordinatorRoot.setBackgroundColor(coordinatorRoot.resources.getColor(color))
        animate(coordinatorRoot, time)
    }


    private fun animate(view: View, time: Long) {
        animateSlideIn(view, 500)
        timerTask = Timer("timer", false).schedule(time) {
            animateSlideOut(view, 500)
            timerTask.cancel()
        }
    }

    private fun animateSlideOut(view: View, duration: Long) {
        val animationOut: Animation = TranslateAnimation(0f, 0f, 0f, -view.height.toFloat())
        animationOut.duration = duration
        animationOut.fillAfter = true
        view.visibility = View.INVISIBLE
        coordinatorRoot.startAnimation(animationOut)
    }

    private fun animateSlideIn(view: View, duration: Long) {
        val animationIn: Animation = TranslateAnimation(0f, 0f, -view.height.toFloat(), 0f)
        animationIn.duration = duration
        animationIn.fillAfter = true
        view.visibility = View.VISIBLE
        coordinatorRoot.startAnimation(animationIn)
    }





}



