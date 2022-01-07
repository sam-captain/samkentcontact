package com.samkent.samkentapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samkent.samkentapp.Model.Contact;
import com.samkent.samkentapp.R;
import com.samkent.samkentapp.utilities.ObjectBox;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.annotation.Entity;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    Context context;
    List<Contact> contactList;
//    Box<Contact> contactBox = ObjectBox.get().boxFor(Contact.class);



public ContactAdapter(Context context, List<Contact> contactList){
    this.context = context;
    this.contactList = contactList;
}
    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);

        return new ContactAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {
    Contact contact = contactList.get(position);
    holder.name.setText(contact.getName());
    Glide.with(this.context).load(contactList.get(position).getImageUrl()).into(holder.icon);


    }

    @Override
    public int getItemCount() {
        return contactList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    ImageView icon;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            icon = itemView.findViewById(R.id.img_icon);
        }

    }
}
