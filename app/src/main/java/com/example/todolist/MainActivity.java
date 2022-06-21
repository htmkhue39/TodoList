package com.example.todolist;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    EditText todoTask;
    Button bt_form, bt_add;
    ImageButton bt_menu;

    ArrayList<TodoTask> todoTasks;
    TodoTaskAdapter todoTaskAdapter;
    RecyclerView todoTaskRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoTask = findViewById(R.id.todoTask);
        bt_add = findViewById(R.id.bt_add);
        bt_form = findViewById(R.id.bt_form);
        bt_menu = findViewById(R.id.bt_menu);

        todoTasks = new ArrayList<>();
        todoTaskAdapter = new TodoTaskAdapter(this, todoTasks);

        todoTaskRecyclerView = findViewById(R.id.todoTaskRecyclerView);
        todoTaskRecyclerView.setAdapter(todoTaskAdapter);
        todoTaskRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        bt_add.setOnClickListener(v -> {
            String task = todoTask.getText().toString();

            todoTasks.add(0, new TodoTask(task, "Do something"));
            todoTaskAdapter.notifyItemInserted(0);
        });

        bt_form.setOnClickListener(v -> {
            //Form task view
            showFormDialog();
        });


        bt_menu.setOnClickListener(view -> buttonPopupMenu_onClick(view));

    }

    private void buttonPopupMenu_onClick(View view) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, bt_menu);
        popupMenu.getMenuInflater().inflate(R.menu.layout_popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                if (item.getTitle().equals("Log out")) {
                    logOut();
                }

                return false;
            }
        });
        popupMenu.show();
    }

    private void logOut() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }

    private void showFormDialog(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.form_task);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_form);

        Window window = dialog.getWindow();
        if(window == null) return;
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = getScreenWidth() - getScreenWidth()/15;
//        params.height = getScreenHeight() - getScreenHeight()/4;
        window.setAttributes(params);

        Button bt_cancel = dialog.findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(v -> dialog.dismiss());

        Button addTaskButton = dialog.findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(v -> {
            EditText taskNameEditText = dialog.findViewById(R.id.taskNameEditText);
            EditText memoEditText = dialog.findViewById(R.id.memoEditText);

            String taskName = taskNameEditText.getText().toString();
            String memo = memoEditText.getText().toString();

//            addNewTask()
            // TODO: 22/06/2022 : addNewTask()
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