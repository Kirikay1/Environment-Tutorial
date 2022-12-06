package com.example.environment_tutorial

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class MyAdapter(listArray: ArrayList<ListItem>, context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val im = view.findViewById<ImageView>(R.id.im)
        val tvText = view.findViewById<TextView>(R.id.tvTitle)
        val tvContent = view.findViewById<TextView>(R.id.tvContent)
        fun bind(listItem: ListItem, context: Context){
            im.setImageResource(listItem.image_id)
            tvText.text = listItem.titleText
            val textCon = listItem.content.substring(0,50) + "..."
            tvContent.text = textCon
            itemView.setOnClickListener(){
                val intent = Intent(context, ContentActivity::class.java).apply {
                    putExtra("title", tvText.text.toString())
                    putExtra("content", listItem.content)
                    putExtra("image", listItem.image_id)
                }
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem, contextR)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    fun updateAdapter(listArray: List<ListItem>){
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()
    }
}