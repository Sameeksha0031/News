package com.example.exroomdatabase.fragment.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.exroomdatabase.R
import com.example.exroomdatabase.model.User

class ListAdapter(val context : Context, val userList : List<User>) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var sno = itemView.findViewById<TextView>(R.id.textView)
        var fname = itemView.findViewById<TextView>(R.id.textView2)
        var lname = itemView.findViewById<TextView>(R.id.textView3)
        var age = itemView.findViewById<TextView>(R.id.textView5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.MyViewHolder {
      val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.card_layout_for_adapter,parent,false)
      return MyViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: ListAdapter.MyViewHolder, position: Int) {
        val user = userList[position]
        holder.sno.text = user.id.toString()
        holder.fname.text = user.fname.toString()
        holder.lname.text = user.lname.toString()
        holder.age.text = user.age.toString()
    }

    override fun getItemCount(): Int {
       return userList.size
        notifyDataSetChanged()
    }
}