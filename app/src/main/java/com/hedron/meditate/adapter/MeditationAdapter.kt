package com.hedron.meditate.adapter

import android.content.Context
import android.graphics.Color
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

        vHolder.cardView.setOnClickListener { /*
                        val gTitle = models[vHolder.getAdapterPosition()].title
                        val gDes = models[vHolder.getAdapterPosition()].description
                        val bitmapDrawable =
                            vHolder.mImageView.getDrawable() as BitmapDrawable //get image from drawable
                        val bitmap = bitmapDrawable.bitmap
                        val stream =
                            ByteArrayOutputStream() //image will get steam and bytes
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream) // compress image
                        val bytes: ByteArray = stream.toByteArray()

                        //intent to meditation activity
                        val intent = Intent(c, MeditationActivity::class.java)
                        intent.putExtra("iTitle", gTitle)
                        intent.putExtra("iDes", gDes)
                        intent.putExtra("iImage", bytes)
                        c.startActivity(intent) */
            val bundle = bundleOf("offer_id" to  models[vHolder.adapterPosition].title)
            Navigation.findNavController(it)
                .navigate(R.id.action_navigation_home_to_musicFragment, bundle)
        }
        return vHolder //return view to holder class
    }

    override fun onBindViewHolder(holder: MeditationHolder, position: Int) {
        holder.mTitle.setText(models[position].title)
        holder.mDes.setText(models[position].description)
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