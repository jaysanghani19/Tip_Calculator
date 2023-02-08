package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import com.example.tipcalculator.databinding.ActivityMainBinding
import org.w3c.dom.Text
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding.Calculate.setOnClickListener { calculate() }
//        if(binding.RoundUpSwitch.isChecked) binding.Calculate.setOnClickListener { calculate() }

        var button : Button= findViewById(R.id.Calculate)

        button.setOnClickListener { calculate() }
    }

    fun calculate(){
        val res : EditText = findViewById(R.id.Cost_Of_Service)
        val text =res.text
        val amount : Double = text.toString().toDouble()
        var group : RadioGroup = findViewById(R.id.Tip_Option)
        // To know what user has selected in radio group
        val selectedid =group.checkedRadioButtonId
        var tip : Double=0.0

        if (selectedid==R.id.Twenty_Percent) tip=amount*0.2
        else if (selectedid==R.id.Fifteen_Percent) tip=amount*0.15
        else tip=amount*0.1

        val switch : Switch=findViewById(R.id.Round_Up_Switch)
        var tipshow : TextView= findViewById<TextView>(R.id.Tip_Amount)
        //To check if user has checked the tip option switch
        if(text.equals("")){
            tip=0.0

            // To convert amount to currency instance like 2 to $2
            tipshow.text=getString(R.string.tip_amount,NumberFormat.getCurrencyInstance().format(tip))

        }
        if(switch.isChecked){
            tip=kotlin.math.ceil(tip)

            // To convert amount to currency instance like 2 to $2
            tipshow.text=getString(R.string.tip_amount,NumberFormat.getCurrencyInstance().format(tip))
        }
        else{
            tip=0.0

            // To convert amount to currency instance like 2 to $2
            tipshow.text=getString(R.string.tip_amount,NumberFormat.getCurrencyInstance().format(tip))

        }



    }
}