package com.sundaymobility.motionlayoutdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.sundaymobility.motionlayoutdemo.MainActivity
import com.sundaymobility.motionlayoutdemo.R

class MotionAdapter(private val demoList: ArrayList<Demo>) :
    RecyclerView.Adapter<MotionAdapter.ViewHolder>() {

    data class Demo(val item: String, val layoutId: Int)

    class ViewHolder(layout: ConstraintLayout) : RecyclerView.ViewHolder(layout) {
        val item = layout.findViewById<TextView>(R.id.item)
        var layoutId = 0

        init {
            layout.setOnClickListener {
                println("item clicked ${item.text}")
                val context = it?.context as MainActivity
                context.start(layoutId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val row: ConstraintLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_corousel_row, parent, false) as ConstraintLayout
        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.text = demoList[position].item
        holder.layoutId = demoList[position].layoutId
    }

    override fun getItemCount(): Int = demoList.size
}