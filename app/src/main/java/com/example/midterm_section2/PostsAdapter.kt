package com.example.midterm_section2

import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midterm_section2.databinding.PostItemBinding
import com.example.midterm_section2.model.Post
import java.util.Date

class PostHolder(private val binding: PostItemBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        val username = post.user?.username as String
        binding.tvUsername.text = username
        binding.tvDescription.text = post.description
        Log.d("PostHolder", "Timestamp: ${post.creationTimeMs} -> ${Date(post.creationTimeMs)}")
        binding.tvRelativeTime.text = DateUtils.getRelativeTimeSpanString(
            post.creationTimeMs,
            System.currentTimeMillis(),
            DateUtils.MINUTE_IN_MILLIS
        )   }
}
class PostsAdapter(
    private val posts: List<Post>
) : RecyclerView.Adapter<PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PostItemBinding.inflate(inflater, parent,  false)
        return PostHolder(binding)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }
}
