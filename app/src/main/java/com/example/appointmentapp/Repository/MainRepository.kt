package com.example.appointmentapp.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appointmentapp.Model.DoctorsModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class MainRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

     fun loadData():LiveData<MutableList<DoctorsModel>>{
        val listData = MutableLiveData<MutableList<DoctorsModel>>()
        val ref = firebaseDatabase.getReference("Doctors")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<DoctorsModel>()
                for (snap in snapshot.children){
                    val item = snap.getValue(DoctorsModel::class.java)
                    item?.let {
                        lists.add(it)
                    }
                    listData.value=lists
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
         Log.i("data",listData.toString())
        return listData
    }
}