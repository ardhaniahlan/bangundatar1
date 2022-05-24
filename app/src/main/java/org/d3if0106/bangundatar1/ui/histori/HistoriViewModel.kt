package org.d3if0106.bangundatar1.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0106.bangundatar1.db.KelingDao

class HistoriViewModel(private val db: KelingDao) : ViewModel() {
    val data = db.getLastKeling()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}