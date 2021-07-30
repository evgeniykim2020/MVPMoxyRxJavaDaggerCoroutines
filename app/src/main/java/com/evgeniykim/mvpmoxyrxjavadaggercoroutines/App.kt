package com.evgeniykim.mvpmoxyrxjavadaggercoroutines

import android.app.Application
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.di.UserComponent
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.di.DaggerUserComponent
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.di.UserModule

class App: Application() {

    lateinit var component: UserComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerUserComponent
                .builder()
                .userModule(UserModule(this))
                .build()
    }

    companion object {
        lateinit var instance: App private set
    }
}