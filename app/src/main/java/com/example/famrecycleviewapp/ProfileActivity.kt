package com.example.famrecycleviewapp

import android.app.ActionBar
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class ProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PROFILE = "extra_profile"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val aboutPhoto: ImageView = findViewById(R.id.about_photo)
        val aboutName: TextView = findViewById(R.id.about_name)
        val aboutEmail: TextView = findViewById(R.id.about_email)

        val profileData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Profile>(ProfileActivity.EXTRA_PROFILE, Profile::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Profile>(ProfileActivity.EXTRA_PROFILE)
        }

        if (profileData != null) {
            aboutName.text = profileData.name
            aboutEmail.text = profileData.email
//            Picasso.get().load(profileData.picture).into(aboutPhoto)
            Picasso.get().load(profileData.picture).into(aboutPhoto)
        }
    }

}