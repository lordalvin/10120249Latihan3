package com.example.a10120249latihan3;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;
import static com.example.a10120249latihan3.DoneActivity.ID_EXTRA_MSG_EXIT;



//Nama : Stanislaus Katska Alvin Parulian Sitanggang
//Kelas : IF6
//NIM : 10120249
// Tgl Pengerjaan : 25 April 2023

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (getIntent().getBooleanExtra(ID_EXTRA_MSG_EXIT, false)){
            finish();
        }
    }

    @OnClick(R.id.btnWalkthroughStart)
    void mulai() {

        Intent intent = new Intent(this, LoginCodeActivity.class);
        startActivity(intent);
    }
}
