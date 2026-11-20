package com.example.lunchtray.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.lunchtray.model.MenuItem

class OrderViewModel : ViewModel() {
    var entree by mutableStateOf<MenuItem?>(null)
    var sideDish by mutableStateOf<MenuItem?>(null)
    var accompaniment by mutableStateOf<MenuItem?>(null)

    fun resetOrder() {
        entree = null
        sideDish = null
        accompaniment = null
    }

    val subtotal: Double
        get() = (entree?.price ?: 0.0) + (sideDish?.price ?: 0.0) + (accompaniment?.price ?: 0.0)

    val tax: Double
        get() = subtotal * 0.08

    val total: Double
        get() = subtotal + tax
}