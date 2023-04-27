package com.example.a10120249latihan3;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Dialog;
import android.content.Context;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//Nama : Stanislaus Katska Alvin Parulian Sitanggang
//Kelas : IF6
//NIM : 10120249
// Tgl Pengerjaan : 25 April 2023


public class BiodataActivity extends AppCompatActivity{
    @BindView(R.id.edtBiodataName)
    EditText edtNama;
    @BindString(R.string.check_code_warning_empty_title_name)
    String emptyTitle;
    @BindString(R.string.check_code_warning_empty_desc_name)
    String emptyMessage;
    @BindString(R.string.warning_title)
    String warningTitle;

    final Context context = this;

    private String nameBiodata;

    public static final String ID_EXTRA_MSG = "com.example.a10120249latihan3.MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnBiodataNext)
    void selanjutnya() {

        nameBiodata = edtNama.getText().toString();

        if (isStringEmpty(nameBiodata)) {
            showWarningMessage();
        } else {
            Intent intent = new Intent(this, DoneActivity.class);

            intent.putExtra(ID_EXTRA_MSG, nameBiodata);
            startActivity(intent);
        }
    }

    public static boolean isStringEmpty(String str) {
        return "".equals(str);
    }

    public void showWarningMessage(){

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);


        TextView textTitle = (TextView) dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView textDesc = (TextView) dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton =(Button) dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitle);
        textDesc.setText(emptyMessage);


        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
