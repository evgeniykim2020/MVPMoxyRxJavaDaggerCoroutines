package com.evgeniykim.mvpmoxyrxjavadaggercoroutines.di

import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.UsersActivity
import dagger.Component

@UserScope
@Component(modules = [UserModule::class])
interface UserComponent {
    fun inject(activity: UsersActivity)
}