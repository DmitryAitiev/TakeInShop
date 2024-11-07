package com.example.takeinshop.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.takeinshop.domain.ShopItem
import com.example.takeinshop.domain.ShopListRepository
import kotlin.random.Random

object ShopListRepositoryImpl: ShopListRepository {

    private val liveDataShopList = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf(Comparator<ShopItem> { p0, p1 -> p0.id.compareTo(p1.id)})
    private var autoIncrementID = 0

    init {
        for (i in 0 until 10) {
            val item = ShopItem("Name $i", i, Random.nextBoolean())
            addShopItem(item)
            Log.d("ImplTEST", shopList.size.toString())
        }
    }
    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID)
            shopItem.id = autoIncrementID++
        shopList.add(shopItem)
        updateList()
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return liveDataShopList
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        deleteShopItem(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find { it.id == id } ?: throw RuntimeException("Element with id $id not found")
    }

    private fun updateList() {
        liveDataShopList.value = shopList.toList()
    }
}