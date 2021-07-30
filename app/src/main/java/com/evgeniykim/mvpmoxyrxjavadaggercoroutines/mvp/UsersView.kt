package com.evgeniykim.mvpmoxyrxjavadaggercoroutines.mvp

import com.arellomobile.mvp.MvpView
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.model.User

interface UsersView: MvpView {

    fun updateUserDate()

    fun showUsers(users: List<User>)

    fun showToast(resId: Int)

    fun showProgress()

    fun hideProgress()
}