package com.evgeniykim.mvpmoxyrxjavadaggercoroutines

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_choose.*

class ChooseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        activityButton.setOnClickListener { startActivity(Intent(this, SingleActivity::class.java)) }

        mvpButton.setOnClickListener { startActivity(Intent(this, UsersActivity::class.java)) }
    }
}