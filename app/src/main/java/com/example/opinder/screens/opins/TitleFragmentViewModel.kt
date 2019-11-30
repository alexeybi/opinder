package com.example.opinder.screens.opins

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.opinder.network.OpinderApi
import com.example.opinder.network.OpinderApiProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

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

    private val _apiResponseStatus = MutableLiveData<String>()
    val apiResponseStatus:  LiveData<String>
        get() = _apiResponseStatus

    private val _allCards = MutableLiveData<List<OpinderApiProperties>>()
    val allCards: LiveData<List<OpinderApiProperties>>
        get() = _allCards

    private val _card = MutableLiveData<OpinderApiProperties>()
    val card: LiveData<OpinderApiProperties>
        get() = _card

//    private fun nextOpin() {
//        if(opinsList.isEmpty()){
//            _eventNoOpins.value = true
//        } else {
//            _opin.value = _opinsList.removeAt(0)
//        }
//    }
    //Create coroutine scope which runs using the Main dispatcher
    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getAllCards()
    }

    private fun getAllCards() {
        coroutineScope.launch {
            var getCardsDeferred = OpinderApi.retrofitService.getOpins()
            try {
                //Await the completion of the retrofit request
                var listResult = getCardsDeferred.await()
                _apiResponseStatus.value = "Success: ${listResult.size} Opins retrieved"
                if (listResult.size > 0) {
                    _allCards.value = listResult
                    _card.value = listResult[0]
                }
            } catch (e: Exception) {
                _apiResponseStatus.value = "Failure: ${e.message}"
            }
        }
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

    //Cancel coroutine job when onCleared triggered in ViewModel
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
