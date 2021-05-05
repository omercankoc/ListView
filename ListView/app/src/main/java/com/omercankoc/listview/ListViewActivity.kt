package com.omercankoc.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

// ! Güvensiz Global Değişken !
// var selectedGlobalBitmap : Bitmap? = null

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        // Static verileri olustur.
        var languages = ArrayList<String>()
        languages.add("Kotlin")
        languages.add("Swift")
        languages.add("Go")
        languages.add("Rust")

        // Static verileri olustur.
        var years = ArrayList<String>()
        years.add("2011")
        years.add("2014")
        years.add("2009")
        years.add("2009")

        /* Singleton ile Bitmap kullanarak liste olustur. (1.YOL)
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

        // Image ID'leri kullanarak liste olustur. (2.YOL)
        val kotlinId : Int = R.drawable.kotlin
        val swiftId : Int = R.drawable.swift
        val goId : Int = R.drawable.go
        val rustId : Int = R.drawable.rust
        var imageIds = ArrayList<Int>()
        imageIds.add(kotlinId)
        imageIds.add(swiftId)
        imageIds.add(goId)
        imageIds.add(rustId)


        // Adapter : Bir veri kaynagi ile veriye ihtiyaci olan nesneyi birbirine baglayan yapilardir.
        // Default Adapter :
        val adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,languages)
        // Custom Adapter :
        // val adapter : ArrayAdapter<String> = ArrayAdapter(this,R.layout.custom_list,R.id.textViewListLanguage,languages)
        listView.adapter = adapter

        // List View'daki bir item'e tiklandiginda o veriye ait detaya git.
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            // MainActivity ile DetailsActivity arasinda Intent olustur.
            val intent = Intent(applicationContext,DetailsActivity::class.java)

            // Intent ile secilen itemin detaylarini DetailActivity'ye gonder.
            intent.putExtra("language",languages[position])
            intent.putExtra("year",years[position])

            // Singleton kullanarak Bitmap verisi gonder.
            // val singleton = Singleton.Selected
            // singleton.selectedImage = images[position]

            // Image'in ID degerini gonder.
            intent.putExtra("image",imageIds[position])

            startActivity(intent)
        }
    }
}
