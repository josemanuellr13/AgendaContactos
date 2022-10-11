package com.example.agenda

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agenda.databinding.ViewContactoItemBinding


 class contactosAdapter(val contactos: List<Contacto>, val listener: (Contacto) -> Unit) : RecyclerView.Adapter<contactosAdapter.ViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.view_contacto_item, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactos[position])

        holder.itemView.setOnClickListener{
            listener(contactos[position])
        }

    }

    override fun getItemCount(): Int = contactos.size


    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        private val binding = ViewContactoItemBinding.bind(view)

        fun bind(contacto: Contacto) {
            binding.apply{
                imagenContacto.glide(contacto.img)
                Glide.with(imagenContacto).load(contacto.img).into(imagenContacto)
                correo.text = contacto.correo
                nombre.text = contacto.nombre
                tfn.text = contacto.tfn
            }

        }


    }

}

// Funcion de extension
fun ImageView.glide(url: String){
    Glide.with(this)
        .load(url)
        .into(this)
}