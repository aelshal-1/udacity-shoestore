package com.udacity.shoestore.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeListViewModel: ViewModel() {
    fun addShoe(shoeName: String, companyName: String, shoeSize: Int, shoeDescription: String) {
        _shoeList.value?.add(Shoe(shoeName,companyName,shoeSize,shoeDescription))
    }

    companion object {
        private val _shoeList = MutableLiveData<MutableList<Shoe>>().apply {
            val initList = mutableListOf(
                Shoe("Sneakers", "Nike", 9, "Comfortable athletic shoes"),
                Shoe("Loafers", "Gucci", 10, "Stylish and comfortable slip-ons"),
                Shoe("High Heels", "Jimmy Choo", 8, "Elegant and fashionable heels"),
                Shoe("Boots", "Timberland", 7, "Durable outdoor boots"),
                Shoe("Flats", "Tory Burch", 8, "Casual and chic flat shoes"),
                Shoe("Oxfords", "Cole Haan", 10, "Classic lace-up dress shoes"),
                Shoe("Athletic Shoes", "Adidas", 9, "Performance sports shoes"),
                Shoe("Espadrilles", "Toms", 8, "Casual canvas shoes with rope soles"),
                Shoe("Moccasins", "Minnetonka", 7, "Soft and comfy slip-on shoes"),
                Shoe("Pumps", "Christian Louboutin", 7, "Iconic red-soled high heels"),
                Shoe("Flip-Flops", "Havaianas", 6, "Simple and stylish beach sandals"),
                Shoe("Sandals", "Birkenstock", 8, "Orthopedic and comfortable sandals"),
                Shoe("Wedge Heels", "Steve Madden", 9, "Heeled shoes with wedge soles"),
                Shoe("Ankle Boots", "Dr. Martens", 7, "Sturdy leather boots"),
                Shoe("Clogs", "Crocs", 6, "Lightweight and comfy clogs"),
                Shoe("Wingtips", "Florsheim", 10, "Classic brogue-style dress shoes"),
                Shoe("Chukka Boots", "Clarks", 8, "Casual and versatile boots"),
                Shoe("Rain Boots", "Hunter", 7, "Waterproof boots for rainy days"),
                Shoe("Thong Sandals", "Rainbow", 9, "Leather flip-flops with arch support"),
                Shoe("Slingbacks", "Prada", 8, "Heeled shoes with an adjustable strap")
            )
            value = initList
        }


    }
    val shoeList :LiveData<MutableList<Shoe>>
        get() = _shoeList


}