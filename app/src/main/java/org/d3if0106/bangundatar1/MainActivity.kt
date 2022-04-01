package org.d3if0106.bangundatar1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import org.d3if0106.bangundatar1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener{
            keliling()
        }

        binding.switchMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked)
                AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_YES)
            else
                AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun keliling(){

        val jari = binding.jarijari.text.toString()
        if (TextUtils.isEmpty(jari)){
            Toast.makeText(this, "Tidak Boleh Kosong", Toast.LENGTH_LONG).show()
            return
        }

        val hasil = 2 * 3.14 * jari.toFloat()

        binding.hasilPerhitunganKel.text = getString(R.string.hasil, hasil)

    }

}