package org.d3if0106.bangundatar1.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import org.d3if0106.bangundatar1.R
import org.d3if0106.bangundatar1.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.rumusKel.setOnClickListener{
            findNavController().navigate(R.id.action_detailFragment_to_kelilingFragment)
        }

        return view
    }


}