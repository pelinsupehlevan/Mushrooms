package com.example.mushrooms

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MushroomsActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mushroom)

        val mushroomImages : ImageView = findViewById(R.id.mushroom_image);
        val mushroomImages2 : ImageView = findViewById(R.id.mushroom_image2);
        val mushroomName : TextView = findViewById(R.id.mushroom_name);
        val species : TextView = findViewById(R.id.species);
        val division : TextView = findViewById(R.id.division);
        val className : TextView = findViewById(R.id.class_name);
        val order : TextView = findViewById(R.id.order);
        val family : TextView = findViewById(R.id.family);
        val genus : TextView = findViewById(R.id.genus);
        val otherNames : TextView = findViewById(R.id.other_names);

        val bundle : Bundle ?= intent.extras

        val imageId1 = bundle!!.getInt("mushroom_image")
        val imageId2 = bundle!!.getInt("mushroom_image2")
        val names = bundle.getString("mushroom_name")
        val color = bundle.getInt("mushroom_colors")
        val species_ = bundle.getString("species")
        val division_ = bundle.getString("division")
        val class_ = bundle.getString("class_name")
        val order_ = bundle.getString("order")
        val family_ = bundle.getString("family")
        val genus_ = bundle.getString("genus")
        val other_ = bundle.getString("other_names")


        val textColor = ContextCompat.getColor(this, color)

        mushroomImages.setImageResource(imageId1)
        mushroomImages2.setImageResource(imageId2)
        mushroomName.text = names;
        species.text = species_;
        division.text = division_;
        className.text = class_;
        order.text = order_;
        family.text = family_;
        genus.text = genus_;
        otherNames.text = other_;
        mushroomName.setTextColor(textColor)
    }
}

