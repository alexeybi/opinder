package com.example.opinder.screens.opins

import android.util.Log
import androidx.lifecycle.ViewModel

class TitleFragmentViewModel: ViewModel() {

    init {
        disagreeStat.value = 0
        neutralStat.value = 0
        agreeStat.value = 0

    }

    //Statistics for voting
    var disagreeStat = MutableLiveData<Int>()
    var neutralStat = MutabaleLivedata<Int>()
    var agreeStat = MutableLiveData<Int>()

    override fun onCleared() {
        super.onCleared()
        //TODO on clared action
    }


    private fun nextOpin() {
        //switch to a next opin
        if(opinsList.isEmpty()){
            //TODO navigate to noOpins fragment
        }
    }


    fun onDisagree() {
       disagreeStat.value = (disagreeStat.value)?.plus(1)
        nextOpin()
    }

    fun onNeutral() {
        neutralStat.value = (neutralStat.value)?.plus(1)
        nextOpin()
    }

    fun onAgree() {
        agreeStat.value = (agreeStat.value)?.plus(1)
        nextOpin()
    }
}