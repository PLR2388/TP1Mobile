package ca.ulaval.ima.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

public class MonProfil extends AppCompatActivity {
    TextView name;
    TextView forname;
    TextView date;
    TextView IDUL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_profil);
        name=findViewById(R.id.nom);
        forname=findViewById(R.id.prenom);
        date=findViewById(R.id.Date);
        IDUL=findViewById(R.id.IDUL);

        Profil personal= (Profil) getIntent().getExtras().get("profile");

        name.setText("Nom : "+personal.name);
        forname.setText("Prénom : "+personal.forname);
        String date = new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date (personal.birthDate.getTime()*1000));
        this.date.setText("Date de Naissance : "+date);
        IDUL.setText("IDUL : "+personal.IDUL);

    }
}
