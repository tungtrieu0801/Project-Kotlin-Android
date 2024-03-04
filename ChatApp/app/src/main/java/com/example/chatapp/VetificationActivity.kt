package com.example.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatapp.databinding.ActivityVetificationBinding
import com.google.firebase.auth.FirebaseAuth

class VetificationActivity : AppCompatActivity() {
    var biding : ActivityVetificationBinding? =null
    var auth :FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityVetificationBinding.inflate(layoutInflater)
        setContentView(biding!!.root)

        auth = FirebaseAuth.getInstance()
        if (auth!!.currentUser!=null) {
            val intent = Intent(this@VetificationActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        supportActionBar?.hide()
        biding!!.Editnumber.requestFocus()
        biding!!.continueBtn.setOnClickListener {
            val intent  = Intent(this@VetificationActivity, OTPActivity::class.java)
            intent.putExtra("phoneNumber", biding!!.Editnumber.text.toString())
            startActivity(intent)
        }
    }
}