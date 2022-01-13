package com.example.recyclerview_animation_13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        val users = addedUserList()
        refreshAdapter(users)

    }

    private fun initViews() {
        val animation = AnimationUtils.loadLayoutAnimation(this,R.anim.layout_from_right)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutAnimation = animation
    }

    private fun refreshAdapter(users: ArrayList<User>) {
        val adapter = CustomAdapter(this, users)
        recyclerView.adapter = adapter
    }

    private fun addedUserList(): ArrayList<User> {

        val users = ArrayList<User>()

        for (i in 0..30) {
            users.add(User("Android", "$i"))
        }
        return users
    }
}