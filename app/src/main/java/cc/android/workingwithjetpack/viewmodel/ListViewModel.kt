package cc.android.workingwithjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cc.android.workingwithjetpack.model.DogBreed

class ListViewModel : ViewModel() {

    val dogs = MutableLiveData<List<DogBreed>>()
    val dogsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){

        val dog1 = DogBreed("1" , "Corgi" , "15 years" , "breed Group", "breegFor" ,"temperament" , "");
        val dog2 = DogBreed("1" , "Labrador" , "15 years" , "breed Group", "breegFor" ,"temperament" , "");
        val dog3 = DogBreed("1" , "Rotweiler" , "15 years" , "breed Group", "breegFor" ,"temperament" , "");3

        val doglist =  arrayListOf<DogBreed>(dog1 , dog2, dog3)
        dogs.value = doglist
        dogsLoadError.value = false
        loading.value = false
    }

}