package com.joaopaulozorek.buscacbmsc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.joaopaulozorek.buscacbmsc.entities.Perfil
import com.joaopaulozorek.buscacbmsc.entities.PerfilAdapter
import com.joaopaulozorek.buscacbmsc.services.RetrofitInitializer
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var perfis = mutableListOf<Perfil>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        updatePerfisList()

        viewManager = LinearLayoutManager(this)
        viewAdapter = PerfilAdapter(perfis, this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

    }

    private fun updatePerfisList() {
        perfis.clear()
        //val database = DatabaseHelper(applicationContext)
        val call = RetrofitInitializer().perfisService().getPerfis()

        call.enqueue(object : Callback<List<Perfil>?> {
            override fun onResponse(call: Call<List<Perfil>?>?,
                                    response: Response<List<Perfil>?>?) {
                response?.body()?.let(perfis::addAll)

                if (perfis.isEmpty()) {
                    perfis.add(Perfil("Nenhum perfil disponível","0,0","0,0", emptyList(), emptyList()))
                }else {
                    //database.addEvents(events)
                    //perfis.add(0, Perfil("Selecione um Perfil","0,0","0,0", emptyList(), emptyList()))
                }
                updadePerfilCards(perfis)
            }

            override fun onFailure(call: Call<List<Perfil>?>, t: Throwable) {
                if (perfis.isEmpty()) {

                    perfis.add(Perfil("Nenhum perfil disponível","0,0","0,0", emptyList(), emptyList()))
                }else {
                    //database.addEvents(events)
                    //perfis.add(0, Perfil("Selecione um Perfil","0,0","0,0", emptyList(), emptyList()))
                }
                updadePerfilCards(perfis)
            }


        })
    }


    private fun updadePerfilCards(perfis: List<Perfil>){
        viewManager = LinearLayoutManager(this)
        viewAdapter = PerfilAdapter(perfis, this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }
    }
}
