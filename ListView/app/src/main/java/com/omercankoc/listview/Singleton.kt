package com.omercankoc.listview

import android.graphics.Bitmap

class Singleton {

    // Singleton : Tek bir Object'e (Instance) sahip sinif.

    companion object Selected {
        var selectedImage : Bitmap? = null
    }

}