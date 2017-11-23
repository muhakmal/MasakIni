package com.baskom.masakini.drawercontent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baskom.masakini.R;

/**
 * Created by akmalmuhamad on 20/11/17.
 */

public class ResepTabActivity extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resep, container,false);
    }

    public class ResepCard{
        private String judulResep;
        private String subJudulResep;
        private String tingkatKesulitan;
        private String untukBerapaOrang;
        private int waktuMemasak;

        public ResepCard(){

        }

        public ResepCard(String judulResep, String subJudulResep, String tingkatKesulitan, String untukBerapaOrang, int waktuMemasak){
            this.judulResep = judulResep;
            this.subJudulResep = subJudulResep;
            this.tingkatKesulitan = tingkatKesulitan;
            this.untukBerapaOrang = untukBerapaOrang;
            this.waktuMemasak = waktuMemasak;
        }

        //setter getter judul resep
        public String getJudulResep(){return judulResep;}
        public void setJudulResep(String judulResep){this.judulResep = judulResep;}

        //steter getter subjudulresep
        public String getSubJudulResep(){return subJudulResep;}
        public void setSubJudulResep(String subJudulResep){this.subJudulResep=subJudulResep;}

        //setter getter tinggkat kesulitan
        public String getTingkatKesulitan(){return tingkatKesulitan;}
        public void setTingkatKesulitan(String tingkatKesulitan){this.tingkatKesulitan = tingkatKesulitan;}

        //setter getter untuk berapa orang
        public String getUntukBerapaOrang(){return untukBerapaOrang;}
        public void setUntukBerapaOrang(String untukBerapaOrang){this.untukBerapaOrang = untukBerapaOrang;}

        //setter getter waktu memasak
        public int getWaktuMemasak(){return waktuMemasak;}
        public void setWaktuMemasak(int waktuMemasak){this.waktuMemasak = waktuMemasak;}




    }



}
