package com.example.clone_x.rv_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.clone_x.data.Post

class RecyclerViewActivity : ComponentActivity() {

    private val postList = List(10) { i -> Post("Username $i", "Post Username $i") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerViewScreen(postList = postList)
        }
    }
}

@Composable
fun RecyclerViewScreen(postList: List<Post>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(postList) { post ->
            PostRowItem(post = post)
        }
    }
}

@Composable
fun PostRowItem(post: Post) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = post.userName)
    }
}
