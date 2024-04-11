package com.example.apispractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Interface::class.java)

            val retrogitData = retrofitBuilder.getProductData()

            retrogitData.enqueue(object : Callback<Data?> {
                override fun onResponse(p0: Call<Data?>, p1: Response<Data?>) {

                    val responseBody =p1.body()
                    val productList = responseBody?.products!!

                    val myAdapter = MyAdapter(this@MainActivity,productList)

                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = myAdapter
                }

                override fun onFailure(p0: Call<Data?>, p1: Throwable) {
                   Toast.makeText(this@MainActivity,"Failed",Toast.LENGTH_SHORT).show()
                }
            })

    }
}