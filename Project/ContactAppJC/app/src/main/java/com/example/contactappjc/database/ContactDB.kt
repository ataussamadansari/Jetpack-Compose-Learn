package com.example.contactappjc.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactappjc.dao.ContactDao
import com.example.contactappjc.entity.Contact

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDB: RoomDatabase() {
    abstract fun contactDao() : ContactDao

}