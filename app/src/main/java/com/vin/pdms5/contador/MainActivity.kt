package com.vin.pdms5.contador

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.vin.pdms5.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding
    private var contador: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)


        amb.initialEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do nothing
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                contador = s.toString().toInt()
                amb.contadorTv.text = contador.toString()
            }
            override fun afterTextChanged(s: Editable?) {
                // Do nothing
            }
        })

        amb.zeroRg.setOnClickListener{
            contador = amb.zeroRg.text.toString().toInt()
            amb.contadorTv.text = contador.toString()
        }
        amb.tenRg.setOnClickListener{
            contador = amb.tenRg.text.toString().toInt()
            amb.contadorTv.text = contador.toString()
        }


        amb.clickBtn.setOnClickListener{
            amb.contadorTv.text = (++contador).toString()
        }

    }
}