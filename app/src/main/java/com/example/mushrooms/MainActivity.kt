package com.example.mushrooms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mushrooms.adapter.ItemAdapter
import com.example.mushrooms.model.Mushrooms

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView;
    private lateinit var mushroomsList : ArrayList<Mushrooms>

    lateinit var mushroom_image : List<Int>
    lateinit var mushroom_image2 : List<Int>
    lateinit var mushroom_colors : List<Int>
    lateinit var mushroom_name : Array<String>
    lateinit var species : Array<String>
    lateinit var division : Array<String>
    lateinit var class_name : Array<String>
    lateinit var order : Array<String>
    lateinit var family : Array<String>
    lateinit var genus : Array<String>
    lateinit var other_names : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mushroom_image = listOf(
            R.drawable.amethyst_deceiver,
            R.drawable.anemone_stinkhorn,
            R.drawable.blue_pinkgill,
            R.drawable.fly_agaric,
            R.drawable.indigo_milk_cap,
            R.drawable.mauve_parachute,
            R.drawable.purple_jellydisc,
            R.drawable.red_cage,
            R.drawable.violet_coral,
            R.drawable.wrinkled_peach
        )
        mushroom_image2 = listOf(
            R.drawable.amethyst_deceiver_2,
            R.drawable.anemone_stinkhorn_2,
            R.drawable.blue_pinkgill_2,
            R.drawable.fly_agaric_2,
            R.drawable.indigo_milk_cap_2,
            R.drawable.mauve_parachute_2,
            R.drawable.purple_jellydisc_2,
            R.drawable.red_cage_2,
            R.drawable.violet_coral_2,
            R.drawable.wrinkled_peach_2
        )

        mushroom_colors = listOf(
            R.color.amethyst,
            R.color.anemone,
            R.color.blue,
            R.color.agaric,
            R.color.indigo,
            R.color.mauve,
            R.color.purple,
            R.color.redcage,
            R.color.violet,
            R.color.peach
        )

        mushroom_name = resources.getStringArray(R.array.mushroom_name)
        species = resources.getStringArray(R.array.species)
        division = resources.getStringArray(R.array.division)
        class_name = resources.getStringArray(R.array.class_name)
        order = resources.getStringArray(R.array.order)
        family = resources.getStringArray(R.array.family)
        genus = resources.getStringArray(R.array.genus)
        other_names = resources.getStringArray(R.array.other_names)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        mushroomsList = arrayListOf<Mushrooms>()
        loadMushrooms();
    }

    private fun loadMushrooms() {

        for(i in mushroom_image.indices){

            val mushroom = Mushrooms(mushroom_image[i], species[i], mushroom_name[i])
            mushroomsList.add(mushroom)
        }

        var adapter = ItemAdapter(this, mushroomsList)
        recyclerView.adapter = adapter;
        adapter.setOnItemClickListener(object : ItemAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity, MushroomsActivity::class.java)
                intent.putExtra("mushroom_name", mushroomsList[position].mushroomName)
                intent.putExtra("mushroom_image", mushroomsList[position].titleImage)
                intent.putExtra("species", mushroomsList[position].species)
                intent.putExtra("mushroom_image2", mushroom_image2[position])
                intent.putExtra("division", division[position])
                intent.putExtra("class_name", class_name[position])
                intent.putExtra("order", order[position])
                intent.putExtra("family", family[position])
                intent.putExtra("genus", genus[position])
                intent.putExtra("other_names", other_names[position])
                intent.putExtra("mushroom_colors", mushroom_colors[position])
                startActivity(intent)
            }
        })
    }
}

