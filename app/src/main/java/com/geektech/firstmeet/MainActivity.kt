package com.geektech.firstmeet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity:AppCompatActivity () {

    private lateinit var editText: EditText
    private lateinit var button: Button
    private  var sendText: String? = null
    private lateinit var returnText: String
    private val REQUEST_SEND_TEXT = 11


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    private fun initView() {
        editText = findViewById(R.id.editText_MA)
        button = findViewById(R.id.btn_send)
        button.setOnClickListener {
            send()
        }
    }
    private fun send() {
        sendText = editText.text.toString()
        if (sendText.isNullOrEmpty()) {
            editText.setError(" ")
            Toast.makeText(this, "Пожалуйста заполните поле", Toast.LENGTH_LONG).show()
           } else{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text", sendText)
            startActivityForResult(intent, 11)
           }
        }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_SEND_TEXT && resultCode == Activity.RESULT_OK){
            returnText = data!!.getStringExtra("returnText")
            editText.setText(returnText)
            Toast.makeText(this, "Данные из Second Activity были изменены с $sendText на $returnText ", Toast.LENGTH_LONG).show()

            if (!sendText.equals(returnText)){


            }
        }
    }
}