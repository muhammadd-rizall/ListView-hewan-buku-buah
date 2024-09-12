package com.rizal.list

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rizal.list.adapter.BukuAdapter
import com.rizal.list.model.ModelBuku

class RecycleView : AppCompatActivity() {
    private lateinit var rv_data : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)

        rv_data = findViewById(R.id.rv_data)

        //array data
        val listBuku = listOf(
            ModelBuku(judul ="Buku Android Kotlin 2024", penerbit = "Udacoding"),
            ModelBuku(judul ="Dibawah Lindungan kakbah", penerbit = "Buyah Hamkah"),
            ModelBuku(judul ="Bumi The Series", penerbit = "Tere Liye"),
            ModelBuku(judul ="Dilan 1990", penerbit = "Pidi Baiq"),
            ModelBuku(judul ="Negeri 5 Menara", penerbit = "Ahmada Fuadi"),
        )

        val nBukuAdapter = BukuAdapter(listBuku)
        rv_data.apply {
            layoutManager = LinearLayoutManager(this@RecycleView)
            adapter = nBukuAdapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}