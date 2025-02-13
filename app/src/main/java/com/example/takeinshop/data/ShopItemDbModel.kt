package com.example.takeinshop.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.takeinshop.domain.ShopItem.Companion.UNDEFINED_ID

@Entity(tableName = "shop_items")
data class ShopItemDbModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)