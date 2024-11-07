package com.example.takeinshop.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import com.example.takeinshop.R
import com.example.takeinshop.domain.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShowItemViewHolder>(ShopItemDiffCallback()) {

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowItemViewHolder {
        val layoutResId = if (viewType == VIEW_TYPE_ACTIVE)
            R.layout.item_shop_enabled
        else if (viewType == VIEW_TYPE_DISABLE) R.layout.item_shop_disabled
        else throw RuntimeException("Unknown view type: $viewType")
        val view = LayoutInflater.from(parent.context).inflate(
            layoutResId,
            parent,
            false
        )
        return ShowItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowItemViewHolder, position: Int) {
        val shopItem = getItem(holder.adapterPosition)
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        holder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }
        if (shopItem.enabled) {
            holder.tvName.setTextColor(
                ContextCompat.getColor(
                    holder.itemView.context,
                    android.R.color.holo_orange_light
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        val status = getItem(position).enabled
        if (status == true)
            return VIEW_TYPE_ACTIVE
        else
            return VIEW_TYPE_DISABLE
    }

    companion object {
        const val VIEW_TYPE_ACTIVE = 100
        const val VIEW_TYPE_DISABLE = 101

        const val MAX_POOL_SIZE = 15
    }
}