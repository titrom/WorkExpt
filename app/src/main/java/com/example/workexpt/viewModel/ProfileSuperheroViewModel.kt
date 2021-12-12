package com.example.workexpt.viewModel

import android.app.Application
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import com.example.workexpt.R
import com.example.workexpt.retrofit.Common
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ProfileSuperheroViewModel(app: Application, args: Bundle?): BaseObservable()  {

    @get:Bindable
    var nickname = " "
    set(value) {
        field = value
        notifyPropertyChanged(BR.nickname)
    }


    @get:Bindable
    var realName = " "
    set(value) {
        field = value
        notifyPropertyChanged(BR.realName)
    }

    @get:Bindable
    var logoId = 0
    set(value) {
        field = value
        notifyPropertyChanged(BR.logoId)
    }
    @get:Bindable
    var direction = " "
    set(value) {
        field = value
        notifyPropertyChanged(BR.direction)
    }

    @get:Bindable
    var imageSuperhero = Uri.parse(" ")
    set(value) {
        field = value
        notifyPropertyChanged(BR.imageSuperhero)
    }


    init {
        val id = args?.getInt("Id")
        Common.superheroesApi.getItem(id!!)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                if (
                        it.biography.publisher == "Angel"
                        || it.biography.publisher == "Angel Salvadore"
                        || it.biography.publisher == "Ant-Man"
                        || it.biography.publisher == "Anti-Venom"
                        || it.biography.publisher == "Anti-Vision"
                        || it.biography.publisher == "Archangel"
                        || it.biography.publisher == "Binary"
                        || it.biography.publisher == "Boom-Boom"
                        || it.biography.publisher == "Deadpool"
                        || it.biography.publisher == "Evil Deadpool"
                        || it.biography.publisher == "Gemini V"
                        || it.biography.publisher == "Giant-Man"
                        || it.biography.publisher == "Goliath"
                        || it.biography.publisher == "Iron Lad"
                        || it.biography.publisher == "J. R. R. Tolkien"
                        || it.biography.publisher == "Jean Grey"
                        || it.biography.publisher == "Meltdown"
                        || it.biography.publisher == "Ms Marvel II"
                        || it.biography.publisher == "Phoenix"
                        || it.biography.publisher == "Power Man"
                        || it.biography.publisher == "Power Woman"
                        || it.biography.publisher == "Rune King Thor"
                        || it.biography.publisher == "She- Thing"
                        || it.biography.publisher == "Spider-Carnage"
                        || it.biography.publisher == "Tempest"
                        || it.biography.publisher == "Thunderbird II"
                        || it.biography.publisher == "Vindicator II"

                )
                        { it.biography.publisher = "Marvel Comics"}
                if(
                        it.biography.publisher == "Aztar"
                        || it.biography.publisher == "Batgirl"
                        || it.biography.publisher == "Batgirl III"
                        || it.biography.publisher == "Batgirl III"
                        || it.biography.publisher == "Batgirl V"
                        || it.biography.publisher == "Batman II"
                        || it.biography.publisher == "Black Racer"
                        || it.biography.publisher == "Flash IV"
                        || it.biography.publisher == "Impulse"
                        || it.biography.publisher == "Nightwing"
                        || it.biography.publisher == "Oracle"
                        || it.biography.publisher == "Red Hood"
                        || it.biography.publisher == "Red Robin"
                        || it.biography.publisher == "Robin II"
                        || it.biography.publisher == "Robin III"
                        || it.biography.publisher == "Scorpion"
                        || it.biography.publisher == "Speed Demon"
                        || it.biography.publisher == "Spoiler"
                        || it.biography.publisher == "Superman Prime One-Million"
                        || it.biography.publisher == "Toxin"
                        || it.biography.publisher == "Venom III"

                )
                        { it.biography.publisher = "DC Comics" }

                nickname = it.name
                realName = it.biography.fullName
                logoId = app.resources.getIdentifier(it.biography.publisher.lowercase()
                    .replace("-","")
                    .replace(" ", "")
                    .replace(".", "")
                    ,"drawable", app.packageName)
                direction = it.connections.groupAffiliation.replace(";",",") + ". "+
                        it.connections.relatives.replace(";",",")
                imageSuperhero = Uri.parse(it.images.lg)
            },{

            })
    }

    var onClickExit = View.OnClickListener { v ->
        Navigation.findNavController(v!!)
            .navigate(R.id.action_profileSuperheroFragment_to_listCharactersFragment)
    }
}
