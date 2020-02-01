package ca.ulaval.ima.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button externButton;
    Button internButton;
    Button ulavalButton;
    Button monProfilButton;
    String url="https://m.youtube.com";
    Profil paullouis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        externButton=findViewById(R.id.sitewebexterne);
        internButton=findViewById(R.id.Sitewebintern);
        ulavalButton=findViewById(R.id.ulavalbutton);
        monProfilButton=findViewById(R.id.monprofil);


        try {
            paullouis=new Profil("Renard","Paul-Louis",new Date(new java.text.SimpleDateFormat("dd/MM/yyyy").parse("18/02/1997").getTime() / 1000),"PLREN1");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        externButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        internButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Webview.class);
                intent.putExtra("URL",url);
                startActivity(intent);
            }
        });

        ulavalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Ulaval.class);
                startActivity(intent);
            }
        });

        monProfilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MonProfil.class);
                intent.putExtra("profile",paullouis);
                startActivity(intent);
            }
        });

    }
}
