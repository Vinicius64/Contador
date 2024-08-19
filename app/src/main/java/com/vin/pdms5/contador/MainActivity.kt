package com.vin.pdms5.contador

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import android.widget.AdapterView.OnItemSelectedListener
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

        amb.initialSp.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                contador = when(position){
                    0 -> 0
                    1 -> 5
                    2 -> 10
                    else -> 0
                }
                amb.contadorTv.text = contador.toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        amb.clickBtn.setOnClickListener{
            amb.contadorTv.text = (++contador).toString()
        }

    }
}