package com.example.agenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.agenda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recview.adapter = contactosAdapter(listOf(
            Contacto("Jose Manuel Lopez ramos","965233443","josemanuelr223@gmail.com","https://png.pngtree.com/png-vector/20190710/ourlarge/pngtree-user-vector-avatar-png-image_1541962.jpg"),
            Contacto("Antonio Perez Peralta","675233443","peraltita223@gmail.com","https://png.pngtree.com/png-vector/20190710/ourlarge/pngtree-user-vector-avatar-png-image_1541962.jpg"),
            Contacto("Luis Carrero Garcia","675235676","antoniojml@gmail.com","https://png.pngtree.com/png-vector/20190710/ourlarge/pngtree-user-vector-avatar-png-image_1541962.jpg")))

        binding.textView.text = "Lista de contactos "
    }


}

