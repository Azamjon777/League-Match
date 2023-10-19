package petto.para.leaguematch.presentation.fragments.korea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import petto.para.leaguematch.R
import petto.para.leaguematch.adapter.RecyclerViewAdapter
import petto.para.leaguematch.utils.Utils.dataListKor

class TableFragmentKor : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_table_korea, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewKor)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = RecyclerViewAdapter(dataListKor)
        recyclerView.adapter = adapter

        return view
    }
}
