package edu.temple.activity4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var textSizeSelector: RecyclerView
    lateinit var textSizeDisplay: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textSizeSelector= findViewById(R.id.recyclerView)
        textSizeDisplay = findViewById(R.id.textView)

        // Trying to create array of integers that are multiples of 5
        // Verify correctness by examining array values.
        val textSizes = Array(20){(it + 1) * 5}
        //Log.d("MyArray", textSizes.toString())



        //val callback = {textSize: Float-> textSizeDisplay.textSize = textSize}
        /*
        with(findViewById(R.id.recyclerView) as RecyclerView){
            layoutManager = LinearLayoutManager(context)
            adapter = TextSizeAdapter(textSizes, callback)
        }
        */

        textSizeSelector.adapter = TextSizeAdapter(textSizes){
            textSizeDisplay.textSize = it
        }
        textSizeSelector.layoutManager = LinearLayoutManager(this)
    }
}



/* Convert to RecyclerView.Adapter */
class TextSizeAdapter(_textSizes:Array<Int>, _callback: (Float)->Unit) : RecyclerView.Adapter<TextSizeAdapter.TextSizeViewHolder>(){
    val textSizes = _textSizes
    val callback = _callback

    inner class TextSizeViewHolder(view: TextView) : RecyclerView.ViewHolder(view){
        val textView = view
        init {
            textView.setOnClickListener{
                callback(textSizes[adapterPosition].toFloat())
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextSizeViewHolder {
        return TextSizeViewHolder(TextView(parent.context).apply {
            setPadding(5, 20, 0, 20)

        })
    }

    override fun getItemCount(): Int {
        return textSizes.size
    }

    override fun onBindViewHolder(holder: TextSizeViewHolder, position: Int) {
        /*
        holder.textView.text = textSizes[position].toString()
        holder.textView.textSize = textSizes[position].toFloat()
        */


        holder.textView.apply{
            text = textSizes[position].toString()
            textSize = textSizes[position].toFloat()
            setOnClickListener{
                callback(textSizes[position].toFloat())
            }
        }
    }
}