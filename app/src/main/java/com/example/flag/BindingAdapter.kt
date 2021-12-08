package com.example.flag
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.example.flag.model.DataItem

class BindingAdapter {

    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, imgUrl:String?){
        imgUrl.let {
            val imgUri = imgUrl?.toUri()?.buildUpon()?.build()
            Glide.with(imageView)
                .load(imgUri)
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(imageView)
        }
    }

    @BindingAdapter("listData")
    fun bindRecyclerView(recyclerView: RecyclerView,data:List<DataItem>?){
        val adapter = recyclerView.adapter as FlagAdapter
        adapter.submitList(data)
    }

    @BindingAdapter("FlagApiStatus")
    fun bindStatus(statusImageView: ImageView,
                   status: FlagApiStatus?){
        when (status){
            FlagApiStatus.LOADING -> {
                statusImageView.visibility = View.VISIBLE
                statusImageView.setImageResource(R.drawable.loading_animation)
            }
            FlagApiStatus.DONE ->{
                statusImageView.visibility = View.GONE


            }
            FlagApiStatus.ERROR ->{
                statusImageView.visibility = View.VISIBLE
                statusImageView.setImageResource(R.drawable.wifi_dawn)
            }
        }

    }
}