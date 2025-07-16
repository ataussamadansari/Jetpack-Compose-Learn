package com.example.contactappjc.repositories

import com.example.contactappjc.dao.ContactDao
import com.example.contactappjc.entity.Contact
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val contactDao: ContactDao) {

    val allContacts: Flow<List<Contact>> = contactDao.getAllContact()

    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }

    suspend fun update(contact: Contact) {
        contactDao.update(contact)
    }
    suspend fun delete(contact: Contact) {
        contactDao.delete(contact)
    }
}