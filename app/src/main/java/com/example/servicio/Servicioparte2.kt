package com.example.servicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Servicioparte2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicioparte2)

            val regresar: Button =findViewById(R.id.btnregresar)
regresar.setOnClickListener {
    val intent = Intent(this@Servicioparte2, MainActivity::class.java)
    this@Servicioparte2.startActivity(intent)
}

    }
}