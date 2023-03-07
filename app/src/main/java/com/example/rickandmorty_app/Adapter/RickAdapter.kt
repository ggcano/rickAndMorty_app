package com.example.rickandmorty_app.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.rickandmorty_app.databinding.EachRowBinding
import com.example.rickandmorty_app.modelPost.Result

class RickAdapter(private var postList: List<Result>)
    : RecyclerView.Adapter<RickAdapter.PostViewHolder>() {


    private lateinit var binding: EachRowBinding
    var onItemClick: ((positionString: String) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = EachRowBinding.inflate(LayoutInflater.from(parent.context),
        parent,false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.txtName.text=postList[position].name
        binding.txtState.text=postList[position].status

        Glide.with(holder.itemView.context)
            .load(postList[position].image)
            .circleCrop()
            .into(binding.imageCharacterRow)

        //itemClick
        val id = postList[position].id
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(id.toString())
        }

    }

    override fun getItemCount(): Int = postList.size

    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

    }

    fun setData(postList: List<Result>) {
        this.postList=postList
        notifyDataSetChanged()
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }


}