package com.example.opinder.screens.opins

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleFragmentViewModel: ViewModel() {

    init {
        _eventNoOpins.value = false
        _disagreeStat.value = 0
        _neutralStat.value = 0
        _agreeStat.value = 0

    }

    private val _eventNoOpins = MutableLiveData<Boolean>()
    val eventNoOpins: LiveData<Boolean>
        get() = _eventNoOpins

    //Statistics for voting
    private val _disagreeStat = MutableLiveData<Int>()
    val disagreeStat : LiveData<Int>
        get() = _disagreeStat

    private val _neutralStat = MutableLiveData<Int>()
    val neutralStat : LiveData<Int>
        get() = _neutralStat

    private val _agreeStat = MutableLiveData<Int>()
    val agreeStat : LiveData<Int>
        get() = _agreeStat

    override fun onCleared() {
        super.onCleared()
        //TODO on clared action
    }


    private fun nextOpin() {
        //switch to a next opin
        if(opinsList.isEmpty()){
            _eventNoOpins.value = true
        } else {
            _opin.value = _opinsList.removeAt(0)
        }
    }


    fun onDisagree() {
        
//       _disagreeStat.value = (disagreeStat.value)?.plus(1)
//        nextOpin()
    }

    fun onNeutral() {
//        _neutralStat.value = (neutralStat.value)?.plus(1)
//        nextOpin()
    }

    fun onAgree() {
//        _agreeStat.value = (agreeStat.value)?.plus(1)
//        nextOpin()
    }

    fun onNoOpinsComplete() {
        _eventNoOpins.value = false
    }
}