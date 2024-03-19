package com.example.famrecycleviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.delasign.samplestarterproject.utils.ReadJSONFromAssets
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Phone>()
//    private val list = List<Phone>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListData())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.action_list -> {
//                rvHeroes.layoutManager = LinearLayoutManager(this)
//            }
//            R.id.action_grid -> {
//                rvHeroes.layoutManager = GridLayoutManager(this, 2)
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }


    private fun getListData(): ArrayList<Phone>{
        var dataJson = ReadJSONFromAssets(baseContext, "data_list2.json")
        val dataResp = Gson().fromJson<ModelPhone>(dataJson, ModelPhone::class.java)

//        val dataName = resources.getStringArray(R.array.data_name)
//        val dataDescription = resources.getStringArray(R.array.data_description)
//        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
//        val listHero = ArrayList<Phone>()
//        for(i in dataName.indices) {
//            val hero = Phone(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
//            listHero.add(hero)
//        }
//        dataPhoto.recycle()
        val dataArrayList = ArrayList(dataResp.products)
        return dataArrayList
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listDataAdapter = ListDataAdapter(list)
        rvHeroes.adapter = listDataAdapter

        listDataAdapter.setOnItemClickCallback(object: ListDataAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Phone) {
                print("Kamu memilih ${data.title}")
                val moveWithObjectIntent = Intent(this@MainActivity, ActivityItemDetail::class.java)
                moveWithObjectIntent.putExtra(ActivityItemDetail.EXTRA_PERSON, data)
                startActivity(moveWithObjectIntent)
//                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(hero: Phone) {
        Toast.makeText(this, "Kamu memilih ${hero.title}", Toast.LENGTH_SHORT).show()
    }
}