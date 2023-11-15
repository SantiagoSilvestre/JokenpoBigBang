package br.com.silvestresantiago732.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.silvestresantiago732.jokenpo.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityFirstBinding?>(this, R.layout.activity_first).apply {
            btnJogar.setOnClickListener {
                startActivity(Intent(this@FirstActivity, MainActivity::class.java))
                finish()
            }
        }
    }
}