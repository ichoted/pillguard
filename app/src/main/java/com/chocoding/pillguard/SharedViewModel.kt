package com.chocoding.pillguard

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _medicinePhoto = MutableLiveData<Bitmap>()
    val medicinePhoto: LiveData<Bitmap> get() = _medicinePhoto

    fun setMedicinePhoto(photo: Bitmap) {
        _medicinePhoto.value = photo
    }
}
