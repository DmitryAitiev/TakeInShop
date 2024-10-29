package com.example.takeinshop.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun getShopList(): List<ShopItem>
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(id: Int): ShopItem
}