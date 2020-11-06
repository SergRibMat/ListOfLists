package com.example.listoflists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel(){

    private val _carList = MutableLiveData<List<Car>>()
    val carList: LiveData<List<Car>>
        get() = _carList


    init {
        _carList.value = createCarsList()
    }

    fun createCarsList(): List<Car>{
        var num = 0
        val carList: MutableList<Car> = arrayListOf()
        val piecesList: MutableList<Piece> = mutableListOf()
        for (x in 0..10){
            carList.add(Car(x, "Car $x"))
        }
        for (x in 0..10){
            piecesList.add(Piece(num, "Piece"))
            num++
        }
        carList.forEach { car ->
            car.pieces = piecesList
        }
        return carList.toList()
    }

    override fun onCleared() {
        super.onCleared()
    }
}