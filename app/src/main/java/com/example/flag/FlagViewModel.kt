package com.example.flag


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flag.model.DataItem
import com.example.flag.network.FlagApi
import kotlinx.coroutines.launch

enum class FlagApiStatus {LOADING, ERROR, DONE}

class FlagViewModel: ViewModel() {

    private val _status = MutableLiveData<FlagApiStatus>()
    val status:LiveData<FlagApiStatus> = _status

    private val _flagInfo = MutableLiveData<List<DataItem?>>()
    val flagInfo: LiveData<List<DataItem?>> = _flagInfo

    init {
        getInfo()
    }

   fun getInfo(){
        viewModelScope.launch {

            _status.value = FlagApiStatus.LOADING

            try {
                _flagInfo.value = FlagApi.retrofitService.getPhoto().data
                _status.value = FlagApiStatus.DONE
            }catch (e:Exception){
                _status.value=FlagApiStatus.ERROR
                _flagInfo.value = listOf()
            }
        }
    }
}