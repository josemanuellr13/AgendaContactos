package com.example.agenda

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.agenda.databinding.ActivityDetallesContactoBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_CONTACTO = "contacto_eviado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetallesContactoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contacto : Contacto = intent?.getParcelableExtra(EXTRA_CONTACTO) ?: throw IllegalStateException()

        binding.tvNombre.text = contacto.nombre
        binding.tvEmail.text = contacto.correo
        binding.tvTfn.text = contacto.tfn

        Glide.with(binding.ivFoto).load(contacto.img).into(binding.ivFoto)

        binding.btnEmail.setOnClickListener(){
            Toast.makeText(this, "Email copiado", Toast.LENGTH_SHORT).show()
        }
    }
}