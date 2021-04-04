package com.example.recyclerviewwithonclicklistner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyAdapterForRecycleView extends RecyclerView.Adapter<MyAdapterForRecycleView.MyViewHolder> {
    private static ClickListner clickListner;
    Context context;
    String [] title;
    String [] description;
    int [] flag;

    public MyAdapterForRecycleView(Context context, String [] title, String [] description, int[] flag) {
        this.context = context;
        this.title = title;
        this.description = description;
        this.flag = flag;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.simple_resourse_file,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title_text.setText(title[position]);
        holder.description_text.setText(description[position]);
        holder.imageView.setImageResource(flag[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView title_text,description_text;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title_text = (TextView)itemView.findViewById(R.id.title_name_id);
            description_text = (TextView)itemView.findViewById(R.id.description_id);
            imageView = (ImageView)itemView.findViewById(R.id.country_image);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListner.onItemClick(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListner.onItemLongClick(getAdapterPosition(),v);
            return false;
        }
    }

    public interface ClickListner{
        void onItemClick(int position, View view);
        void onItemLongClick(int position, View view);
    }

    public void setOnItemClickListner(ClickListner clickListner){
        MyAdapterForRecycleView.clickListner = clickListner;
    }
}
