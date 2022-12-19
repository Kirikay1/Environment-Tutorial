package com.example.environment_tutorial

import android.content.DialogInterface
import android.content.res.TypedArray
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toggle : ActionBarDrawerToggle
    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        var toolbar: Toolbar = findViewById(R.id.toolbar)

        drawerLayout.openDrawer(GravityCompat.START);

        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


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

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Вы действительно хотите выйти?")
        builder.setCancelable(true)
        builder.setNegativeButton("Нет", DialogInterface.OnClickListener{dialogInterface, i -> dialogInterface.cancel() })
        builder.setPositiveButton("Да", DialogInterface.OnClickListener{dialogInterface, i -> finish() })
        val alertDialog = builder.create()
        alertDialog.show()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_Astronomy -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.astronomy),resources.getStringArray(R.array.astronomy_content),
                    getImageId(R.array.astronomy_image_array)))
            }
            R.id.id_solar_system -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.solar_system),resources.getStringArray(R.array.solar_system_content),
                    getImageId(R.array.solar_system_image_array)))
            }
            R.id.id_starry_sky -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.starry_sky),resources.getStringArray(R.array.starry_sky_content),
                    getImageId(R.array.starry_sky_image_array)))

            }
            R.id.id_geography -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.geography),resources.getStringArray(R.array.geography_content),
                    getImageId(R.array.geography_image_array)))
            }
            R.id.id_story -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.story),resources.getStringArray(R.array.story_content),
                    getImageId(R.array.story_image_array)))
            }
            R.id.id_reckoning -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.reckoning),resources.getStringArray(R.array.reckoning_content),
                    getImageId(R.array.reckoning_image_array)))
            }
            R.id.id_ecology -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.ecology),resources.getStringArray(R.array.ecology_content),
                    getImageId(R.array.ecology_image_array)))
            }
            R.id.id_world_heritage -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.world_heritage),resources.getStringArray(R.array.world_heritage_content),
                    getImageId(R.array.world_heritage_image_array)))
            }
            R.id.id_about_app -> {
                adapter?.updateAdapter(fillArrays(resources.getStringArray(R.array.about_app),resources.getStringArray(R.array.about_app_content),
                    getImageId(R.array.about_app_image_array)))
            }
        }
        val drawer: DrawerLayout = findViewById(R.id.drawerLayout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
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