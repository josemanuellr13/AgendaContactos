package com.example.agenda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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

        binding.btnLlamar.setOnClickListener(){
            val phone = contacto.tfn
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
            startActivity(intent)
        }

        binding.btnEmail.setOnClickListener(){
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: " + contacto.correo)
            intent.putExtra(Intent.EXTRA_EMAIL, "test")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello World")

            startActivity(intent)
        }
    }
}