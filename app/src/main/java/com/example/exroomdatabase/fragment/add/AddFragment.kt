package com.example.exroomdatabase.fragment.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.exroomdatabase.R
import com.example.exroomdatabase.databinding.FragmentAddBinding
import com.example.exroomdatabase.model.Address
import com.example.exroomdatabase.model.User
import com.example.exroomdatabase.model.UserViewModel
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater , container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.button.setOnClickListener {
            insertRecordInLocalDataBase()
        }
    }

    private fun insertRecordInLocalDataBase() {
        val firstName = binding.editTextTextPersonName.text.toString()
        val secondName = binding.editTextTextPersonName2.text.toString()
        val age = binding.editTextTextPersonName3.text.toString()
        val countryOne = binding.editTextTextPersonName4.text.toString()
        val countryTwo = binding.editTextTextPersonName6.text.toString()
        val cityOne = binding.editTextTextPersonName5.text.toString()
        val cityTwo = binding.editTextTextPersonName7.text.toString()
        if(inputCheck(firstName,secondName,age,countryOne,countryTwo,cityOne,cityTwo)) {
            var addressArray = arrayListOf<Address>()
            addressArray.add(Address(countryOne,cityOne))
            addressArray.add(Address(countryTwo,cityTwo))
            val user = User(0, firstName, secondName,age.toInt(), ArrayList<Address>().apply { add(Address(countryOne,cityOne))
                add(Address(countryOne,cityOne))})
            userViewModel.addUser(user)
            Toast.makeText(context,"Successfully Added",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(context,"Please fill the field",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(
        fName: String,
        lName: String,
        age: String,
        addressOne: String,
        addressTwo: String,
        cityOne: String,
        cityTwo: String
    ) : Boolean{
        if(fName.isBlank() && lName.isBlank() && age.isBlank() && addressOne.isBlank() && addressTwo.isBlank() && cityOne.isBlank() && cityTwo.isBlank()) {
            return false
        }
        return true
    }
}