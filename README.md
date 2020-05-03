## ListView
The class that stores the image in bitmap data type with sigleton.
```kotlin
class Singleton {
    companion object Selected {
        var selectedImage : Bitmap? = null
    }
}
```
Create static datas:
```kotlin
var languages = ArrayList<String>()
languages.add("Kotlin")

var years = ArrayList<String>()
years.add("2011")

// With IDs (Alternative):
var imageIds = ArrayList<Int>()
val kotlinId : Int = R.drawable.kotlin
imageIds.add(kotlinId)

// Using Bitmap With Singleton (Alternative):
var images = ArrayList<Bitmap>()
var kotlin = BitmapFactorydecodeResource(applicationContext.resources,R.drawable.kotlin)
images.add(kotlin)
```
Adapter : These are the structures that connect an object that needs data with a data source.
```kotlin
// Default Layout (Alternative):
val adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,languages)
// Customized Layout (Alternative):
val adapter : ArrayAdapter<String> = ArrayAdapter(this,R.layout.custom_list,R.id.textViewListLanguage,languages)
listView.adapter = adapter
```
Action to take when clicking an item in ListView:
```kotlin
listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

    // Create Intent between MainActivity and DetailsActivity.
    val intent = Intent(applicationContext,DetailsActivity::class.java)

    // Send data to DetailActivity with Intent.
    intent.putExtra("language",languages[position])
    intent.putExtra("year",years[position])
    
    // With IDs (Alternative):
    intent.putExtra("image",imageIds[position])

    // Using Bitmap With Singleton (Alternative):
    val singleton = Singleton.Selected
    singleton.selectedImage = images[position]

    startActivity(intent)
}
```
Get the sent data from other activity:
```kotlin
// Definition and Initialize
val textViewLanguage : TextView = findViewById(R.id.textViewLanguage)

// Get data sent from other activity with Intent
val intent = intent
val language : String = intent.getStringExtra("language")
val year : String = intent.getStringExtra("year")

textViewLanguage.text = language
textViewYear.text = year

// With IDs (Alternative):
val imageId : Int = intent.getIntExtra("image",0)
val selectedBitmap = BitmapFactory.decodeResource(applicationContext.resources,imageId)
imageViewLogo.setImageBitmap(selectedBitmap)

// Using Bitmap With Singleton (Alternative):
val singleton = Singleton.Selected
val selectedBitmap = singleton.selectedImage
imageViewLogo.setImageBitmap(selectedBitmap)
```
