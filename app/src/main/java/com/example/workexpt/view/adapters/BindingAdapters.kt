package com.example.workexpt.view.adapters

import android.net.Uri
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.workexpt.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

@BindingAdapter("app:imageUriListCharacters")
public fun loadImageListCharacters(imageView: ImageView, uri: Uri) {
    Picasso.get().load(uri).into(imageView)
}


@BindingAdapter("app:imageUriProfile")
public fun loadImageProfile(imageView: ImageView, uri: Uri) {
    Picasso.get()
        .load(uri)
        .resize(imageView.width, 1500)
        .centerCrop()
        .into(imageView)
}
@BindingAdapter("app:colorIconFloatingActionButton")
fun colorIconFloatingActionButton(button: FloatingActionButton, s: String){
    button.setColorFilter(ContextCompat.getColor(button.context, R.color.item_color))
}
@BindingAdapter("app:logoLoad")
public fun logoLoad(imageView: ImageView, logoId: Int) {
    if (logoId != 0) Picasso.get().load(logoId).into(imageView)
    else Picasso.get().load(R.drawable.ic_null).into(imageView)
}