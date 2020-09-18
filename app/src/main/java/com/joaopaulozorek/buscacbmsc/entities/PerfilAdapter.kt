package com.joaopaulozorek.buscacbmsc.entities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joaopaulozorek.buscacbmsc.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.card_perfil.view.*

public class PerfilAdapter(private val perfis:List<Perfil>, val context: Context):RecyclerView.Adapter<PerfilAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_perfil, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return perfis.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.let {
            it.bindView(perfis[position])
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(perfil: Perfil) {
            itemView.card_perfil_titulo.text = perfil.perfil
            itemView.card_perfil_deslocamento_medio.text = "Deslocamento Médio: "+perfil.deslocamento_medio
            itemView.card_perfil_deslocamento_medio_geral.text = "Deslocamento Médio Geral: "+perfil.deslocamento_medio_geral
        }
    }
}