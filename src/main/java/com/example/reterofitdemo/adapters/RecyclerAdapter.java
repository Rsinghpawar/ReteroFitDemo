package com.example.reterofitdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reterofitdemo.R;
import com.example.reterofitdemo.models.RecyclerModel;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<RecyclerModel> data;

    public RecyclerAdapter(ArrayList<RecyclerModel> data){
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View customRowView = inflater.inflate(R.layout.row_for_recycler_view, parent, false );

        RecyclerViewHolder holder = new RecyclerViewHolder(customRowView);

        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            holder.id.setText( "Count : "+data.get(position).getId() );
            holder.userId.setText("Id : "+ data.get(position).getUserId() );
            holder.title.setText( "Title : "+data.get(position).getTitle() );
            holder.body.setText( "Body ;\n"+data.get(position).getBody() );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView id, userId, title, body;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            userId = itemView.findViewById(R.id.userId);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }
    }
}
