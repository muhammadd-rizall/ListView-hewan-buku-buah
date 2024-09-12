package com.rizal.list

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var  btnhewan : Button
    private lateinit var  btnBuku : Button
    private lateinit var btnBuah : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnhewan = findViewById(R.id.btnhewan)
        btnBuku = findViewById(R.id.btnBuku)
        btnBuah = findViewById(R.id.btnBuah)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnhewan.setOnClickListener(){
            val intent =Intent(this@MainActivity, hewan::class.java )
            startActivity(intent)
        }

        btnBuku.setOnClickListener(){
            val intent = Intent(this@MainActivity, RecycleView::class.java)
            startActivity(intent)
        }

        btnBuah.setOnClickListener(){
            val intent = Intent(this@MainActivity, RecycleBuah::class.java)
            startActivity(intent)
        }
    }
}