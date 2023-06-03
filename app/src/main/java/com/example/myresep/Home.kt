package com.example.myresep


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class Home : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENTS"
    }

    private var gridLayoutManager : GridLayoutManager? = null
    private var resepList = mutableListOf<Resep>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)

        resepList = ArrayList()

        val recyclerView = findViewById<RecyclerView>(R.id.resep_recyclerList)
        gridLayoutManager = GridLayoutManager(applicationContext, 2,
            LinearLayoutManager.VERTICAL,false)

        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        recyclerView.adapter = RecyclerViewResep(this, resepList){
            val intent = Intent(this, DetailResep::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

        prepareResepListData()

    }

    private fun prepareResepListData(){
        var resep = Resep(
            R.drawable.nasi_goreng,
            "Nasi Goreng",
            "BAHAN - BAHAN :\n" +
                    "- 500 gr nasi\n" +
                    "- 3 sdm minyak sayur \n" +
                    "- 150 gr daging ayam goreng suwir\n" +
                    "- 3 sdm kecap manis\n" +
                    "- 2 butir telur ayam\n" +
                    "- 1 sdm kaldu bubuk non MSG\n" +
                    "- 1/2 sdt merica bubuk\n" +
                    "\n" +
                    "HALUSKAN :\n" +
                    "- 5 butir bawang merah\n" +
                    "- 3 siung bawang putih\n" +
                    "- 3 buah cabe merah\n" +
                    "- 2 sdt terasi goreng\n" +
                    "- 2 sdt garam\n" +
                    "\n" +
                    "LANGKAH - LANGKAH :\n" +
                    "1. Panaskan minyak, tumis bumbu halus hingga wangi.\n" +
                    "2. Kocok telur hingga rata. Tuangkan ke dalam bumbu. Aduk rata.\n" +
                    "3. Masukkan nasi, ayam suwir, kaldu bubuk, kecap manis dan merica.\n" +
                    "4. Aduk-aduk hingga seluruhnya tercampur rata dan agak kering.\n" +
                    "5. Angkat dan sajikan dengan Pelengkapnya")
        resepList.add(resep)

        resep = Resep(
            R.drawable.ayam_geprek,
            "Ayam Geprek",
            "BAHAN - BAHAN :\n" +
                    "\n" +
                    "- 2 potong ayam; bagian paha dan dada ayam\n" +
                    "- 1 butir telur\n" +
                    "- 5 sendok tepung terigu\n" +
                    "- 3 sendok tepung maizena\n" +
                    "- 3 siung bawang putih\n" +
                    "- Secukupnya merica\n" +
                    "- Secukupnya garam\n" +
                    "- Secukupnya minyak goreng\n" +
                    "- 1 batang daun kemangi\n" +
                    "\n"+
                    "SAMBAL :\n" +
                    "- 22 buah cabe rawit\n" +
                    "- 2 siung bawang putih, digoreng\n" +
                    "- Secukupnya garam")
        resepList.add(resep)

        resep = Resep(
            R.drawable.sate_kambing,
            "Sate Kambing",
            "- Daging kambing, potong dadu 2 cm - 500 gram\n" +
                    "- Tusuk sate, rendam dalam air lalu tiriskan - 20 buah\n" +
                    "\n"+
                    "BUMBU OLESAN:\n" +
                    "- Bawang putih, haluskan - 2 siung\n" +
                    "- Ketumbar halus - 1/2 sdt\n" +
                    "- Merica halus - 1/4 sdt\n" +
                    "- Kecap manis - 100 ml\n" +
                    "- Air perasan jeruk nipis - secukupnya\n" +
                    "\n"+
                    "PELENGKAP:\n" +
                    "- Kubis, iris halus - 50 gram\n" +
                    "- Tomat merah, potong - 2 buah\n" +
                    "- Cabai rawit, iris - 10 buah\n" +
                    "- Bawang merah, iris - 10 butir\n" +
                    "- Kecap manis - 5 sdm\n" +
                    "- Jeruk nipis, belah jadi 4 - 1 buah\n" +
                    "- Acar timun - secukupnya\n"+
                    "\n"+
                    "LANGKAH - LANGKAH :\n" +
                    "1. Tusuk daging dengan tusukan sate. Isi setiap tusukan dengan 4 potong daging. Sisihkan.\n" +
                    "2. Dalam wadah, campur semua bahan olesan lalu oleskan ke daging sate.\n" +
                    "3. Bakar sate di atas bara api sambil sesekali dioles bumbu oles. Bakar hingga berwarna kecoklatan, matang, dan harum. Angkat.\n" +
                    "4. Tata semua bahan pelengkap (Acar timun) dan sate di atas piring saji. Tuang kecap manis di atas sate. Siap disajikan.\n" +
                    "\n"+
                    "TIPS :\n" +
                    "1. Agar daging tidak alot, gunakan daging kambing muda yang berusia maksimal 5 bulan.\n" +
                    "2. Jika suka, anda juga bisa menggunakan hati kambing.\n" +
                    "3. Bakar sate pakai panggangan lebih mudah dan praktis. Nah, kunci dari panggangan yang sempurna adalah wajan panas. Pakailah wajan besi jika ingin hasilnya sempurna, tapi tak masalah kalau pakai teflon atau grilling pan, seperti Maxim Teflon Square Grill (Lihat di Lazada DISKON) berlapis Teflon Xtra yang aman karena bebas PFOA")
        resepList.add(resep)

        resep = Resep(
            R.drawable.nasi_kuning,
            "Nasi Kuning",
            "BAHAN - BAHAN :\n" +
                    "- 500 gr beras putih\n" +
                    "- 100 ml santan kental\n" +
                    "- 100 ml santan encer\n" +
                    "- Garam secukupnya\n" +
                    "- 3 lbr daun salam\n" +
                    "- 300 ml air kunyit\n" +
                    "\n" +
                    "BAHAN PELENGKAP :\n" +
                    "- Bihun goreng\n" +
                    "- Telur dadar, iris tipis\n" +
                    "- Kering tempe\n" +
                    "- Perkedel\n" +
                    "- Serundeng/ abon\n" +
                    "\n"+
                    "LANGKAH - LANGKAH :\n"+
                    "- Cuci beras hingga bersih hingga airnya berwarna bening.\n" +
                    "- Masukkan beras ke dalam panci, campurkan dengan air kunyit, garam secukupnya untuk menciptakan rasa gurih, daun salam, santan kentan dan encer. Masak hingga air menyusut dan nasi setengah matang.\n" +
                    "- Pindahkan nasi ke dalam panci pengukus. Kukus nasi selama kurang lebih 20-25 menit atau hingga nasi matang.\n" +
                    "- Jika nasi sudah matang, angkat dan pindahkan ke dalam magic jar agar nasi tetap hangat.\n" +
                    "- Hidangkan nasi kuning dengan bahan pelengkap.")
        resepList.add(resep)

        resep = Resep(
            R.drawable.rawon,
            "Rawon",
            "BAHAN - BAHAN :\n" +
                    "- 500 g daging sandung lamur sapi\n" +
                    "- 1 Dengkul sapi, belah dua\n" +
                    "- 3 Lembar daun jeruk purut segar\n" +
                    "- 1 Batang serai, memarkan\n" +
                    "- 1 Sdm air asam jawa\n" +
                    "- 2 Batang daun bawang, iris seukuran 1 cm\n" +
                    "- 1 Sdm Royco Kaldu Sapi\n" +
                    "- 1 Sdm garam\n" +
                    "- 3 Liter air\n" +
                    "- 5 Sdm minyak goreng\n" +
                    "\n"+
                    "BUMBU HALUS :\n" +
                    "- 4 Siung bawang putih\n" +
                    "- 8 Butir bawang merah\n" +
                    "- 5 Buah keluak, geprek dan rendam isinya dengan air panas\n" +
                    "- 4 Butir kemiri, sangrai\n" +
                    "- 1 cm kunyit, bakar\n" +
                    "\n"+
                    "PELENGKAP :\n" +
                    "- Taoge pendek\n" +
                    "- Telur asin\n" +
                    "- Sambal rawit\n" +
                    "- Jeruk nipis\n" +
                    "- Emping\n"+
                    "\n"+
                    "LANGKAH -LANGKAH :\n" +
                    "1. Rebus daging dan dengkul sapi hingga setengah lunak. Potong daging sesuai selera. Sisihkan.\n" +
                    "2. Masukkan Royco Kaldu Sapi dan garam ke dalam air rebusan daging.\n" +
                    "3. Tumis bumbu halus, lengkuas, daun jeruk, dan serai hingga harum dan matang.\n" +
                    "4. Masukkan potongan daging ke dalam tumisan, masak hingga bumbu meresap.\n" +
                    "5. Masukkan tumisan daging ke dalam kuah kaldu. Masak dengan api kecil hingga daging empuk.\n" +
                    "6. Sajikan hangat beserta pelengkap.")
        resepList.add(resep)

        resep = Resep(
                R.drawable.papeda,
            "Papeda",
            "BAHAN - BAHAN :\n"+
                    "- Tepung sagu - 250 gram\n" +
                    "- Bawang putih - 2 siung\n" +
                    "- Garam - 1/2 sdm\n" +
                    "- Air - 4 gelas\n"+
                    "\n"+
                    "LANGKAH - LANGKAH :\n"+
                    "Dalam panci, didihkan 3 gelas air. Sisihkan.\n" +
                    "2 Dalam panci yang lain, campur tepung sagu, bawang putih, garam, dan 1 gelas air. Aduk rata.\n" +
                    "3 Ambil air yang telah mendidih lalu tuangkan secara perlahan ke dalam campuran tepung sagu.\n" +
                    "4 Masak campuran tepung sagu dengan api kecil sambil terus diaduk hingga mengental. Angkat.\n" +
                    "5 Siap disajikan.\n" +
                    "\n" +
                    "TIPS :\n" +
                    "1. Saat dimasak, papeda harus terus diaduk hingga mengental.\n" +
                    "2. Pakailah panci anti lengket dari GM Bear Set Panci Merah isi 3 pcs (Lihat di Lazada DISKON) agar papeda tidak menempel pada dasar panci. Lapisannya yang terbuat dari bahan berkualitas juga dapat menghantar panas dengan cepat dan merata.")
        resepList.add(resep)
    }


}