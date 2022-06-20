package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
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
    ImageButton bt_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        bt_add = findViewById(R.id.bt_add);
        bt_form = findViewById(R.id.bt_form);
        bt_menu = findViewById(R.id.bt_menu);

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


        bt_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPopupMenu_onClick(view);
            }
        });

    }

    private void buttonPopupMenu_onClick(View view) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, bt_menu);
        popupMenu.getMenuInflater().inflate(R.menu.layout_popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        popupMenu.show();
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

        Button bt_cancel = dialog.findViewById(R.id.bt_cancel);

        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}