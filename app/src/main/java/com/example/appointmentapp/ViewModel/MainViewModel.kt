package com.example.appointmentapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.appointmentapp.Model.DoctorsModel
import com.example.appointmentapp.Repository.MainRepository

class MainViewModel:ViewModel() {
    private val repository=MainRepository()

     fun loadDoctors():LiveData<MutableList<DoctorsModel>>{
        return repository.loadData()
    }


}