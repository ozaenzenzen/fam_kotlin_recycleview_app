package com.example.famrecycleviewapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ActivityItemDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvObject: TextView = findViewById(R.id.tv_object_received)
        val imgPhoto: ImageView = findViewById(R.id.img_item_detail_photo)

        val phone = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Phone>(EXTRA_PERSON, Phone::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Phone>(EXTRA_PERSON)
        }

        if (phone != null) {
            val text = "Name ${phone?.title.toString()}," +
                    "\nEmail: ${phone?.description}," +
                    "\nPrice: ${phone?.price}," +
                    "\nRating: ${phone?.rating}"
            tvObject.text = text
            Picasso.get().load(phone.images[0]).into(imgPhoto);
        }
    }
}