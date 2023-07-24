package com.colada.gtn3.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.colada.gtn3.R
import com.colada.gtn3.TaskActivity
import com.colada.gtn3.TicketInListModel
import com.colada.gtn3.globalData
import kotlinx.android.synthetic.main.activity_custom_list_view.view.q_number
import kotlinx.android.synthetic.main.activity_custom_list_view.view.q_right
import kotlinx.android.synthetic.main.activity_custom_list_view.view.q_wrong

class TicketsListAdapter (private val context: Context): RecyclerView.Adapter<TicketsListAdapter.TicketsViewHolder>() {
    class TicketsViewHolder(view: View): RecyclerView.ViewHolder(view)

    private var ticketsList = emptyList<TicketInListModel>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_custom_list_view, parent, false)
        return TicketsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ticketsList.size
    }

    override fun onBindViewHolder(holder: TicketsViewHolder, position: Int) {
        holder.itemView.q_number.text = ticketsList[position].ticketNumber
        holder.itemView.q_right.text = ticketsList[position].rightCount.toString()
        holder.itemView.q_wrong.text = ticketsList[position].wrongCount.toString()

        holder.itemView.setOnClickListener{
            globalData.currentTicket = position + 1
            startActivity(context, Intent(context, TaskActivity::class.java), null)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<TicketInListModel>) {
        ticketsList = list
        notifyDataSetChanged()
    }


}