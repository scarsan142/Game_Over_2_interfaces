package com.marisma.gameover.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marisma.gameover.Favoritos
import com.marisma.gameover.FavoritosProvider
import com.marisma.gameover.R
import com.marisma.gameover.data.Juego2
import com.marisma.gameover.databinding.ItemJuegoBinding

class juegoadapter2(
    private var _juegoList: MutableList<Juego2>,
    private val onClickJuego: (String) -> Unit,
    private val onClickDelete: (Int) -> Unit
) : RecyclerView.Adapter<juegoadapter2.JuegoViewHolder2>() {

    companion object {
        const val DRAWABLE = "drawable"
    }

    val juegoList get() = _juegoList

    class JuegoViewHolder2(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemJuegoBinding.bind(view)

        fun bind(
            juego: Juego2,
            onClickJuego: (String) -> Unit,
            onClickDelete: (Int) -> Unit
        ) {
            binding.tvJuegoName.text = juego.name
            binding.tvGenero.text = juego.genre ?: ""
            binding.tvEstudio.text = juego.studio ?: ""
            Glide.with(binding.ivJuego.context).load(juego.photo).into(binding.ivJuego)

            binding.btnFavourite.setOnClickListener {
                // Create a Favoritos object from the Juego
                val favorito = Favoritos(juego.id)
                // Add the game to favorites list
                FavoritosProvider.agregarJuegoFavorito(favorito)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuegoViewHolder2 {
        val layoutInflater = LayoutInflater.from(parent.context)
        return JuegoViewHolder2(layoutInflater.inflate(R.layout.item_juego, parent, false))
    }

    override fun onBindViewHolder(holder: JuegoViewHolder2, position: Int) {
        val juego = juegoList[position]
        holder.bind(juego, onClickJuego, onClickDelete)
    }

    override fun getItemCount(): Int {
        return juegoList.size
    }

    fun setJuegoList(juegos: List<Juego2>) {
        _juegoList = juegos.toMutableList()
    }

    fun deleteJuego(pos: Int) {
        _juegoList.removeAt(pos)
    }
}
