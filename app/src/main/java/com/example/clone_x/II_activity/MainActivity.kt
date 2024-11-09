package com.example.clone_x.II_activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.clone_x.data.Post
import com.example.clone_x.rv_activity.RecyclerViewActivity

class MainActivity : ComponentActivity() {

    private val postList = List(30) { i -> Post("Username $i", "This is a description for user $i") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(
                postList = postList,
                navigateToRecyclerViewActivity = {
                    startActivity(Intent(this, RecyclerViewActivity::class.java))
                }
            )
        }
    }
}

@Composable
fun MainScreen(postList: List<Post>, navigateToRecyclerViewActivity: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(postList.size) { index ->
                PostItem(post = postList[index])
            }
        }
    }
}

@Composable
fun PostItem(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.DarkGray)
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = post.userName,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 8.dp)
            )
        }

        Text(
            text = post.description ?: "No description available",
            color = Color.LightGray,
            modifier = Modifier.padding(bottom = 8.dp),
            textAlign = TextAlign.Start
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { }) {
                Text("Like")
            }
            Button(onClick = { }) {
                Text("Comment")
            }
            Button(onClick = { }) {
                Text("share")
            }
        }
    }
}
