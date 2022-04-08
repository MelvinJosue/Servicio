package com.example.servicio

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val empezar:Button=findViewById(R.id.btnstar)
        val parar:Button=findViewById(R.id.btnstop)
        val creador:Button=findViewById(R.id.btncreador)
        val serviceClass = contarhora::class.java
        val intent = Intent(applicationContext, serviceClass)


        empezar.setOnClickListener {
            if (!serviciocreado(serviceClass)) {
                startService(intent)
                toast("HA COMENZADO EL SERVICIO")
            } else {
            } to ("HA COMENZADO ESPERA")


        }
        parar.setOnClickListener {
            if (serviciocreado(serviceClass)) {
                stopService(intent)
                toast("HAZ TERMINADO TU SERVICIO")
            } else {
                toast("YA SE HA ACABADO EL SERVICIO")
            }

        }

        creador.setOnClickListener {
            val intent = Intent(applicationContext, Servicioparte2::class.java)
            startActivity(intent)
        }

        }
    private fun serviciocreado(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }
}
fun Context.toast(message:String){
    Toast.makeText(applicationContext,message, Toast.LENGTH_SHORT).show()
}


