package com.example.appointmentapp.Activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.appointmentapp.Model.DoctorsModel
import com.example.appointmentapp.R
import com.example.appointmentapp.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var item:DoctorsModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getBundle()
    }

    private fun getBundle() {
        item = intent.getParcelableExtra("object")!!
        binding.apply {
            specialText.text=item.Special
            patientsTxt.text=item.Patiens
            bioTxt.text=item.Biography
            addressTxt.text=item.Address
            tmeTxt.text =item.Time
            dateTxt.text=item.Date

            expTxt.text=item.Expriense.toString()+" Years"
            ratingsTxt.text="${item.Rating}"
            backBtn.setOnClickListener {
                finish()
            }
            websiteBtn.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(item.Site))
                startActivity(i)
            }

            messageBtn.setOnClickListener {
                val uri = Uri.parse("sms to:${item.Mobile}")
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", "the sms text is this")
                startActivity(intent)
            }

            callBtn.setOnClickListener {
                val uri = "tel:${item.Mobile.trim()}"
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse(uri))
                startActivity(intent)
            }

            directionBtn.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.Location))
                startActivity(intent)
            }
            shareBtn.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.setType("text/plain")
                intent.putExtra(Intent.EXTRA_SUBJECT, item.Name)
                intent.putExtra(Intent.EXTRA_TEXT, item.Name+" "+item.Address+" "+item.Mobile)
                startActivity(Intent.createChooser(intent,"Choose One"))
            }

            Glide.with(this@DetailActivity).load(item.Picture).into(doctorImg)

        }
    }
}