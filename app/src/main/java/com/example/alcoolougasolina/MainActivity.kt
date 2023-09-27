package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            percentual = savedInstanceState.getDouble("percentual")
        }
        Log.d("PDM23","No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento
            percentual=0.75
            Log.d("PDM23","No btCalcular, $percentual")
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
    Log.d("PDM23","No onResume")
}
override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onResume")
}
override fun onStop(){
    super.onStop()
    Log.d("PDM23","No onResume")
}
override fun onDestroy(){

    super.onDestroy()
    Log.d("PDM23","No onResume")
}

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putDouble("percentual",percentual)
        super.onSaveInstanceState(outState, outPersistentState)
    }
}