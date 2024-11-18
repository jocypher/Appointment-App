package com.example.appointmentapp.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.appointmentapp.Model.DoctorsModel
import com.example.appointmentapp.databinding.ViewholderNearbyDoctorBinding

class NearbyDoctorsAdapter(private val items:MutableList<DoctorsModel>):RecyclerView.Adapter<NearbyDoctorsAdapter.Viewholder>(){
    private var context:Context?=null
    class Viewholder( val binding: ViewholderNearbyDoctorBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        return Viewholder(ViewholderNearbyDoctorBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.binding.nameTxt.text = items[position].Name
        holder.binding.costTxt.text=items[position].Cost
        holder.binding.specialTxt.text=items[position].Special

        Glide.with(holder.itemView.context).load(items[position].Picture).apply {
            RequestOptions().transform(CenterCrop())
        }.into(holder.binding.img)
    }
}