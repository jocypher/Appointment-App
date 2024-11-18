package com.example.appointmentapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appointmentapp.Adapter.NearbyDoctorsAdapter
import com.example.appointmentapp.R
import com.example.appointmentapp.ViewModel.MainViewModel
import com.example.appointmentapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNearByDoctor()

    }
    private  fun initNearByDoctor(){
        binding.apply {
            progressBar.visibility = View.VISIBLE
            viewModel.loadDoctors().observe(this@MainActivity, Observer {
                topView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                topView.adapter = NearbyDoctorsAdapter(it)
                progressBar.visibility=View.GONE
            })

        }
    }
}