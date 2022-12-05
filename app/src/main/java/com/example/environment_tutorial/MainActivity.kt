package com.example.environment_tutorial

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Окружающий мир"

        var nav: NavigationView = findViewById(R.id.nav_view)
        nav.setNavigationItemSelectedListener (this)

        var list = ArrayList<ListItem>()



        var rcViewR: RecyclerView = findViewById(R.id.rcView)
        rcViewR.hasFixedSize()
        rcViewR.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcViewR.adapter = adapter


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_Astronomy -> {
                Toast.makeText(this, "id title2", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.astronomy),resources.getStringArray(R.array.astronomy_content),
                    getImageId(R.array.astronomy_image_array)))
            }
            R.id.id_solar_system -> {
                Toast.makeText(this, "id title3", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.solar_system),resources.getStringArray(R.array.solar_system_content),
                    getImageId(R.array.solar_system_image_array)))
            }
            R.id.id_starry_sky -> {
                Toast.makeText(this, "id title4", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.starry_sky),resources.getStringArray(R.array.starry_sky_content),
                    getImageId(R.array.starry_sky_image_array)))

            }
            R.id.id_geography -> {
                Toast.makeText(this, "id title5", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.geography),resources.getStringArray(R.array.geography_content),
                    getImageId(R.array.geography_image_array)))
            }
            R.id.id_story -> {
                Toast.makeText(this, "id title6", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.story),resources.getStringArray(R.array.story_content),
                    getImageId(R.array.story_image_array)))
            }
            R.id.id_reckoning -> {
                Toast.makeText(this, "id title7", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.reckoning),resources.getStringArray(R.array.reckoning_content),
                    getImageId(R.array.reckoning_image_array)))
            }
            R.id.id_ecology -> {
                Toast.makeText(this, "id title8", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.ecology),resources.getStringArray(R.array.ecology_content),
                    getImageId(R.array.ecology_image_array)))
            }
            R.id.id_world_heritage -> {
                Toast.makeText(this, "id title9", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.world_heritage),resources.getStringArray(R.array.world_heritage_content),
                    getImageId(R.array.world_heritage_image_array)))
            }
            R.id.id_about_app -> {
                Toast.makeText(this, "id title10", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.about_app),resources.getStringArray(R.array.about_app_content),
                    getImageId(R.array.about_app_image_array)))
            }
        }


        return true
    }

    fun fillArrays(titleArray: Array<String>, contentArray: Array<String>, imageArray: IntArray):List<ListItem>{
        var listItemArray = ArrayList<ListItem>()
        for (n in 0..titleArray.size - 1){
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray{
        var tArray: TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices){
            ids [i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }
}