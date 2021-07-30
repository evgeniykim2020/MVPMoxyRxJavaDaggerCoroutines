package com.evgeniykim.mvpmoxyrxjavadaggercoroutines.mvp

import android.content.ContentValues
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.R
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.database.UserTable
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.interectors.UsersInteractorImpl
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.interectors.UsersInterector
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.model.UserData
import javax.inject.Inject

@InjectViewState
class UsersPresenter @Inject constructor(
    private val usersInterector: UsersInterector,
    private val userData: UserData
) : MvpPresenter<UsersView>(){

    fun loadUsers() {
        usersInterector.loadUsers { viewState.showUsers(it) }
    }

    fun add() {
        viewState.updateUserDate()
        if (userData.name.isEmpty() || userData.email.isEmpty()) {
            viewState.showToast(R.string.empty_values)
            return
        }

        val contentValues = ContentValues(2)
        contentValues.put(UserTable.Column.NAME, userData.name)
        contentValues.put(UserTable.Column.EMAIL, userData.email)

        viewState.showProgress()
        usersInterector.addUser(contentValues) {
            viewState.hideProgress()
            loadUsers()
        }
    }

    fun clear() {
        viewState.showProgress()
        usersInterector.clearUsers {
            viewState.hideProgress()
            loadUsers()
        }
    }

    fun updateUserDate(name: String, email: String) {
        userData.name = name
        userData.email = email
    }
}