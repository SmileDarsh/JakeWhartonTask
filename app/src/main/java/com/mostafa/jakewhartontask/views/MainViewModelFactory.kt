package com.mostafa.jakewhartontask.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mostafa.jakewhartontask.data.DataManger
import javax.inject.Inject

/**
 * Created by µðšţãƒâ ™ on 10/14/2019.
 *  ->
 */
class MainViewModelFactory  @Inject constructor(val dataManager: DataManger) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MainViewModel(dataManager) as T
}
