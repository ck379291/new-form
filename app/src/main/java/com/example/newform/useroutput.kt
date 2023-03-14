package com.example.newform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newform.databinding.ActivityUseroutputBinding

class useroutput : AppCompatActivity() {
    private lateinit var binding: ActivityUseroutputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_useroutput)
        binding= ActivityUseroutputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ufirstname=intent.getStringExtra("firstname")
        val ulastname=intent.getStringExtra("lastname")
        val umobile1=intent.getStringExtra("number")
        val umobile2=intent.getStringExtra("alternative ")
        val uemail=intent.getStringExtra("email")
        val ugender=intent.getStringExtra("gender")
        val  uhobbies=intent.getStringExtra("hobbies")
        binding.information.text="Name :$ufirstname $ulastname \n Mobile number: $umobile1\n  Email:$uemail\n Alternative :$umobile2 \n Gender : $ugender\n Hobbies:$uhobbies "

    }
}