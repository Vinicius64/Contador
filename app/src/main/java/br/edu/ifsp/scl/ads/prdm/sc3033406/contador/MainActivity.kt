package br.edu.ifsp.scl.ads.prdm.sc3033406.contador

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import br.edu.ifsp.scl.ads.prdm.sc3033406.contador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var contador: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(amb){
            setContentView(root)

            cliqueBt.setOnClickListener {
                amb.contadorTv.text = (++contador).toString()
            }

//            inicialEt.addTextChangedListener { p0 ->
//                contador = p0.toString().toInt()
//            }

            inicialCb.setOnClickListener {
                contador = if(inicialCb.isChecked){
                    Toast.makeText(this@MainActivity, "Você clicou no CheckBox para alterar para " + getString(R.string.dez), Toast.LENGTH_SHORT).show()
                    getString(R.string.dez).toInt()
                }else{
                    Toast.makeText(this@MainActivity, "Você clicou no CheckBox para alterar para " + getString(R.string.zero), Toast.LENGTH_SHORT).show()
                    getString(R.string.zero).toInt()
                }
                contadorTv.text = contador.toString()
            }
        }
    }
}