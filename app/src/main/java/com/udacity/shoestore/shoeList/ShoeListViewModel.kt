package com.udacity.shoestore.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeListViewModel: ViewModel() {
    fun addShoe(shoeName: String, companyName: String, shoeSize: String, shoeDescription: String) {
        _shoeList.value?.add(Shoe(shoeName,companyName,shoeSize,shoeDescription))
    }

    companion object {
        private val _shoeList = MutableLiveData<MutableList<Shoe>>().apply {
            val initList = mutableListOf(
                Shoe("Running Shoe 1", "Nike", "10", "Great for jogging"),
                Shoe("Sneaker 1", "Adidas", "9", "Casual and comfortable"),
                Shoe("Boots 1", "Timberland", "11", "Stylish and durable"),
                Shoe("High Heels 1", "Jimmy Choo", "8", "Elegant for formal occasions"),
                Shoe("Sneaker 2", "Puma", "9.5", "Sporty and comfortable"),
                Shoe("Dress Shoe 1", "Clarks", "10.5", "Perfect for business meetings"),
                Shoe("Sandals 1", "Birkenstock", "7", "Great for the beach"),
                Shoe("Running Shoe 2", "New Balance", "10", "Supportive for running"),
                Shoe("Loafer 1", "Gucci", "9", "Luxurious and stylish"),
                Shoe("Boots 2", "Dr. Martens", "11", "Classic and rugged"),
                Shoe("High Heels 2", "Christian Louboutin", "7.5", "Iconic red soles"),
                Shoe("Sneaker 3", "Converse", "8", "Timeless and versatile"),
                Shoe("Dress Shoe 2", "Ecco", "9.5", "Comfortable all day"),
                Shoe("Sandals 2", "Teva", "7", "Perfect for outdoor adventures"),
                Shoe("Running Shoe 3", "Saucony", "8.5", "Optimal support"),
                Shoe("Loafer 2", "Tod's", "10", "Classic Italian design"),
                Shoe("Boots 3", "Caterpillar", "12", "Workwear essentials"),
                Shoe("High Heels 3", "Manolo Blahnik", "6.5", "Icon of style"),
                Shoe("Sneaker 4", "Reebok", "11.5", "Great for workouts"),
                Shoe("Dress Shoe 3", "Hugo Boss", "9", "Sophistication in every step"),
                Shoe("Sandals 3", "Keen", "8", "Outdoor comfort and durability"),
                Shoe("Running Shoe 4", "Brooks", "7.5", "For serious runners"),
                Shoe("Loafer 3", "Salvatore Ferragamo", "10", "Italian elegance"),
                Shoe("Boots 4", "UGG", "8", "Cozy and warm"),
                Shoe("High Heels 4", "Stuart Weitzman", "7", "Timeless beauty"),
                Shoe("Sneaker 5", "Fila", "9.5", "Retro style"),
                Shoe("Dress Shoe 4", "Cole Haan", "11", "Modern and sleek"),
                Shoe("Sandals 4", "Chaco", "7", "For outdoor enthusiasts"),
                Shoe("Running Shoe 5", "Mizuno", "8", "Advanced cushioning"),
                Shoe("Loafer 4", "Prada", "10.5", "Luxury at its finest")
            )
            value = initList
        }


    }
    val shoeList :LiveData<MutableList<Shoe>>
        get() = _shoeList


}