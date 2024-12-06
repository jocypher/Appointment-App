package com.example.appointmentapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appointmentapp.Model.DoctorsModel
import com.example.appointmentapp.Repository.MainRepository

class MainViewModel: ViewModel() {
    private val repository=MainRepository()
    private val doctorsList = MutableLiveData<MutableList<DoctorsModel>>()
     fun loadDoctors():LiveData<MutableList<DoctorsModel>>{
        val data=repository.loadData()
         return data
    }

}