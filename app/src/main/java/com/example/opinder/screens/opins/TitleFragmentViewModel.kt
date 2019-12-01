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

    private var cardIndex: Int

    private val _apiResponseStatus = MutableLiveData<String>()
    val apiResponseStatus:  LiveData<String>
        get() = _apiResponseStatus

    private val _allCards = MutableLiveData<List<OpinderApiProperties>>()
    val allCards: LiveData<List<OpinderApiProperties>>
        get() = _allCards

    private val _card = MutableLiveData<OpinderApiProperties>()
    val card: LiveData<OpinderApiProperties>
        get() = _card

    private val _cardsListSize = MutableLiveData<Int>()
    val cardsListSize: LiveData<Int>
        get() = _cardsListSize

    private val _noCardsLeft = MutableLiveData<Boolean>()
    val noCardsLeft: LiveData<Boolean>
        get() = _noCardsLeft


    //Create coroutine scope which runs using the Main dispatcher
    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getAllCards()
        cardIndex = 0
    }

    private fun getAllCards() {
        coroutineScope.launch {
            var getAllCardsDeferred = OpinderApi.retrofitService.getCards()
            try {
                //Await the completion of the retrofit request
                var listResult = getAllCardsDeferred.await()
                _cardsListSize.value = listResult.size
                if (listResult.size > 0) {
                    _allCards.value = listResult
                    _card.value = listResult[0]
                }
            } catch (e: Exception) {
                _apiResponseStatus.value = "Failure: ${e.message}"
            }
        }
    }

    private fun nextCard() {
        if (cardIndex >= _cardsListSize.value!! - 1) {
            _noCardsLeft.value = true
        } else
            cardIndex += 1
        _card.value = _allCards.value?.elementAt(cardIndex)
    }


    fun onDisagree() {
        nextCard()
    }

    fun onNeutral() {
        nextCard()
    }

    fun onAgree() {
        nextCard()
    }

    fun onNoCardsLeft() {
        _noCardsLeft.value = false
    }

    //Cancel coroutine job when onCleared triggered in ViewModel
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
