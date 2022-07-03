package com.stevenryandarmawan.listfilmterbaik

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listFilm = ArrayList<Film>()
        listFilm.add(Film("Shawnshank Redemption",R.drawable.shawn,"Penjara, Drama, Kriminal","1994","9.3"))
        listFilm.add(Film("Catch Me If You Can",R.drawable.cmiyc,"Drama, Kriminal","2002","8.1"))
        listFilm.add(Film("Dark",R.drawable.dark,"Misteri","2017","8.7"))
        listFilm.add(Film("3 Idiot",R.drawable.idiot,"Komedi","2009","8.4"))
        listFilm.add(Film("Interstellar",R.drawable.interstellar,"Fiksi, Ilmiah","2014","8.6"))
        listFilm.add(Film("James Bond",R.drawable.jamesbond,"Laga, Petualangan","2006","8"))
        listFilm.add(Film("John Wick",R.drawable.johnwick,"Laga","2014","7.4"))
        listFilm.add(Film("SPeaky Blinders",R.drawable.peakyblinders,"Drama, Kriminal","2013","8.8"))
        listFilm.add(Film("Taken",R.drawable.taken,"Laga, Kriminal","2008","7.8"))
        listFilm.add(Film("Vikings",R.drawable.viking,"Drama, Perang","2013","8.5"))

        binding.list.adapter = AdapterFilm(this,listFilm,object : AdapterFilm.OnClickListener {
            override fun detailData(item: Film?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_film)

                    val image = this.findViewById<ImageView>(R.id.image_film)
                    val judul = this.findViewById<TextView>(R.id.txtJudulFilm)
                    val genre = this.findViewById<TextView>(R.id.txtGenre)
                    val tahun = this.findViewById<TextView>(R.id.txtTahun)
                    val rating = this.findViewById<TextView>(R.id.txtRating)
                    val btn = this.findViewById<Button>(R.id.btnCLose)

                    image.setImageResource(item?.foto ?:0)
                    judul.text = "${item?.judul}"
                    genre.text = "${item?.genre}"
                    tahun.text = "${item?.tahun}"
                    rating.text = "${item?.rating}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })

    }
}