package br.edu.ifsp.scl.ads.prdm.sc3033406.contador

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private lateinit var cliqueBt: Button
    private lateinit var contadorTv: TextView
    private lateinit var inicialEt: EditText
    private var contador: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cliqueBt = findViewById(R.id.clique_bt)
        inicialEt = findViewById(R.id.inicial_et)
        contadorTv = findViewById(R.id.contador_tv)
        cliqueBt.setOnClickListener {
            contadorTv.text = (++contador).toString()
        }

        inicialEt.addTextChangedListener { p0 ->
            contador = p0.toString().toInt()
        }
    }
}