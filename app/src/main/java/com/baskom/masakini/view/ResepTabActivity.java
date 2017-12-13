package com.baskom.masakini.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baskom.masakini.R;
import com.baskom.masakini.controller.ResepCardAdapter;
import com.baskom.masakini.model.Bahan;
import com.baskom.masakini.model.Resep;
import com.baskom.masakini.model.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class ResepTabActivity extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_resep, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);

        ResepCardAdapter adapter = new ResepCardAdapter(generateDummyList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        return rootView;
    }

    //Method buat bikin list resep dummy
    private List<Resep> generateDummyList(){
        List<Resep> resepList = new ArrayList<>();

        List<Bahan> bahan = new ArrayList<>();
        bahan.add(new Bahan("350 gram","Gula"));
        bahan.add(new Bahan("4 butir","Telur"));
        bahan.add(new Bahan("2 sdt","Vanilla"));
        bahan.add(new Bahan("240 ml","Susu Murni"));
        bahan.add(new Bahan("Secukupnya","Whipped Cream"));
        bahan.add(new Bahan("Secukupnya","Sirup"));
        bahan.add(new Bahan("Secukupnya","Garam"));
        bahan.add(new Bahan("1 bundle","Jajanan 90'an"));

        List<Step> step = new ArrayList<>();
        step.add(new Step("Siapkan Bahan", "Saring tepung terigu sedang dan garam, kemudian sisihkan"));
        step.add(new Step("Olah Adonan", "Aduk butter dan gula hingga mengembang, kemudian masukkan telur satu per satu dan masukkan perisa vanila. Masukkan secara bergantian tepung dan susu mentega, dan diakhiri dengan tepung"));
        step.add(new Step("Siapkan Adonan", "Tuang ke dalam loyang kue, dan kemudian panggang selama 30-35 menit dengan suhu 180*C"));
        step.add(new Step("Bagi Whipped Cream", "Bagi whipped cream menjadi dua, satu untuk warna pink, satu untuk warna kuning"));
        step.add(new Step("Oleskan Sirup", "Ambil kue pertama, oles dengan simple sirup. Susun hingga kue ke empat"));
        step.add(new Step("Taburkan Cream", "Oles kue dengan whipped cream, ratakan"));
        step.add(new Step("Hias Kue","Hias kue sesuai selera"));

        Resep resep = new Resep(
                R.drawable.img_90s_cake,
                "90's Cake",
                "Kue dengan topping jajanan 90'an.",
                "Masih kita ingat jenis jajanan di tahun 1990-an seperti rambut nenek a.k.a gulali, permen hot hot pop a.k.a permen kaki, cokelat payung, cokelat koin, dll. Kali ini bahan-bahan tersebut menjadi hiasan untuk kue drip cake!",
                "Sedang",
                "10 orang",
                "50 Menit",
                8,
                bahan,
                7,
                step
        );
        resepList.add(resep);


        List<Bahan> bahan1 = new ArrayList<>();
        bahan1.add(new Bahan("1 ekor","Ayam kampung"));
        bahan1.add(new Bahan("2 sdm","Jeruk nipis"));
        bahan1.add(new Bahan("2 butir","Telur"));
        bahan1.add(new Bahan("2 ruas","Lengkuas"));
        bahan1.add(new Bahan("4 siung","Bawang putih"));
        bahan1.add(new Bahan("1/2 sdt","Garam"));
        bahan1.add(new Bahan("1 ruas","Kunyit"));
        bahan1.add(new Bahan("Secukupnya","Minyak goreng"));

        List<Step> step1 = new ArrayList<>();
        step1.add(new Step("Haluskan Bumbu","haluskan 4 siung bawang merah, 1/sdt garam, dan 1 ruas kunyit dengan tambahan minyak goreng secukupnya"));
        step1.add(new Step("Siapkan Ayam","Cuci bersih ayam, kemudian lumuri dengan air jeruk nipis dan bumbu halus. diamkan selama 30 menit hingga bumbu meresap."));
        step1.add(new Step("Masukkan Ayam","Celupkan ayam berbumbu ke dalam telur kocok yang di campur dengan lengkuas parut"));
        step1.add(new Step("Goreng Ayam","Goreng ayam dengan minyak panas hingga berwarna kuning kecoklatan dan matang. Angkat, tiriskan."));

        Resep resep1 = new Resep(
                R.drawable.img_ayam_goreng,
                "Ayam Goreng Saos Padang",
                "Ayam goreng dibalut dengan saos padang",
                "Ayam goreng saos padang adalah varian ayam goreng yang dibumbui dengan saos khas padang dengan bumbu khas rempah-rempah masakan padang.",
                "Sulit",
                "4 orang",
                "50 Menit",
               8,
                bahan1,
                4,
                step1
        );
        resepList.add(resep1);

        List<Bahan> bahan2 = new ArrayList<>();
        bahan2.add(new Bahan("2 pcs","Daging ayam paha boneless"));
        bahan2.add(new Bahan("1 buah","Jeruk nipis"));
        bahan2.add(new Bahan("20 pcs","Cabe rawit merah"));
        bahan2.add(new Bahan("3 pcs","Daun jeruk"));
        bahan2.add(new Bahan("1 genggam","Daun kemangi"));
        bahan2.add(new Bahan("3 pcs ","Belimbing wuluh"));
        bahan2.add(new Bahan("8 pcs","Bawang merah"));
        bahan2.add(new Bahan("3 pcs","Bawang putih"));
        bahan2.add(new Bahan("1 ruas","Jahe"));
        bahan2.add(new Bahan("3 pcs","Kemiri"));
        bahan2.add(new Bahan("1pcs ","Daun sereh"));
        bahan2.add(new Bahan("1 pcs","Daun salam"));
        bahan2.add(new Bahan("Secukupnya","Bawang goreng"));
        bahan2.add(new Bahan("Secukupnya","Daun pisang"));

        List<Step> step2 = new ArrayList<>();
        step2.add(new Step("Membuat Jontoran","Masukan cabai rawit , bawang merah dan 1 pcs daun jeruk ke dalam chooper dan haluskan jangan terlalu halus. Blender halus kemiri , bawang putih dan jahe. Saute bumbu blenderan halus hingga matang lalu masukan sereh dan sisa daun jeruk. Masukan bumbu yg di chopper dan masak hingga harum , lalu masukan belimbing wuluh  .Masukam ayam yg telah dipotong kecil2. Masak hingga matang dan tambahkan daun kemangi terakhir"));
        step2.add(new Step("Membuat Nasi Bakar","Oseng bawang merah hingga harum lalu masukan daun bawang , daun salam dan sereh .Masukan nasi dan aduk hingga tercampur .Beru garam lada dan penyedap"));
        step2.add(new Step("Bungkus Nasi","Siapkan daun pisang lalu tuang nasi putih tadi beserta daun salam dan serehnya lalu tambahkan kemangi. Taruh jontoran diatas nasi lalu gulung rapat dan ikat dengan tusuk gigi atau staples. Kukus sebentar nasi hingga daun terlihat layu. Siapkan bakaran dan bakar nasi tadi hingga daun pisang kecoklatan .Sajikan dengan pasangan hidupmu"));

        Resep resep2 = new Resep(
                R.drawable.img_nasi_bakar_bumbu_jontor,
                "Nasi Bakar Bumbu Jontor",
                "Nasi bakar yang dibalut dengan bumbu bedas",
                "Nasi bakar bumbu jontor adalah nasi bakar yang dibumbui dengan bumbu pedas yang akan membuat bibirmu jontor kepedasan",
                "Sedang",
                "2 orang",
                "45 Menit",
                13,
                bahan2,
               3,
                step2
        );
        resepList.add(resep2);

        List<Bahan> bahan3 = new ArrayList<>();
        bahan3.add(new Bahan("1 ekor","Gurame utuh"));
        bahan3.add(new Bahan("5 sdm","Garam"));
        bahan3.add(new Bahan("5 sdm","Lada"));
        bahan3.add(new Bahan("1/2 pcs","Jeruk lemon"));
        bahan3.add(new Bahan("1 sdm","Mentega"));
        bahan3.add(new Bahan("3 siung","Bawang putih"));
        bahan3.add(new Bahan("1/4 pcs","Bawang bombay"));
        bahan3.add(new Bahan("1 pcs","Jahe"));
        bahan3.add(new Bahan("2 sdm","Tepung maizena"));
        bahan3.add(new Bahan("500 gram","Tepung Terigu"));
        bahan3.add(new Bahan("5 sdm","Tepung sagu tani"));
        bahan3.add(new Bahan("1 butir","Telur"));
        bahan3.add(new Bahan("Secukupnya","Kulit lemon"));

        List<Step> step3 = new ArrayList<>();
        step3.add(new Step("Cara Membuat","Beri tepung terigu dan sagu tani pada tulang ikan. Goreng tulang ikan. Potong dadu ikan gurame. Masukkan ikan ke dalam mangkuk, masukkan 1 butir telur, sagu tani, garam, lada kemudian aduk rata. Angkat tulang ikan yang sudah berwarna kecoklatan lalu tiriskan. Goreng ikan gurame sampai coklat keemasan lalu tiriskan. Siapkan tulang ikan gurame, tambahkan ikan gurame goreng lalu beri saus lemon diatasnya"));
        step3.add(new Step("Buat Saos Lemon","Cairkan 1 sdm mentega. Tumis bawang bombay 1/4 buah. siung bawang putih, jahe, kulit jeruk lemon. Tambahkan air, lada, garam, gula, air tepung maizena, perasan lemon"));

        Resep resep3 = new Resep(
                R.drawable.img_gurame_saos_lemon,
                "Gurame Saos Lemon",
                "Gurame dibalut diengan saos lemon.",
                "Suka banget makan Gurame? Ternyata selain memiliki kandungan protein yang tinggi, ikan ini memiliki kadar lemak yang cukup rendah loh. Jadi aman buat kamu yang obesitas atau takut kegemukan! Daging gurame yang dipadukan dengan saus lemon membuat kamu yang tidak suka makan ikan karena aroma amis ikan karena lemon akan menghilangkan bau amis ikan. Rasa Asam lemon juga akan membangkitkan selera makanmu! Yuk bikin!",
                "Sulit",
                "4 orang",
                "120 Menit",
                12,
                bahan3,
                2,
                step3
        );
        resepList.add(resep3);

        List<Bahan> bahan4 = new ArrayList<>();
        bahan4.add(new Bahan("1 kg","Iga sapi"));
        bahan4.add(new Bahan("5 pcs","Kentang goreng"));
        bahan4.add(new Bahan("4 pcs","Tomat"));
        bahan4.add(new Bahan("2 ruas","Daun bawang"));
        bahan4.add(new Bahan("1 sdt","Kaldu sapi"));
        bahan4.add(new Bahan("5 siung ","Bawang putih"));
        bahan4.add(new Bahan("5 siung ","Bawang merah"));
        bahan4.add(new Bahan("3 butir","Kemiri"));
        bahan4.add(new Bahan("4 pcs","Cabe merah besar"));
        bahan4.add(new Bahan("3 lembar","Daun salam"));
        bahan4.add(new Bahan("1 batang","Serai"));
        bahan4.add(new Bahan("2 ruas","Lengkuas"));
        bahan4.add(new Bahan("2 ruas","Jahe"));
        bahan4.add(new Bahan("3 lembar","Daun jeruk"));
        bahan4.add(new Bahan("2 buah","Gula jawa"));
        bahan4.add(new Bahan("2 sdm","Garam"));

        List<Step> step4 = new ArrayList<>();
        step4.add(new Step("Giling bumbu","Giling bumbu hingga halus kemudian tumis."));
        step4.add(new Step("Rebus Iga Sapi","Rebus air hingga mendidih kemudian masukkan iga sapi, rebus hingga empuk."));
        step4.add(new Step("Masukkan Bumbu","Masukkan bumbu yang sudah ditumis."));
        step4.add(new Step("Sajikan","Setelah sudah matang dan iga sudah lunak dapat di sajikan dengan kentang yang telah di goreng matang, tomat, bawang goreng dan daun bawang. Sajikan."));

        Resep resep4 = new Resep(
        R.drawable.img_gulai_balunga,
                "Gulai Balungan",
                "Gulai balungan adalah gulai khas purwakarta, tanpa santan.",
                "Gulai Balungan adalah makanan khas Purwakarta yang terbuat dari iga sapi yang dimasak dengan rempah-rempah yang sangat gurih. Memiliki cita rasa empuk dan sangat gurih. Bedanya, kali ini Gulai tersebut tidak menggunakan santan.",
                "Sulit",
                "5 orang",
                "50 menit",
                15,
                bahan4,
                4,
                step4
        );
        resepList.add(resep4);

        return resepList;
    }

}
