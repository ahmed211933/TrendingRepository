package com.ahmed.trending_task.trending.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.trending_task.R

import com.ahmed.trending_task.trending.data.model.response.GithubResponse

import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_item.view.*

class HomeItemsAdapter(
    val data: ArrayList<GithubResponse>,
) : RecyclerView.Adapter<HomeItemsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])

        holder.view.setOnClickListener{
            holder.view.diver1.visibility=View.VISIBLE
            holder.view.diver2.visibility=View.GONE
            holder.view.tv_url.visibility=View.VISIBLE
            holder.view.lang.visibility=View.VISIBLE
            holder.view.rating.visibility=View.VISIBLE
            holder.view.fork.visibility=View.VISIBLE

        }


    }

    fun setList(list: ArrayList<GithubResponse>) {
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    class ViewHolder constructor(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(model: GithubResponse) {
            bindThmbnail(model.avatar)
            view.tv_title.text = model.author
            view.tv_details.text = model.name
            view.tv_url.text = model.url
            view.lang.text = model.language
            view.rating.text = model.stars.toString()
            view.fork.text = model.forks.toString()
        }

        private fun bindThmbnail(thumbnail: String?) {
            thumbnail ?: return
            Glide.with(view)
                .load(thumbnail)
                .placeholder(R.drawable.bg_radius_dark)
                .into(view.image_trend)
        }

    }
}