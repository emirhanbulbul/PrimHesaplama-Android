package com.dzdtech.primhesaplama.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzdtech.primhesaplama.R
import com.dzdtech.primhesaplama.model.ProjectsResponse
import kotlinx.android.synthetic.main.recycler_call.view.bank
import kotlinx.android.synthetic.main.recycler_call.view.date
import kotlinx.android.synthetic.main.recycler_call.view.jiraNumber
import kotlinx.android.synthetic.main.recycler_call.view.name
import kotlinx.android.synthetic.main.recycler_call.view.status
import kotlinx.android.synthetic.main.recycler_call.view.team
import kotlinx.android.synthetic.main.recycler_project.view.*

class RecyclerProjectAdapter(val projectsList: List<ProjectsResponse>) :
    RecyclerView.Adapter<RecyclerProjectAdapter.ProjectsViewHolder>() {
    class ProjectsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_project, parent, false)
        return ProjectsViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {

        holder.itemView.name.text = projectsList[position].projectName
        holder.itemView.bank.text =
            holder.itemView.bank.text.toString() + " " + projectsList[position].bankName
        holder.itemView.jiraNumber.text =
            holder.itemView.jiraNumber.text.toString() + " " + projectsList[position].jiraProjectNumber
        holder.itemView.team.text =
            holder.itemView.team.text.toString() + " " + projectsList[position].assignedTeam
        holder.itemView.date.text = projectsList[position].dueDate
        holder.itemView.status.text = statusText(projectsList[position].projectStatus.toString())
        holder.itemView.ag.text =
            holder.itemView.ag.text.toString() + " " + projectsList[position].userManDay.toString()
    }

    override fun getItemCount(): Int {

        return projectsList.size
    }

    fun statusText(statusCode: String): String {
        lateinit var status: String
        val statusCodeInt: Int = statusCode.toInt()

        when (statusCodeInt) {
            1 -> {
                status = "Kapalı"
            }
            2 -> {
                status = "Bekleyen Değişiklik"
            }
            3 -> {
                status = "Bekleyen Test"
            }
            4 -> {
                status = "Çözüldü"
            }
            5 -> {
                status = "Müşteri İçin Bekliyor"
            }
            6 -> {
                status = "Devam Ediyor"
            }
        }

        return status
    }

}

