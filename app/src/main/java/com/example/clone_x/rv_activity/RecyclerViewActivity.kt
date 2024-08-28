package com.example.clone_x.rv_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_x.R
import com.example.clone_x.data.Post
import com.example.clone_x.rv_activity.adapters.RVAdapterPosts

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvPosts: RecyclerView
    private val postList = arrayListOf<Post>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        fillPostList()
        initViews()
    }

    private fun initViews() {
        rvPosts = findViewById(R.id.rv_posts)
        rvPosts.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = RVAdapterPosts(postList)
        }
    }

    private fun fillPostList() {
        for (i in 0 until 10) {
            postList.add(Post("Username $i"))
        }
    }
}