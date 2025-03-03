package com.dija.manase.data.adapter

import com.dija.manase.data.model.MeditateModel
import com.dija.manase.databinding.HomeCardRowBinding
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dija.manase.R

import java.io.ByteArrayOutputStream

class MeditationAdapter(
    private val models: List<MeditateModel>
) : RecyclerView.Adapter<MeditationAdapter.MeditationHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeditationHolder {
        val binding = HomeCardRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeditationHolder(binding)
    }

    override fun onBindViewHolder(holder: MeditationHolder, position: Int) {
        val meditation = models[position]
        holder.bind(meditation)
    }

    override fun getItemCount(): Int = models.size

    inner class MeditationHolder(private val binding: HomeCardRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(meditation: MeditateModel) {
            binding.cardTitleTxt.text = meditation.title
            binding.cardDesTxt.text = meditation.description
            binding.cardImageView.setImageResource(meditation.img)
            binding.cardview.setCardBackgroundColor(Color.parseColor("#FAEDCB"))

            binding.cardview.setOnClickListener {
                val drawable = binding.cardImageView.drawable
                if (drawable is BitmapDrawable) {
                    val bitmap = drawable.bitmap
                    val stream = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                    val bytes = stream.toByteArray()
                    val bundle = bundleOf(
                        "title" to meditation.title,
                        "description" to meditation.description,
                        "image" to bytes
                    )
                    it.findNavController().navigate(R.id.action_mainFragment_to_musicFragment, bundle)
                }
            }
        }
    }
}
