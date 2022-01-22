package com.affinityapps.stattext.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.affinityapps.stattext.databinding.FragmentHomeBinding
import android.content.SharedPreferences




class HomeFragment() : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var contacts: Contacts
    private lateinit var recyclerView: RecyclerView
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val contactsDataList: MutableList<Contacts> = ArrayList()
        contacts = Contacts("Bob", "304943008")
        contactsDataList.add(contacts)
        contacts = Contacts("Saun", "987987")
        contactsDataList.add(contacts)
        contacts = Contacts("Dave", "987687")
        contactsDataList.add(contacts)
        contacts = Contacts("Sam", "34564356")
        contactsDataList.add(contacts)
        contacts = Contacts("Jack", "98709877")
        contactsDataList.add(contacts)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewManager = LinearLayoutManager(activity)
        homeAdapter = HomeAdapter(contactsDataList)

        recyclerView = binding.homeFragmentRecyclerview.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = homeAdapter
        }
        return binding.root
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}