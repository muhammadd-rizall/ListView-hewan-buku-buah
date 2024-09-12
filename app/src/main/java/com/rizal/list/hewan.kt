package com.rizal.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class hewan : AppCompatActivity() {
    private lateinit var lv_listview : ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hewan)
        lv_listview = findViewById(R.id.lvdata)

        //array adapter
        val arrayAdapter: ArrayAdapter<*>
        val listhewan = arrayOf(
            "semut",
            "kucing",
            "gajah",
            "kelinci",
            "ular",
            "ikan",
            "paus",
            "panda"
        )
        //tampilkan kedalam listview
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listhewan)
        lv_listview.adapter = arrayAdapter

        lv_listview.setOnItemClickListener{
                parent, view, position, id ->
            Toast.makeText(this, "Anda klik : ${listhewan[position]}", Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}