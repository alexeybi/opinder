package com.example.opinder.screens.results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultsFragmentViewModel: ViewModel() {

    private val _eventVoteAgain: MutableLiveData<Boolean>()
    val voteAgain: LiveData<Boolean>
        get() = _eventVoteAgain

    fun voteAgain() {
        _eventVoteAgain.value = true
    }

    fun onVoteEventComplete() {
        _eventVoteAgain.value = false
    }



}