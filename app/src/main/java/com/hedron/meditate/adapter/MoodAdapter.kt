package com.hedron.meditate.adapter

import android.content.Context
import android.graphics.Color
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import com.hedron.meditate.R
import com.hedron.meditate.model.MoodModel


/**
 *
 *   Adapter is the declaration of the recyclerview list item
 *
 */
class MoodViewAdapter(private val mContext: Context, private val mData: List<MoodModel>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<MoodViewAdapter.MoodViewHolder>() {

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val view: View
        val mInflater = LayoutInflater.from(mContext)
        view = mInflater.inflate(R.layout.mood_card_row, parent, false)
        return MoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {

        //val  = mData[position].imageUrl
        val moodTitle = mData[position].type
        val moodDescription = mData[position].description
        val moodDate = mData[position].date

       // Picasso.get()
       //     .load(offerUrl)
       //     .placeholder(R.drawable.ic_launcher_background)
       //     .error(R.drawable.ic_launcher_background)
       //     .into(holder.offerImage)

        holder.moodImage.setImageResource(R.drawable.happy_emotion)
        holder.moodTitleText.text = moodTitle
        holder.moodDescriptionText.text = moodDescription
        holder.moodDate.text = moodDate
    }

    interface ClickListener {
        fun onClick(view: View, position: Int)
    }

    internal class RecyclerTouchListener(
        context: Context,
        private val clicker: ClickListener?
    ) : androidx.recyclerview.widget.RecyclerView.OnItemTouchListener {
        private val gestureDetector: GestureDetector =
            GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    return true
                }
            })

        override fun onInterceptTouchEvent(rv: androidx.recyclerview.widget.RecyclerView, e: MotionEvent): Boolean {
            val child = rv.findChildViewUnder(e.x, e.y)
            if (child != null && clicker != null && gestureDetector.onTouchEvent(e)) {
                clicker.onClick(child, rv.getChildAdapterPosition(child))
            }
            return false
        }

        override fun onTouchEvent(rv: androidx.recyclerview.widget.RecyclerView, e: MotionEvent) {

        }

        override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

        }
    }

    class MoodViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        internal var moodImage:ImageView = itemView.findViewById(R.id.moodImage) as ImageView
        internal var moodTitleText:TextView = itemView.findViewById(R.id.moodTitleText) as TextView
        internal var moodDescriptionText:TextView = itemView.findViewById(R.id.moodDescriptionText) as TextView
        internal var moodDate:TextView = itemView.findViewById(R.id.moodDate) as TextView
    }
}