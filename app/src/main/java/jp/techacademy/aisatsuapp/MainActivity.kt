package jp.techacademy.aisatsuapp

import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , View.OnClickListener{

    var HOUR = 0
    var MINUTE = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
        textView.text=""
    }

    override fun onClick(v: View){

        if (v.id == R.id.button){
            showTimePickerDialog()

        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                HOUR = "$hour".toInt()
                MINUTE = "$minute".toInt()
                if(HOUR>=2 && HOUR<10){
                    textView.text="おはよう"
                }
                else if(HOUR>=10 && HOUR<18){
                    textView.text="こんにちは"
                }
                else if(HOUR>=18 || HOUR<2){
                    textView.text="こんばんは"
                }
                Log.d("UI_PARTS",textView.text.toString())
            },
            13, 0, true)
        timePickerDialog.show()
    }
}
