package com.example.todolist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.data.ToDo;

import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ToDoViewHolder> {

    private List<ToDo> ToDoList = new ArrayList<>();
    private OnChecked mListener;

    public void setList(List<ToDo> ToDoList) {
        this.ToDoList = ToDoList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.li_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return ToDoList.size();
    }

    public void setOnCheckedListener(OnChecked mListener) {
        this.mListener = mListener;
    }

    public interface OnChecked {
        void onChecked();
    }

    class ToDoViewHolder extends RecyclerView.ViewHolder {

        // Declare your views
        private CheckBox li_todo_title;

        public ToDoViewHolder(@NonNull View itemView) {
            super(itemView);
            // inflate the view
            li_todo_title = itemView.findViewById(R.id.li_todo_title);

            li_todo_title.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                }
            });

        }

        private void bind(int position) {
            // Bind data
            li_todo_title.setChecked(ToDoList.get(position).isChecked());

        }
    }
}
