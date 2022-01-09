package com.eventqueue.reactPackage;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eventqueue.R;
import com.eventqueue.reactPackage.Models.Todo;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    List<Todo> myList = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setMyList(List<Todo> list) {
        Timber.d("Setting list");
        myList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upload_progress_view,parent,false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(myList.get(position).getTitle(),position);
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView1);
            imageView = itemView.findViewById(R.id.imageView);
            button = itemView.findViewById(R.id.button1);
        }

        public void bind(String item, int position) {
            Timber.d("binding data !! %s", position);
            textView.setText(item);
            button.setText("item");
            button.setOnClickListener(v -> {
                Toast.makeText(itemView.getContext(), "Clicked on item "+position,Toast.LENGTH_SHORT).show();
            });
            Glide.with(imageView).load("https://github.com/bumptech/glide/raw/master/static/glide_logo.png").into(imageView);
        }
    }
}
