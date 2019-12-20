package cc.android.workingwithjetpack.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cc.android.workingwithjetpack.model.DogBreed

class DetailViewModel : ViewModel() {

    val dogLiveData =  MutableLiveData<DogBreed> ();

    fun fetch(){

        val dog = DogBreed("1", "Corgi", "15 years", "breed Group", "breedFor", "temperament", "");
        dogLiveData.value = dog
    }

}