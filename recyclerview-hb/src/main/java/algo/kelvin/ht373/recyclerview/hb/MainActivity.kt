package algo.kelvin.ht373.recyclerview.hb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<Any>()
        list.add(Island("Jawa"))
        list.add(Province("DKI Jakarta", "Jakarta"))
        list.add(Province("Jawa Tengah", "Semarang"))
        list.add(Province("Jawa Timur", "Surabaya"))
        list.add(Province("Jawa Barat", "Bandung"))
        list.add(Province("DI Yogyakarta", "Yogyakarta"))
        list.add(Province("Banten", "Banten"))
        list.add(Island("Sumatra"))
        list.add(Province("Aceh", "Banda Aceh"))
        list.add(Province("Sumatera Utara", "Medan"))
        list.add(Province("Sumatera Barat", "Padang"))
        list.add(Province("Jambi", "Jambi"))
        list.add(Province("Riau", "Pekanbaru"))
        list.add(Province("Kepulauan Riau", "Tanjung Pinang"))
        list.add(Province("Bengkulu", "Bengkulu"))
        list.add(Province("Sumatera Selatan", "Palembang"))
        list.add(Province("Kepulauan Bangka Belitung", "Pangkal Pinang"))
        list.add(Province("Lampung", "Bandar Lampung"))
        list.add(Island("Kalimantan"))
        list.add(Province("Kalimantan Utara", "Tanjung Selor"))
        list.add(Province("Kalimantan Tengah", "Palangkaraya"))
        list.add(Province("Kalimantan Timur", "Samarinda"))
        list.add(Province("Kalimantan Barat", "Pontianak"))
        list.add(Province("Kalimantan Selatan", "Banjarmasin"))
    }
}
