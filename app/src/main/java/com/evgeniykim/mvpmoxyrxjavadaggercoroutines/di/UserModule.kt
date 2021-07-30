package com.evgeniykim.mvpmoxyrxjavadaggercoroutines.di

import android.content.Context
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.adapter.UserAdapter
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.database.DbHelper
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.interectors.UsersInteractorImpl
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.interectors.UsersInterector
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.model.UserData
import dagger.Module
import dagger.Provides

@Module
class UserModule(private val context: Context) {

    @Provides
    @UserScope
    fun provideContext() = context

    @Provides
    @UserScope
    fun provideDbHelper() = DbHelper(context)

    @Provides
    @UserScope
    fun provideUsersInterector(dbHelper: DbHelper): UsersInterector = UsersInteractorImpl(dbHelper)

    @Provides
    @UserScope
    fun provideUserAdapter() = UserAdapter()

    @Provides
    @UserScope
    fun provideUserData() = UserData()
}