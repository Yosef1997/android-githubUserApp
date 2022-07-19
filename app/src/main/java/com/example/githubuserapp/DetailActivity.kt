package com.example.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvImageView: ImageView = findViewById(R.id.tv_imageView)
        val tvUsername: TextView = findViewById(R.id.tv_username_received)
        val tvName: TextView = findViewById(R.id.tv_name_received)
        val tvLocation: TextView = findViewById(R.id.tv_location_received)
        val tvRepository: TextView = findViewById(R.id.tv_repository_received)
        val tvCompany: TextView = findViewById(R.id.tv_company_received)
        val tvFollowers: TextView = findViewById(R.id.tv_followers_received)
        val tvFollowing: TextView = findViewById(R.id.tv_following_received)
        val data = intent.getParcelableExtra<User>("Data")
//        Log.d("Detail Data", data?.name.toString())
        val text = "Username : ${data?.username.toString()},\nName : ${data?.name.toString()},\nLocation : ${data?.location.toString()},\nRepository : ${data?.repository.toString()},\nCompany : ${data?.company.toString()},\nFollowers : ${data?.followers.toString()},\nFollowing : ${data?.following.toString()}"
        tvImageView.setImageResource(data?.avatar!!.toInt())
        tvUsername.text = data?.username.toString()
        tvName.text = data?.name.toString()
        tvLocation.text = data?.location.toString()
        tvRepository.text = data?.repository.toString()
        tvCompany.text = data.company.toString()
        tvFollowers.text = data.followers.toString()
        tvFollowing.text = data.following.toString()
    }
}