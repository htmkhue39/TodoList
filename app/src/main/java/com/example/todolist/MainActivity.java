package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button bt_form, bt_add;
    ImageButton bt_delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        bt_add = findViewById(R.id.bt_add);
        bt_form = findViewById(R.id.bt_form);
        bt_delete = findViewById(R.id.bt_delete);

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get string from edit text

            }
        });

        bt_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Form task view

            }
        });
    }
}