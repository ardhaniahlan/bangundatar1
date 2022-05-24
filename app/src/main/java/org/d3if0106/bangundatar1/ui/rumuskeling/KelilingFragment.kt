package org.d3if0106.bangundatar1.ui.rumuskeling

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import org.d3if0106.bangundatar1.R
import org.d3if0106.bangundatar1.databinding.FragmentKelilingBinding
import org.d3if0106.bangundatar1.db.KelingDb

class KelilingFragment : Fragment() {

    private lateinit var binding: FragmentKelilingBinding
    private lateinit var hitungViewModel : HitungViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentKelilingBinding.inflate(inflater, container, false)
        val view = binding.root

        hitungViewModel = viewModel

        binding.btnBagikan?.setOnClickListener { shareData() }

//        Hasil Keliling
        binding.btnHitung.setOnClickListener{
            val jari = binding.jarijari.text.toString()

            when {
                jari.isEmpty() -> binding.jarijari.error = "Masukan Angka"
                else -> {
                    hitungViewModel.hasilPerhitungan(jari)
                    keliling()
                }
            }
        }

//        Nav
        binding.switchMode.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_NO)
        }


        return view
    }

    private val viewModel: HitungViewModel by lazy {
        val db = KelingDb.getInstance(requireContext())
        val factory = HitungViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HitungViewModel::class.java]
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun shareData() {

        val message = getString(
            R.string.bagikan_template,
            binding.hasilPerhitunganKel.text,
            binding.jarijari.text
        )

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null) {
            startActivity(shareIntent)
        }

    }

    private fun keliling(){
        binding.hasilPerhitunganKel.text = hitungViewModel.result.toString()
    }


}