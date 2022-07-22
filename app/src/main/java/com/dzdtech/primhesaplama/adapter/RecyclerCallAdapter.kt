package com.dzdtech.primhesaplama.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.model.CallsResponse
import kotlinx.android.synthetic.main.recycler_call.view.*

class RecyclerCallAdapter(val callsList: List<CallsResponse>) :
    RecyclerView.Adapter<RecyclerCallAdapter.CallViewHolder>() {
    class CallViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_call, parent, false)
        return CallViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {

        holder.itemView.name.text = callsList[position].itsmName
        holder.itemView.bank.text =
            holder.itemView.bank.text.toString() + " " + callsList[position].bankName
        holder.itemView.jiraNumber.text =
            holder.itemView.jiraNumber.text.toString() + " " + callsList[position].jiraItsmNumber
        holder.itemView.team.text =
            holder.itemView.team.text.toString() + " " + callsList[position].assignedTeam
        holder.itemView.date.text = callsList[position].dueDate
        holder.itemView.status.text = statusText(callsList[position].itsmStatus.toString())
    }

    override fun getItemCount(): Int {

        return callsList.size
    }

    fun statusText(statusCode: String): String {
        lateinit var status : String
        val statusCodeInt : Int = statusCode.toInt()

        when(statusCodeInt){
            1->{status = "Kapalı"}
            2->{status = "Bekleyen Değişiklik"}
            3->{status = "Bekleyen Test"}
            4->{status = "Çözüldü"}
            5->{status = "Müşteri İçin Bekliyor"}
            6->{status = "Devam Ediyor"}
        }

        return status
    }

}

