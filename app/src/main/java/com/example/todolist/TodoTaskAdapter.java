package com.example.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoTaskAdapter extends RecyclerView.Adapter<TodoTaskAdapter.ViewHolder> {
    Context context;
    ArrayList<TodoTask> todoTasks;

    public TodoTaskAdapter(Context context, ArrayList<TodoTask> todoTasks) {
        this.context = context;
        this.todoTasks = todoTasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TodoTask todoTask = todoTasks.get(position);

        holder.taskName.setText(todoTask.getName());
        holder.taskMemo.setText(todoTask.getMemo());
    }

    @Override
    public int getItemCount() {
        return todoTasks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskName, taskMemo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            taskName = itemView.findViewById(R.id.taskName);
            taskMemo = itemView.findViewById(R.id.taskMemo);
        }
    }
}
