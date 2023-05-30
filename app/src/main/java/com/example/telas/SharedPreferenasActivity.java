package com.example.telas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferenasActivity extends AppCompatActivity {
    private TextView lblStatus;
    private EditText edit_nome, edit_email;
    DbHelper dpHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferenas);

       lblStatus = (TextView) findViewById(R.id.textViewStatus);
        edit_nome = (EditText) findViewById(R.id.edit_nome);
        edit_email = (EditText) findViewById(R.id.edit_email);

        findViewById(R.id.btnSalvar).setOnClickListener(clickListernerDb);


    }

    private final View.onClickListener clickListernerDb = new View.OnClickListener();
    {
        @Override
        public void Onclick(View v){
            String Nome = edit_nome.getText().toString();
            String Email = edit_email.getText().toString();


        salvarArquivoDb(Nome, Email);
        lblStatus.setText("Status:DAdo salvos - DB");
    }
    };

    private void salvarArquivoDb(String Nome, String Email){
        try {
            dpHelper = new DpHelper(this);
            db = dbHelpér.getReadadableDatabase();

            ContentValues values = new ContentValues();
            values.put(dbHelper.C_NOME, Nome);
            values.put(dbHelper.C_EMAIL, Email);

            try {
                db.insertOrThrow(dpHelper.TABLE, null values);
            } finally {
                db.close();
            }
        }catch (Exception e ){
            Log.e("Erro DB", e.getMessage());
        }

    }



}