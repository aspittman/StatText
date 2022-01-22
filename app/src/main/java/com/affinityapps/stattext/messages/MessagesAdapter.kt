package com.affinityapps.stattext.messages

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stattext.databinding.MessageListItemsBinding

class MessagesAdapter (private val messagesFragmentArrayList: List<MessagesData>,
) :
    RecyclerView.Adapter<MessagesAdapter.MessagesFragmentViewHolder>() {
    private lateinit var listener: OnMessagesItemClickListener
    private var rowIndex: Int = -1

    interface OnMessagesItemClickListener {
        fun onMessagesItemClick(position: Int)
    }

    inner class MessagesFragmentViewHolder(binding: MessageListItemsBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        var messagesLinearLayout: CardView = binding.messagesCardView
        var dateTextView: TextView = binding.dataDate
        var timeTextView: TextView = binding.dataTime
        var messageTextView: TextView = binding.dataMessage

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onMessagesItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessagesAdapter.MessagesFragmentViewHolder {
        return MessagesFragmentViewHolder(
            MessageListItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(
        holder: MessagesAdapter.MessagesFragmentViewHolder,
        position: Int
    ) {
        val messages: MessagesData = messagesFragmentArrayList[position]
        holder.dateTextView.text = messages.date
        holder.timeTextView.text = messages.time
        holder.messageTextView.text = messages.message


        holder.messagesLinearLayout.setOnClickListener {
            rowIndex = holder.adapterPosition
            notifyDataSetChanged()
        }

        if (rowIndex == position) {
            holder.messagesLinearLayout.setBackgroundColor(Color.parseColor("#03DAC5"))
            holder.dateTextView.setTextColor(Color.parseColor("#ffffff"))
            holder.timeTextView.setTextColor(Color.parseColor("#ffffff"))
            holder.messageTextView.setTextColor(Color.parseColor("#ffffff"))

        } else {
            holder.messagesLinearLayout.setBackgroundColor(Color.parseColor("#6200EE"))
            holder.dateTextView.setTextColor(Color.parseColor("#ffffff"))
            holder.timeTextView.setTextColor(Color.parseColor("#ffffff"))
            holder.messageTextView.setTextColor(Color.parseColor("#ffffff"))
        }
    }


    override fun getItemCount() = messagesFragmentArrayList.size
}

