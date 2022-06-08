package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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
                showFormDialog();
            }


        });

    }

    private void showFormDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.form_task);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_form);

        Window window = dialog.getWindow();
        if(window == null) return;
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = getScreenWidth() - getScreenWidth()/15;
        params.height = getScreenHeight() - getScreenHeight()/4;
        window.setAttributes(params);

        Button bt_cancel = findViewById(R.id.bt_cancel);

        /*bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });*/

        dialog.show();
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}