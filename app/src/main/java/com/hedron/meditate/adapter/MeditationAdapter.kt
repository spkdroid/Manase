package com.hedron.meditate.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hedron.meditate.R
import com.hedron.meditate.model.MeditationModel
import java.io.ByteArrayOutputStream


class MeditationAdapter
    (c: Context, models: ArrayList<MeditationModel>) :
    RecyclerView.Adapter<MeditationHolder>() {
    var c: Context = c
    var models //creates a list of array of models
            : List<MeditationModel> = models

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeditationHolder {
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_row, null);
        val view: View = LayoutInflater.from(c).inflate(R.layout.home_card_row, parent, false)
        val vHolder = MeditationHolder(view)

        vHolder.cardView.setOnClickListener {
            val bitmapDrawable =
                vHolder.mImageView.drawable as BitmapDrawable //get image from drawable
            val bitmap = bitmapDrawable.bitmap
            val stream =
                ByteArrayOutputStream() //image will get steam and bytes
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream) // compress image
            val bytes: ByteArray = stream.toByteArray()

            val bundle = bundleOf("title" to  models[vHolder.adapterPosition].title
                ,"description" to models[vHolder.adapterPosition].description
                ,"image" to bytes
            )

            Navigation.findNavController(it)
                .navigate(R.id.action_navigation_home_to_musicFragment, bundle)
        }
        return vHolder //return view to holder class
    }

    override fun onBindViewHolder(holder: MeditationHolder, position: Int) {
        holder.mTitle.text = models[position].title
        holder.mDes.text = models[position].description
        holder.mImageView.setImageResource(models[position].img)
        holder.cardView.setCardBackgroundColor(Color.parseColor("#FAEDCB"))
    }

    override fun getItemCount(): Int {
        return models.size
    }
}

class MeditationHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mImageView: ImageView
    var mTitle: TextView
    var mDes: TextView
    var cardView: CardView

    init {
        mImageView = itemView.findViewById(R.id.cardImageView)
        mTitle = itemView.findViewById(R.id.cardTitleTxt)
        mDes = itemView.findViewById(R.id.cardDesTxt)
        cardView = itemView.findViewById(R.id.cardview)
    }
}