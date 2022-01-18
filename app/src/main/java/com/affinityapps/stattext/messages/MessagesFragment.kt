package com.affinityapps.stattext.messages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stattext.databinding.FragmentMessagesBinding
import com.affinityapps.stattext.home.Contacts

class MessagesFragment() : Fragment() {

    private var _binding: FragmentMessagesBinding? = null
    private val binding get() = _binding!!

    private lateinit var messagesData: MessagesData
    private lateinit var recyclerView: RecyclerView
    private lateinit var messagesAdapter: MessagesAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val messagesDataList: MutableList<MessagesData> = ArrayList()
        messagesData = MessagesData("Bob", "304943008", "laaaaaaa")
        messagesDataList.add(messagesData)
        messagesData = MessagesData("Saun", "987987", "ldsfkgndlkf")
        messagesDataList.add(messagesData)
        messagesData = MessagesData("Dave", "987687", "dfskj")
        messagesDataList.add(messagesData)
        messagesData = MessagesData("Sam", "34564356", "lsdkfldkf")
        messagesDataList.add(messagesData)
        messagesData = MessagesData("Jack", "98709877", "sldfjkngldskf")
        messagesDataList.add(messagesData)

        _binding = FragmentMessagesBinding.inflate(inflater, container, false)

        viewManager = LinearLayoutManager(activity)
        messagesAdapter = MessagesAdapter(messagesDataList)

        recyclerView = binding.messagesFragmentRecyclerview.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = messagesAdapter
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}