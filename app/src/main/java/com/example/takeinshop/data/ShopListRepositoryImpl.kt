package com.example.takeinshop.data

import com.example.takeinshop.domain.ShopItem
import com.example.takeinshop.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementID = 0
    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID)
            shopItem.id = autoIncrementID++
        shopList.add(shopItem)
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toMutableList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        deleteShopItem(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find { it.id == id } ?: throw RuntimeException("Element with id $id not found")
    }
}