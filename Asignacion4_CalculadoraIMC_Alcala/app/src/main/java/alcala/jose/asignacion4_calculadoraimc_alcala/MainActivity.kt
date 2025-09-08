package alcala.jose.asignacion4_calculadoraimc_alcala

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etEstatura: EditText=findViewById(R.id.etEstatura)
        val etPeso: EditText=findViewById(R.id.etPeso)
        val btnCalcular: Button=findViewById(R.id.btnCalcular)
        val tvIMC: TextView=findViewById(R.id.tvIMC)
        val tvRange: TextView=findViewById(R.id.tvRange)

        btnCalcular.setOnClickListener {
            val estatura=etEstatura.text.toString().toDouble()
            val peso=etPeso.text.toString().toDouble()

            val imc=peso/estatura.pow(2)
            if(imc<18.5){
                //bajo peso
                tvRange.setText("peso bajo")
                tvRange.setBackgroundResource(R.color.red)
            }else if (imc>=18.5 && imc<=24.9){
                //normal
                tvRange.setText("normal")
                tvRange.setBackgroundResource(R.color.green)
            }else if (imc>=25 && imc<=29.9){
                //sobrepeso
                tvRange.setText("sobrepeso")
                tvRange.setBackgroundResource(R.color.greenish)
            }else if (imc>=30 && imc<=34.9){
                //obesidad 1
                tvRange.setText("obesidad 1")
                tvRange.setBackgroundResource(R.color.yellow)
            }
            else if (imc>=35 && imc<=39.9){
                //obesidad 2
                tvRange.setText("obesidad 2")
                tvRange.setBackgroundResource(R.color.orange)
            }else if (imc>=40){
                //obesidad 3
                tvRange.setText("obesidad 3")
                tvRange.setBackgroundResource(R.color.brown)
            }
            tvIMC.setText(imc.toDouble().toString())
        }
    }





}