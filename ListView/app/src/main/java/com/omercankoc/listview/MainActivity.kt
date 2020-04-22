package com.omercankoc.listview

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

// Güvensiz Global Değişken
// var selectedGlobalBitmap : Bitmap? = null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Datas
        var languages = ArrayList<String>()
        languages.add("Kotlin")
        languages.add("Swift")
        languages.add("Go")
        languages.add("Rust")

        var years = ArrayList<String>()
        years.add("2011")
        years.add("2014")
        years.add("2009")
        years.add("2009")

        /*
        val kotlin = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kotlin)
        val swift = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.swift)
        val go = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.go)
        val rust = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.rust)
        var images = ArrayList<Bitmap>()
        images.add(kotlin)
        images.add(swift)
        images.add(go)
        images.add(rust)
        */

        val kotlinId : Int = R.drawable.kotlin
        val swiftId : Int = R.drawable.swift
        val goId : Int = R.drawable.go
        val rustId : Int = R.drawable.rust
        var imageIds = ArrayList<Int>()
        imageIds.add(kotlinId)
        imageIds.add(swiftId)
        imageIds.add(goId)
        imageIds.add(rustId)


        // Adapter:  Bir veri kaynagi ile veriye ihtiyaci olan nesnesi birbirine baglayan yapilardir
        // (Layout<->Data)
        // Default adapter (simple_list_item_1) oldugu gibi Custom adapter da tasarlanabilir.
        val adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,languages)
        //val adapter : ArrayAdapter<String> = ArrayAdapter(this,R.layout.custom_list,R.id.textViewListLanguage,languages)
        listView.adapter = adapter

        // List View'daki bir item'e tiklandiginda gerceklesecek operasyon.
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            // MainActivity ile DetailsActivity arasinda Intent olusturma operasyonu.
            val intent = Intent(applicationContext,DetailsActivity::class.java)

            // Intent ile DetailActivity'ye veri gonderme operasyonu.
            intent.putExtra("language",languages[position])
            intent.putExtra("year",years[position])

            // Singleton Yardimi Ile Erisim
            // val singleton = Singleton.Selected
            // singleton.selectedImage = images[position]

            // Image ID'si (Int)
            intent.putExtra("image",imageIds[position])

            startActivity(intent)
        }
    }
}
