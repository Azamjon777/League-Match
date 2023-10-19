package petto.para.leaguematch.presentation.fragments.argentina

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import petto.para.leaguematch.R
import petto.para.leaguematch.adapter.RecyclerViewAdapter
import petto.para.leaguematch.model.TeamData
import petto.para.leaguematch.utils.Utils

class TableArgFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_table_arg, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewArg)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val dataList: List<TeamData> = Utils.dataListArg
        adapter = RecyclerViewAdapter(dataList)
        recyclerView.adapter = adapter

        return view
    }
}
