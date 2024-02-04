package com.example.exroomdatabase.fragment.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exroomdatabase.R
import com.example.exroomdatabase.databinding.FragmentAddBinding
import com.example.exroomdatabase.databinding.FragmentListBinding
import com.example.exroomdatabase.model.UserViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var recyclerView: RecyclerView
    lateinit var userViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        recyclerView = binding.recyclerView
        userViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            listAdapter = ListAdapter(requireContext(), userList = user)
            recyclerView.adapter = listAdapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }
}