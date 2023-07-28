package com.colada.gtn3.fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.colada.gtn3.R
import com.colada.gtn3.TicketInListModel
import com.colada.gtn3.databinding.FragmentPlaceholderBinding
import com.colada.gtn3.databinding.FragmentSaveExpBinding
import com.colada.gtn3.dbhelper
import com.colada.gtn3.globalData

class PlaceholderFragment : Fragment() {

    lateinit var binding: FragmentPlaceholderBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: TicketsListAdapter
    lateinit var db: dbhelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_placeholder, container, false)
        binding = FragmentPlaceholderBinding.bind(view)
        return view
    }


//    fun myt(): ArrayList<TicketInListModel> {
//        val ticketsList = ArrayList<TicketInListModel>()
//        val cat = globalData.currentCategory
//        val tickets = db.getTickets(cat)
//
//
//        for (n in tickets) {
//            val t = TicketInListModel(n, 0, 0)
//            ticketsList.add(t)
//        }
//
//        return ticketsList
//    }


//    private fun init() {
//        db = dbhelper(requireContext())
//        recyclerView = binding.rvSaveExp
//        adapter = TicketsListAdapter(requireContext())
//        recyclerView.adapter = adapter
//        adapter.setList(myt())
//    }

}