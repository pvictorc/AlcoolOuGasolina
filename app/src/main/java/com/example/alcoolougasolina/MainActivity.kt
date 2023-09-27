package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            percentual = savedInstanceState.getDouble("percentual")
            Log.d("PDM23","No onCreate, recuperou percentual $percentual")
        } else
            percentual = 0.70
        Log.d("PDM23","No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        val switchPercent: Switch = findViewById(R.id.swPercentual)
        val resultText: TextView = findViewById(R.id.resultado)
        resultText.visibility = View.INVISIBLE
        val editAlcool: EditText = findViewById(R.id.edAlcool)
        val editGasosa: EditText = findViewById(R.id.edGasolina)

        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento

            var precoGas: Float = 0F
            var precoAlcool: Float = 0F
            try {
                if ( (editGasosa.text.toString() != "")
                    && (editAlcool.text.toString() != "") ) {
                    precoGas = editGasosa.text.toString().toFloat()
                    precoAlcool = editAlcool.text.toString().toFloat()

                    // Privilegia Etanol em caso de empate
                    if (precoGas*percentual >= precoAlcool )
                        resultText.text = "Abasteça com \nETANOL"
                    else
                        resultText.text = "Abasteça com \nGASOLINA"


                }
                else resultText.text = "Preencha os preços \nda Gasolina e Etanol"

                resultText.visibility = android.view.View.VISIBLE

            } catch (e: Exception){
                throw Exception("String mal formatada")
            }

            var temp = "%.2f".format(percentual)
            Log.d("PDM23","No btCalcular, $temp")
        })
        switchPercent.setOnClickListener(View.OnClickListener {
            if( switchPercent.isChecked ){
                percentual=0.75
            }
            else percentual=0.70
            btCalc.callOnClick()
            Log.d("PDM23","Var percentual mudada para $percentual")
        })

    }

override fun onResume(){
    // todo Altere o app para recuperar o valor de percentual
    super.onResume()
    Log.d("PDM23","No onResume, percentual $percentual")
    val edAlcool:EditText = findViewById(R.id.edAlcool)
    var valorAlcool = edAlcool.text.toString()
    Log.d("PDM23", "No onResume, alcool $valorAlcool" )
}
override fun onStart(){
    super.onStart()
    Log.d("PDM23","No onStart")
}
override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onPause")
}
override fun onStop(){
    super.onStop()
    Log.d("PDM23","No onStop")
}
override fun onDestroy(){
    super.onDestroy()
    Log.d("PDM23","No onResume")
}
override fun onSaveInstanceState(outState: Bundle) {
    outState.putDouble("percentual",percentual)
    Log.d("PDM23","Chamou o onSaveInstanceState")
    super.onSaveInstanceState(outState)
}

}