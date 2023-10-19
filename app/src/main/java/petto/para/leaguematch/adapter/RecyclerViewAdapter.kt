package petto.para.leaguematch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import petto.para.leaguematch.databinding.ItemTableLayoutBinding
import petto.para.leaguematch.model.TeamData

class RecyclerViewAdapter(private var dataList: List<TeamData>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTableLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val teamData = dataList[position]
        holder.bindData(teamData)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateData(newData: List<TeamData>) {
        dataList = newData
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemTableLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(teamData: TeamData) {
            binding.teamNameTextView.text = teamData.teamName
            binding.gamesCount.text = teamData.score1.toString()
            binding.winCount.text = teamData.score2.toString()
            binding.drawCount.text = teamData.score3.toString()
            binding.lossCount.text = teamData.score4.toString()
            binding.teamPosition.text = teamData.score5.toString()
        }
    }
}