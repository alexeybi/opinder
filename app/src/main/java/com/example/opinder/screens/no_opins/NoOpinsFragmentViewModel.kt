package com.example.opinder.screens.no_opins

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoOpinsFragmentViewModel : ViewModel() {

    private val _voted = MutableLiveData<Boolean>()
    val voted: LiveData<Boolean>
        get() = _voted

    init {
        _voted.value = false
    }

    fun onHasVoted() {
        _voted.value = true
    }

    override fun onCleared() {
        super.onCleared()
    }
}