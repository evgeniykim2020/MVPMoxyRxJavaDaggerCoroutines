package com.evgeniykim.mvpmoxyrxjavadaggercoroutines.interectors

import android.content.ContentValues
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.model.User

interface UsersInterector {

    fun loadUsers(load: (List<User>) -> Unit)

    fun addUser(contentValues: ContentValues, complete: () -> Unit)

    fun clearUsers(complete: () -> Unit)
}