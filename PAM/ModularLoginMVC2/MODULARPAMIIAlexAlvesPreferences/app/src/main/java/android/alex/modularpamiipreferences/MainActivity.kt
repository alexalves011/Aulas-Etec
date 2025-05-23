package android.alex.modularpamiipreferences

import android.alex.modularpamiipreferences.databinding.ActivityMainBinding
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

private val Any.btnTrocar: Unit
    get() {}

class MainActivity : AppCompatActivity() {
    lateinit var biding : ActivityMainBinding

    companion object{
        const val NOME_ARQUIVO = "arquivo_prefs.xml"
    }


    private var cor = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.hide()
        window.statusBarColor = Color.WHITE
        var binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        setContentView(binding.root)

            binding.cor1.setOnClickListener{
                cor = "F44336FF"
                binding.main.setBackgroundColor(Color.parseColor(cor))
            }

            binding.cor2.setOnClickListener {
                cor = "4CAF50FF"
                binding.main.setBackgroundColor(Color.parseColor(cor))
            }

                    binding.cor3.setOnClickListener {
                        cor = "3700B3FF"
                    }

                        binding.cor4.setOnClickListener {
                            cor = "03DAC5FF"
                        }

                        binding.cor5.setOnClickListener{
                            cor = "018786FF"
                        }

        binding.btnTrocar.setOnClickListener {view->{

            val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            val  editor = preferencias.edit()
            editor.putString("cor", cor)
            editor.putString("nome", "Alex")
            editor.putString("sobrenome", "Alves")
            editor.putString("Idade", "19")
            editor.apply()

            snackBar(view)


            Toast.makeText(this, "Cor salva no arquivo de cores", Toast.LENGTH_LONG).show()

        }





        }


    }

    private fun snackBar(view: View){
    val snackbar = Snackbar.make(view, "Cor de fundo com Sucesso !", Snackbar.LENGTH_INDEFINITE )
        snackbar.setAction("OK"){

        }

        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.LTGRAY)
        snackbar.setActionTextColor(Color.GREEN)
        snackbar.show()
    }

    private fun salvarCor(cor: String){
        biding.main.setBackgroundColor(Color.parseColor(cor))
        biding.btnTrocar.setOnClickListener{View->

        }

    }
}