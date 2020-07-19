package com.sundaymobility.motionlayoutdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import com.sundaymobility.motionlayoutdemo.R

class CarouselActivity : AppCompatActivity() {

    private var selectedIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = intent.getIntExtra("layout_file_id", R.layout.motion_demo_one)
        setContentView(layout)

        val motionLayout = findViewById<MotionLayout>(R.id.motion_container)

        val v1 = findViewById<View>(R.id.v1)
        val v2 = findViewById<View>(R.id.v2)
        val v3 = findViewById<View>(R.id.v3)

        v1.setOnClickListener {
            if (selectedIndex == 0) return@setOnClickListener

            motionLayout.setTransition(R.id.s2, R.id.s1) //Green to blue transition
            motionLayout.transitionToEnd()
            selectedIndex = 0
        }
        v2.setOnClickListener {
            if (selectedIndex == 1) return@setOnClickListener

            if (selectedIndex == 2) {
                motionLayout.setTransition(R.id.s3, R.id.s2)  //red to Green transition
            } else {
                motionLayout.setTransition(R.id.s1, R.id.s2) //blue to Green transition
            }
            motionLayout.transitionToEnd()
            selectedIndex = 1
        }
        v3.setOnClickListener {
            if (selectedIndex == 2) return@setOnClickListener

            motionLayout.setTransition(R.id.s2, R.id.s3) //Green to red transition
            motionLayout.transitionToEnd()
            selectedIndex = 2
        }
    }
}