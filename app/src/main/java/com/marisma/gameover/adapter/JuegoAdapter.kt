package com.marisma.gameover.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marisma.gameover.Juego
import com.marisma.gameover.R

class JuegoAdapter(private var juegosLista: List<Juego>, private val onClickListener: (Juego) -> Unit) : RecyclerView.Adapter<JuegoViewHolder>() {

    // Método para actualizar la lista de juegos
    fun actualizarJuegos(nuevaLista: List<Juego>) {
        juegosLista = nuevaLista
        notifyDataSetChanged() // Notificar al adaptador que los datos han cambiado
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuegoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return JuegoViewHolder(layoutInflater.inflate(R.layout.item_juego,parent,false))
    }

    override fun getItemCount(): Int = juegosLista.size

    override fun onBindViewHolder(holder: JuegoViewHolder, position: Int) {
        holder.render(juegosLista[position], onClickListener)
    }
}