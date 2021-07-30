package com.evgeniykim.mvpmoxyrxjavadaggercoroutines

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.adapter.UserAdapter
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.model.User
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.mvp.UsersPresenter
import com.evgeniykim.mvpmoxyrxjavadaggercoroutines.mvp.UsersView
import kotlinx.android.synthetic.main.activity_single.*
import javax.inject.Inject

class UsersActivity: MvpAppCompatActivity(), UsersView {

    @Inject
    @InjectPresenter
    lateinit var presenter: UsersPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    @Inject
    lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.component.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_single)
        init()
    }

    private fun init() {
        addButton.setOnClickListener{ presenter.add() }
        clearButton.setOnClickListener { presenter.clear() }

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerViewList.layoutManager = layoutManager
        recyclerViewList.adapter = userAdapter

        presenter.loadUsers()
    }


    override fun updateUserDate() {
        presenter.updateUserDate(nameEditText.text.toString(),
        emailEditText.text.toString())
    }

    override fun showUsers(users: List<User>) {
        userAdapter.setData(users)
    }

    override fun showToast(resId: Int) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }
}