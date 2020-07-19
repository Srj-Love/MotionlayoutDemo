package com.sundaymobility.motionlayoutdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sundaymobility.motionlayoutdemo.adapter.MotionAdapter
import com.sundaymobility.motionlayoutdemo.ui.CarouselActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        val layoutList = arrayListOf(R.layout.motion_demo_one, R.layout.motion_demo_two)
        val demoList = arrayListOf<MotionAdapter.Demo>()
        for (i in 0 until layoutList.size) {
            demoList.add(MotionAdapter.Demo("DEMO ${i + 1}", layoutList[i]))
        }

        with(rcv_corousel){
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
            )
            layoutManager =
                LinearLayoutManager(this@MainActivity)
            adapter = MotionAdapter(demoList)
        }
    }

    fun start(layoutFileId: Int) {
        val intent = Intent(this@MainActivity, CarouselActivity::class.java).apply {
            putExtra("layout_file_id", layoutFileId)
        }
        startActivity(intent)
    }
}