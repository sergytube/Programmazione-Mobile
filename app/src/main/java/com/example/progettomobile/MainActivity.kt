package com.example.progettomobile

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerview.view.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), ProvinceAdapter.OnItemClickListener {

    private val list = ListaProvince()

    private val adapter = ProvinceAdapter(list, this)

    lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Associo un layout all'appbar invece che un menu, in modo che sia personalizzabile
        toolbar = supportActionBar!!
        toolbar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        toolbar.setCustomView(R.layout.app_bar_layout)

        //Listener del gps
        val gpsButton = findViewById<ImageButton>(R.id.gps)
        gpsButton.setOnClickListener {
            Toast.makeText(this, "GPS", Toast.LENGTH_SHORT).show()
        }

        //Listener del'account
        val accountButton = findViewById<ImageButton>(R.id.account)
        accountButton.setOnClickListener {
            Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show()
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)

        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerview.setHasFixedSize(true)

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Provincia $position selezionata", Toast.LENGTH_SHORT).show()
        val clickedItem = list[position]
        clickedItem.text = "Selezionata"
        adapter.notifyItemChanged(position)
    }

  private fun ListaProvince(): List<ProvinceModel> {
      val listOfProvince = mutableListOf<ProvinceModel>()

      var movieModel = ProvinceModel(R.drawable.ancona,"Ancona")
      listOfProvince.add(movieModel)

      movieModel = ProvinceModel(R.drawable.ascolipiceno,"Ascoli Piceno")
      listOfProvince.add(movieModel)

      movieModel = ProvinceModel(R.drawable.fermo,"Fermo")
      listOfProvince.add(movieModel)

      movieModel = ProvinceModel(R.drawable.pesarourbino,"Pesaro e Urbino")
      listOfProvince.add(movieModel)

      movieModel = ProvinceModel(R.drawable.macerata,"Macerata")
      listOfProvince.add(movieModel)

      return listOfProvince
  }
}


