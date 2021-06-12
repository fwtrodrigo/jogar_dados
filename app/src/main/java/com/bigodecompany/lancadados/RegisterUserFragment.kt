package com.bigodecompany.lancadados

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bigodecompany.lancadados.databinding.FragmentRegisterUserBinding

class RegisterUserFragment : Fragment() {
    private var binding: FragmentRegisterUserBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegisterUserBinding.inflate(inflater, container, false)

        val edtPlayerName = binding?.edtPlayerName
        val btnRegister = binding?.btnRegister

        btnRegister?.setOnClickListener {
            val playerName = edtPlayerName?.text.toString()

//            btnRegister.setOnClickListener {
//                MainActivity.open(requireContext(), playerName)
//            }
        }

        return binding?.root
    }

}