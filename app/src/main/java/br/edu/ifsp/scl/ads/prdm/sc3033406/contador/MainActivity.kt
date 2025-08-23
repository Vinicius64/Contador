package br.edu.ifsp.scl.ads.prdm.sc3033406.contador

import android.os.Bundle
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
                    getString(R.string.dez).toInt()
                }else{
                    getString(R.string.zero).toInt()
                }
                contadorTv.text = contador.toString()
            }
        }
    }
}