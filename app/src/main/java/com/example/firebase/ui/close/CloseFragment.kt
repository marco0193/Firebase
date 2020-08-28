package com.example.firebase.ui.close

import Libreria.MemoryData
import ViewModels.LoginViewModels
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.firebase.R
import com.example.firebase.VerifyEmail
import com.google.firebase.auth.FirebaseAuth

class CloseFragment : Fragment() {
    private lateinit var closeViewModel: CloseViewModel
    private var memoryData: MemoryData? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        FirebaseAuth.getInstance().signOut()

        memoryData = MemoryData.getInstance(this.requireContext())
        memoryData!!.saveData("user", "")

        startActivity(
            Intent(requireContext(), VerifyEmail::class.java).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        )
        return null
    }
}