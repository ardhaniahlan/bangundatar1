package org.d3if0106.bangundatar1.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KelingDao {
    @Insert
    fun insert(keling: KelingEntity)
    @Query("SELECT * FROM keling ORDER BY id ASC")
    fun getLastKeling(): LiveData<List<KelingEntity>>
    @Query("DELETE FROM keling")
    fun clearData()

}