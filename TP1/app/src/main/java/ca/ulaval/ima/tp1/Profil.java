package ca.ulaval.ima.tp1;

import android.icu.util.LocaleData;
import android.media.tv.TvContract;
import android.os.Parcel;
import android.os.Parcelable;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.spec.DESedeKeySpec;


public class Profil implements Parcelable {
    String name;
    String forname;
    Date birthDate;
    String IDUL;

    public Profil(String name, String forname, Date birthDate, String IDUL){
        this.name=name;
        this.forname=forname;
        this.birthDate=birthDate;
        this.IDUL=IDUL;
    }

    public Profil(Parcel source){
        if(source.dataSize()>0){
            this.name=source.readString();
            this.forname=source.readString();
            try {
                this.birthDate=new Date(new java.text.SimpleDateFormat("dd/MM/yyyy").parse(source.readString()).getTime() / 1000);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.IDUL=source.readString();
        }
    }


    public static final Creator<Profil> CREATOR = new Creator<Profil>() {
        @Override
        public Profil createFromParcel(Parcel in) {
            return new Profil(in);
        }

        @Override
        public Profil[] newArray(int size) {
            return new Profil[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.forname);
        dest.writeString(new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date (this.birthDate.getTime()*1000)));
        dest.writeString(this.IDUL);
    }
}
