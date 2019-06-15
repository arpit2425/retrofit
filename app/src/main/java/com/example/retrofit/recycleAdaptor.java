package com.example.retrofit;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class recycleAdaptor extends RecyclerView.Adapter<recycleAdaptor.viewHolder> {
    private List<contact> contacts;

    public recycleAdaptor(List<contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_item,viewGroup,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        viewHolder.name.setText(contacts.get(i).getName());
        viewHolder.email.setText(contacts.get(i).getEmail());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        TextView name,email;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            email=itemView.findViewById(R.id.email);
        }
    }
}
