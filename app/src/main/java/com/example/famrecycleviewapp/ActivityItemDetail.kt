package com.example.famrecycleviewapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityItemDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        val phone = if(Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Phone>(EXTRA_PERSON, Phone::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Phone>(EXTRA_PERSON)
        }

        if (phone != null) {
            val text = "Name ${phone?.title.toString()},\nEmail: ${phone?.description},\nPrice: ${phone?.price},\nRating: ${phone?.rating}"
            tvObject.text = text
        }
    }
}