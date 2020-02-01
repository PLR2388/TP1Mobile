package ca.ulaval.ima.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Webview extends AppCompatActivity {

    WebView webview;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        close=findViewById(R.id.closeWebview);
        webview=findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
        String url=getIntent().getExtras().getString("URL");


        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl(url);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
