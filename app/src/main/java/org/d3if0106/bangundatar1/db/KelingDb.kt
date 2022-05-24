package org.d3if0106.bangundatar1.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [KelingEntity::class], version = 1, exportSchema = false)
abstract class KelingDb : RoomDatabase() {
    abstract val dao: KelingDao
    companion object {
        @Volatile
        private var INSTANCE: KelingDb? = null
        fun getInstance(context: Context): KelingDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        KelingDb::class.java,
                        "keling.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}