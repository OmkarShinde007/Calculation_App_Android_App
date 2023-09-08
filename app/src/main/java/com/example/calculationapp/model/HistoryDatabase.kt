package com.example.calculationapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/** Class used to create and get the instance of the database. */
@Database(entities = [HistoryDataClass::class], version = 1)
abstract class HistoryDatabase : RoomDatabase() {
    abstract fun getDao(): HistoryDao

    companion object {
        @Volatile
        private var INSTANCE: HistoryDatabase? = null

        /** Method used create instance of the database. */
        fun getDatabase(context: Context): HistoryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, HistoryDatabase::class.java, "todo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }

}