package br.com.silvestresantiago732.jokenpo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.silvestresantiago732.jokenpo.databinding.ActivityMainBinding
import br.com.silvestresantiago732.jokenpo.utils.Constants.RULES
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.myToolbar)

        listeners()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_game, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Verifica qual item foi selecionado
        when (item.itemId) {
            R.id.rulesGame -> {
                startActivity(Intent(this@MainActivity, FirstActivity::class.java))
                finish()
            }
        }

        return true
    }

    private fun listeners() {

        binding.apply {
            imageViewPedra.setOnClickListener {
                optionSelected(0)
                imageViewResultadoJogador.setImageResource(R.drawable.pedra)
            }

            imageViewPapel.setOnClickListener {
                optionSelected(1)
                imageViewResultadoJogador.setImageResource(R.drawable.papel)
            }

            imageViewTesoura.setOnClickListener {
                optionSelected(2)
                imageViewResultadoJogador.setImageResource(R.drawable.tesoura)
            }

            imageViewLagarto.setOnClickListener {
                optionSelected(3)
                imageViewResultadoJogador.setImageResource(R.drawable.lagarto)
            }

            imageViewSpok.setOnClickListener {
                optionSelected(4)
                imageViewResultadoJogador.setImageResource(R.drawable.spock)
            }
        }

    }

    private fun optionSelected(userChose: Int) {
        val number = Random().nextInt(5)
        val appChose = RULES[number]
        val playerChose = RULES[userChose]

        when (number) {
            0 -> binding.imageViewResultadoApp.setImageResource(R.drawable.pedra)
            1 -> binding.imageViewResultadoApp.setImageResource(R.drawable.papel)
            2 -> binding.imageViewResultadoApp.setImageResource(R.drawable.tesoura)
            3 -> binding.imageViewResultadoApp.setImageResource(R.drawable.lagarto)
            4 -> binding.imageViewResultadoApp.setImageResource(R.drawable.spock)
        }

        binding.textViewResultado.text = calculeResult(appChose, playerChose)

    }

    private fun calculeResult(appChose: String, playerChose: String): String {
        when (appChose) {
            playerChose -> return getString(R.string.result_empate)
            RULES[0] -> {
                if (playerChose == RULES[2] || playerChose == RULES[3])
                    return getString(R.string.result_perdeu)
                else if (playerChose == RULES[1] || playerChose == RULES[4])
                    return getString(R.string.result_ganhou)
            }

            RULES[1] -> {
                if (playerChose == RULES[0] || playerChose == RULES[4])
                    return getString(R.string.result_perdeu)
                else if (playerChose == RULES[2] || playerChose == RULES[3])
                    return getString(R.string.result_ganhou)
            }

            RULES[2] -> {
                if (playerChose == RULES[1] || playerChose == RULES[3])
                    return getString(R.string.result_perdeu)
                else if (playerChose == RULES[0] || playerChose == RULES[4])
                    return getString(R.string.result_ganhou)
            }

            RULES[3] -> {
                if (playerChose == RULES[4] || playerChose == RULES[1])
                    return getString(R.string.result_perdeu)
                else if (playerChose == RULES[0] || playerChose == RULES[2])
                    return getString(R.string.result_ganhou)
            }

            RULES[4] -> {
                if (playerChose == RULES[2] || playerChose == RULES[0])
                    return getString(R.string.result_perdeu)
                else if (playerChose == RULES[3] || playerChose == RULES[1])
                    return getString(R.string.result_ganhou)
            }
        }

        return getString(R.string.label_escolha)
    }

}