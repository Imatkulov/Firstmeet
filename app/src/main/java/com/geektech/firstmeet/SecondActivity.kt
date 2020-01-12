package com.geektech.firstmeet

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private lateinit var editText_SA: EditText
    private lateinit var button: Button
    private lateinit var receivedText: String
    private  var sendTextBack: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
    }

    private fun initView() {
        editText_SA = findViewById(R.id.editText_SA)
        button = findViewById(R.id.btn_return)
        button.setOnClickListener {
            sendBack()
        }
        receivedText = intent.getStringExtra("text")
        editText_SA.setText(receivedText)
    }

    private fun sendBack() {
        sendTextBack = editText_SA.text.toString()
        if (sendTextBack.isNullOrEmpty()) {
            editText_SA.setError("")
            Toast.makeText(this, "Пожалуйста заполните поле", Toast.LENGTH_SHORT).show()
        } else {
            setResult(Activity.RESULT_OK, Intent(this, MainActivity::class.java).putExtra("returnText", sendTextBack))
            finish()

        }
    }
}