package com.example.agenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agenda.databinding.ViewContactoItemBinding

 class contactosAdapter(val contactos: List<Contacto>) : RecyclerView.Adapter<contactosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.view_contacto_item, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactos[position])
    }

    override fun getItemCount(): Int = contactos.size


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        private val binding = ViewContactoItemBinding.bind(view)

        fun bind(contacto: Contacto) {
          //  Glide.with(binding.imagenContacto).load(contacto.img).into(binding.imagenContacto)
                    binding.correo.text = contacto.correo
                    binding.nombre.text = contacto.nombre
                    binding.tfn.text = contacto.tfn
        }
    }

}