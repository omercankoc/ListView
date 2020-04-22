package com.omercankoc.listview

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Definition and Initialize
        val textViewLanguage : TextView = findViewById(R.id.textViewLanguage)
        val textViewYear : TextView = findViewById(R.id.textViewYear)
        val imageViewLogo : ImageView = findViewById(R.id.imageViewLogo)

        // Intent ile MainActivity'den gonderilen verileri alma operasyonu.
        val intent = intent
        val language : String = intent.getStringExtra("language")
        val year : String = intent.getStringExtra("year")

        // gerekli alanlara verileri aktarma operasyonu.
        textViewLanguage.text = language
        textViewYear.text = year

        // Singleton Yardimi Ile Erisim
        // val singleton = Singleton.Selected
        // val selectedBitmap = singleton.selectedImage
        // imageViewLogo.setImageBitmap(selectedBitmap)

        //
        val imageId : Int = intent.getIntExtra("image",0)
        val selectedBitmap = BitmapFactory.decodeResource(applicationContext.resources,imageId)
        imageViewLogo.setImageBitmap(selectedBitmap)
    }
}

