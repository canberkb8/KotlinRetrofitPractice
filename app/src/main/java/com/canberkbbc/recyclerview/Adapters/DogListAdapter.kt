package com.canberkbbc.recyclerview.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canberkbbc.recyclerview.Models.DogModel
import com.canberkbbc.recyclerview.databinding.CardItemDogBinding

class DogListAdapter : RecyclerView.Adapter<DogListAdapter.DogListViewHolder>() {

    private lateinit var cardItemDogBinding:CardItemDogBinding

    private var onItemClickListener: ((DogModel) -> Unit)? = null


    var dogList: List<DogModel> = mutableListOf()
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DogListAdapter.DogListViewHolder {
        cardItemDogBinding = CardItemDogBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DogListViewHolder(cardItemDogBinding)
    }

    override fun getItemCount(): Int = dogList.size

    override fun onBindViewHolder(
        holder: DogListAdapter.DogListViewHolder,
        position: Int
    ) {
        val stockItem = dogList[position]
        stockItem.let {
            holder.bind(it!!, onItemClickListener)
        }
    }


    inner class DogListViewHolder(private val cardItemDogBinding: CardItemDogBinding) :
        RecyclerView.ViewHolder(cardItemDogBinding.root) {

        fun bind(
            dogItem: DogModel,
            onItemClickListener: ((dog: DogModel) -> Unit)?
        ) {

            cardItemDogBinding.txtName.text = dogItem.name.toString()


            itemView.setOnClickListener { onItemClickListener?.invoke(dogItem) }

        }

    }

    fun setOnItemClickListener(onItemClickListener: ((DogModel) -> Unit)?) {
        this.onItemClickListener = onItemClickListener
    }

}