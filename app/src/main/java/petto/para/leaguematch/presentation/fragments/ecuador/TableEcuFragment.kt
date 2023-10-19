package petto.para.leaguematch.presentation.fragments.ecuador

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
import petto.para.leaguematch.utils.Utils.dataListEcu

class TableEcuFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_table_ecu, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewEcu)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val dataList: List<TeamData> = dataListEcu
        adapter = RecyclerViewAdapter(dataList)
        recyclerView.adapter = adapter

        return view
    }
}
