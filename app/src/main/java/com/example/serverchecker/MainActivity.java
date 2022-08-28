package com.example.serverchecker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText mEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        mEdit = (EditText)findViewById(R.id.editTextNumber);
    }
    public void button1(View view) {
        String port = "";
        if(!mEdit.getText().toString().equals(""))
        {
            port = ":" + mEdit.getText().toString();
        }
        if(isAvailable("http://notindiegames.tk" + port, 5000)) {
            Toast.makeText(this, "notindiegames.tk" + port + " is up.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "notindiegames.tk" + port + " could not be reached.", Toast.LENGTH_LONG).show();
        }
    }
    public void button2(View view) {
        String port = "";
        if(!mEdit.getText().toString().equals(""))
        {
            port = ":" + mEdit.getText().toString();
        }
        if(isAvailable("http://notindie.ddns.net" + port, 5000)) {
            Toast.makeText(this, "notindie.ddns.net" + port + " is up.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "notindie.ddns.net" + port + " could not be reached.", Toast.LENGTH_LONG).show();
        }
    }
    boolean isAvailable(String url_, int timeOut){
        try {
            URL url = new URL(url_);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(timeOut);
            urlConnection.connect();
            urlConnection.disconnect();
            return true;
        } catch (IOException e) {
            Log.e(null, "Exception", e);
        }
        return false;
    }
}