package com.example.agenda
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Contacto(val nombre: String, val tfn: String, val correo : String, val img : String) : Parcelable {
}