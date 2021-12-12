package com.example.workexpt.view.adapters.RecyclerHeroAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.workexpt.databinding.HeroRecyclerItemBinding
import com.example.workexpt.model.HeroProfile
import io.reactivex.rxjava3.subjects.PublishSubject

class AdapterRecyclerHero(var hps: ArrayList<HeroProfile>)
    : RecyclerView.Adapter<AdapterRecyclerHero.HolderAdapterHero>() {
    var onClickItem: PublishSubject<HashMap<View, Int>> = PublishSubject.create()

    class HolderAdapterHero(view: View): RecyclerView.ViewHolder(view){
        val binding = DataBindingUtil.bind<HeroRecyclerItemBinding>(view)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderAdapterHero {
        val binding = HeroRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HolderAdapterHero(binding.root)
    }

    override fun onBindViewHolder(holder: HolderAdapterHero, position: Int) {
        holder.binding?.hero = hps[position]
        holder.itemView.setOnClickListener{
            val onNextItem = HashMap<View, Int>()
            onNextItem[it] = hps[position].id!!
            onClickItem.onNext(onNextItem)
        }
    }

    override fun getItemCount(): Int = hps.size
}