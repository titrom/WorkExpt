package com.example.workexpt.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.navigation.Navigation
import com.example.workexpt.R
import com.example.workexpt.model.HeroProfile
import com.example.workexpt.retrofit.Common
import com.example.workexpt.view.adapters.RecyclerHeroAdapter.AdapterRecyclerHero
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ListCharactersViewModel(var app: Application): BaseObservable() {
    init {
        start()
    }
    @get:Bindable
    val spinnerAdapter = ArrayAdapter(app, R.layout.custom_item_spinner,R.id.text_item, ArrayList<String>())

    @get:Bindable
    var heroesAdapters = AdapterRecyclerHero(ArrayList()).apply {
        onClickItem.subscribe{
            var key: View? = null
            var value: Int? = null
            it.forEach{ i ->
                key = i.key
                value = i.value
            }
            onClickHeroCard(key!!, value!!)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getSortSuperheroes(item: String) {
        Common.superheroesApi.getAllItems()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                it.filter { i -> i.biography.publisher == "Angel"
                        || i.biography.publisher == "Angel Salvadore"
                        || i.biography.publisher == "Ant-Man"
                        || i.biography.publisher == "Anti-Venom"
                        || i.biography.publisher == "Anti-Vision"
                        || i.biography.publisher == "Archangel"
                        || i.biography.publisher == "Binary"
                        || i.biography.publisher == "Boom-Boom"
                        || i.biography.publisher == "Deadpool"
                        || i.biography.publisher == "Evil Deadpool"
                        || i.biography.publisher == "Gemini V"
                        || i.biography.publisher == "Giant-Man"
                        || i.biography.publisher == "Goliath"
                        || i.biography.publisher == "Iron Lad"
                        || i.biography.publisher == "J. R. R. Tolkien"

                        || i.biography.publisher == "Jean Gray"
                        || i.biography.publisher == "Meltdown"
                        || i.biography.publisher == "Ms Marvel II"
                        || i.biography.publisher == "Phoenix"
                        || i.biography.publisher == "Power Man"
                        || i.biography.publisher == "Power Woman"
                        || i.biography.publisher == "Rune King Thor"
                        || i.biography.publisher == "She- Thing"
                        || i.biography.publisher == "Spider-Carnage"
                        || i.biography.publisher == "Tempest"
                        || i.biography.publisher == "Thunderbird II"
                        || i.biography.publisher == "Vindicator II"
                }.forEach { i ->
                    i.biography.publisher = "Marvel Comics"
                }
                it.filter { i -> i.biography.publisher == "Aztar"
                        || i.biography.publisher == "Batgirl"
                        || i.biography.publisher == "Batgirl III"
                        || i.biography.publisher == "Batgirl III"
                        || i.biography.publisher == "Batgirl V"
                        || i.biography.publisher == "Batman II"
                        || i.biography.publisher == "Black Racer"
                        || i.biography.publisher == "Flash IV"
                        || i.biography.publisher == "Impulse"
                        || i.biography.publisher == "Nightwing"
                        || i.biography.publisher == "Oracle"
                        || i.biography.publisher == "Red Hood"
                        || i.biography.publisher == "Red Robin"
                        || i.biography.publisher == "Robin II"
                        || i.biography.publisher == "Robin III"
                        || i.biography.publisher == "Scorpion"
                        || i.biography.publisher == "Speed Demon"
                        || i.biography.publisher == "Spoiler"
                        || i.biography.publisher == "Superman Prime One-Million"
                        || i.biography.publisher == "Toxin"
                        || i.biography.publisher == "Venom III"

                }.forEach { i ->
                    i.biography.publisher = "DC Comics"
                }
                heroesAdapters.hps.clear()
                heroesAdapters.notifyDataSetChanged()
                if (item == "All publisher"){
                    heroesAdapters.hps.addAll(it.filter { i -> i.biography.publisher != null}.map { i ->
                        val logoid: Int = app.resources.getIdentifier(i.biography.publisher.lowercase().
                        replace("-","").replace(" ", "").replace(".", "")
                            ,"drawable", app.packageName)
                        HeroProfile(i.id, i.name, i.biography.fullName, Uri.parse(i.images.md), logoid)
                    })
                }else{
                    heroesAdapters.hps.addAll(it.filter { i -> i.biography.publisher == item }.map { i ->
                        val logoid: Int = app.resources.getIdentifier(i.biography.publisher.lowercase().
                        replace("-","").replace(" ", "").replace(".", "")
                            ,"drawable", app.packageName)
                        HeroProfile(i.id, i.name, i.biography.fullName, Uri.parse(i.images.md), logoid)
                    })
                }
                heroesAdapters.notifyDataSetChanged()
            },{
            })
    }

    @SuppressLint("NotifyDataSetChanged")
    fun start(){
        val list = ArrayList<String>()

        Common.superheroesApi.getAllItems()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                it.filter { i -> i.biography.publisher == "Angel"
                        || i.biography.publisher == "Angel Salvadore"
                        || i.biography.publisher == "Ant-Man"
                        || i.biography.publisher == "Anti-Venom"
                        || i.biography.publisher == "Anti-Vision"
                        || i.biography.publisher == "Archangel"
                        || i.biography.publisher == "Binary"
                        || i.biography.publisher == "Boom-Boom"
                        || i.biography.publisher == "Deadpool"
                        || i.biography.publisher == "Evil Deadpool"
                        || i.biography.publisher == "Gemini V"
                        || i.biography.publisher == "Giant-Man"
                        || i.biography.publisher == "Goliath"
                        || i.biography.publisher == "Iron Lad"
                        || i.biography.publisher == "J. R. R. Tolkien"
                        || i.biography.publisher == "Jean Grey"
                        || i.biography.publisher == "Meltdown"
                        || i.biography.publisher == "Ms Marvel II"
                        || i.biography.publisher == "Phoenix"
                        || i.biography.publisher == "Power Man"
                        || i.biography.publisher == "Power Woman"
                        || i.biography.publisher == "Rune King Thor"
                        || i.biography.publisher == "She- Thing"
                        || i.biography.publisher == "Spider-Carnage"
                        || i.biography.publisher == "Tempest"
                        || i.biography.publisher == "Thunderbird II"
                        || i.biography.publisher == "Vindicator II"
                }.forEach { i ->
                    i.biography.publisher = "Marvel Comics"
                }
                it.filter { i -> i.biography.publisher == "Aztar"
                        || i.biography.publisher == "Batgirl"
                        || i.biography.publisher == "Batgirl III"
                        || i.biography.publisher == "Batgirl III"
                        || i.biography.publisher == "Batgirl V"
                        || i.biography.publisher == "Batman II"
                        || i.biography.publisher == "Black Racer"
                        || i.biography.publisher == "Flash IV"
                        || i.biography.publisher == "Impulse"
                        || i.biography.publisher == "Nightwing"
                        || i.biography.publisher == "Oracle"
                        || i.biography.publisher == "Red Hood"
                        || i.biography.publisher == "Red Robin"
                        || i.biography.publisher == "Robin II"
                        || i.biography.publisher == "Robin III"
                        || i.biography.publisher == "Scorpion"
                        || i.biography.publisher == "Speed Demon"
                        || i.biography.publisher == "Spoiler"
                        || i.biography.publisher == "Superman Prime One-Million"
                        || i.biography.publisher == "Toxin"
                        || i.biography.publisher == "Venom III"
                }.forEach { i ->
                    i.biography.publisher = "DC Comics"
                }
                heroesAdapters.hps.clear()
                heroesAdapters.hps.addAll(it.filter { i -> i.biography.publisher != null}.map { i ->
                    val logoid: Int = app.resources.getIdentifier(i.biography.publisher.lowercase().
                    replace("-","").replace(" ", "").replace(".", "")
                    ,"drawable", app.packageName)
                    HeroProfile(i.id, i.name, i.biography.fullName, Uri.parse(i.images.md), logoid)
                })
                heroesAdapters.notifyDataSetChanged()
                list.addAll(it.map { i -> i.biography.publisher})
                list.sortBy { i -> i }
                list.add(0,"All publisher")
                spinnerAdapter.clear()
                spinnerAdapter.addAll(list.distinct().filterNotNull())
                spinnerAdapter.notifyDataSetChanged()

            },{
            })
    }

    val onItemSelected = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val item = parent?.getItemAtPosition(position).toString()
            getSortSuperheroes(item)
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {
        }

    }
    private fun onClickHeroCard(v: View, id: Int){
        val bundle = Bundle()
        bundle.putInt("Id", id)
        Navigation.findNavController(v)
            .navigate(R.id.action_listCharactersFragment_to_profileSuperheroFragment, bundle)

    }
}