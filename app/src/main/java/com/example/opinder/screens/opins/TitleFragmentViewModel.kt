package com.example.opinder.screens.opins

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.opinder.network.OpinderApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TitleFragmentViewModel: ViewModel() {

//    private val _eventNoOpins = MutableLiveData<Boolean>()
//    val eventNoOpins: LiveData<Boolean>
//        get() = _eventNoOpins
//
//    //Statistics for voting
//    private val _disagreeStat = MutableLiveData<Int>()
//    val disagreeStat : LiveData<Int>
//        get() = _disagreeStat
//
//    private val _neutralStat = MutableLiveData<Int>()
//    val neutralStat : LiveData<Int>
//        get() = _neutralStat
//
//    private val _agreeStat = MutableLiveData<Int>()
//    val agreeStat : LiveData<Int>
//        get() = _agreeStat

    private val _apiResponse = MutableLiveData<String>()
    val apiResponse:  LiveData<String>
        get() = _apiResponse

//    private fun nextOpin() {
//        if(opinsList.isEmpty()){
//            _eventNoOpins.value = true
//        } else {
//            _opin.value = _opinsList.removeAt(0)
//        }
//    }

    init {
        getAllCards()
    }

    private fun getAllCards() {
        OpinderApi.retrofitService.getOpins().enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _apiResponse.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _apiResponse.value = response.body()
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        //TODO on clared action
    }

//    fun onNoOpinsComplete() {
//        _eventNoOpins.value = false
//    }

    fun onDisagree() {
//        nextOpin()
    }

    fun onNeutral() {
//        nextOpin()
    }

    fun onAgree() {
//        nextOpin()
    }
}
