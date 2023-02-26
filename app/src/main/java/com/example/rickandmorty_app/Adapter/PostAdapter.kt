package com.example.rickandmorty_app.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.rickandmorty_app.databinding.EachRowBinding
import com.example.rickandmorty_app.mdoel.Result

class PostAdapter(private var postList: List<Result>)
    : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private lateinit var binding: EachRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = EachRowBinding.inflate(LayoutInflater.from(parent.context),
        parent,false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.tasks.text=postList[position].name
    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

    }

    fun setData(postList: List<Result>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }

}