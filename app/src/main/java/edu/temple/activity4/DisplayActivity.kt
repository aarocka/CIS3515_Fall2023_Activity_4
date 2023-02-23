package edu.temple.activity4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val textSize = intent.getFloatExtra("textSize", 0f)
        Log.d("textSize", textSize.toString())

        val myTextView = findViewById<TextView>(R.id.textView2)
        myTextView.textSize = textSize
        myTextView.text = "This is a test"

    }


}