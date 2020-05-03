package com.omercankoc.listview

import android.graphics.Bitmap

class Singleton {

    // Sinifin tekilligini (Singleton) saglamak ve static nesne ve metotlarin tanimlanmasi icin
    // companion object blogu kullanilir.
    companion object Selected {
        var selectedImage : Bitmap? = null
    }

}