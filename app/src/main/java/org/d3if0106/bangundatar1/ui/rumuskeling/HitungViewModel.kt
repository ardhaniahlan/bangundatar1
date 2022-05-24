package org.d3if0106.bangundatar1.ui.rumuskeling

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0106.bangundatar1.db.KelingDao
import org.d3if0106.bangundatar1.db.KelingEntity
import org.d3if0106.bangundatar1.model.hitungKeling
import org.d3if0106.bangundatar1.model.HasilKeling

class HitungViewModel(private val db: KelingDao): ViewModel() {

    private val hasilKeling = MutableLiveData<HasilKeling?>()

    var result = 0f

    fun hasilPerhitungan(jari: String){
        result = 2 * 3.14f * jari.toFloat()

        val dataKeling = KelingEntity(
            jari = result
        )

        hasilKeling.value = dataKeling.hitungKeling()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataKeling)
            }
        }

    }

}