package com.example.saavanapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongsAdapter extends RecyclerView
                   .Adapter<SongsAdapter.SongsHolder>
     {
         private static String LOG_TAG = "SongsAdapter";
         private ArrayList<CardIcon> mDataset;
         private CustomClickListener clickListener;

         @NonNull
         @Override
         public SongsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
             View view = LayoutInflater.from(parent.getContext()).inflate(
                     R.layout.songs_item,parent,false);

             SongsHolder songHolder = new SongsHolder(view);
             return songHolder;
         }

         @Override
         public void onBindViewHolder(@NonNull SongsHolder holder, int position) {
            holder.albumName.setText(mDataset.get(position).getAlbumName());
            holder.songName.setText(mDataset.get(position).getSongName());
            holder.albumImg.setImageResource(mDataset.get(position).getImageId());
         }

         @Override
         public int getItemCount() {
             return mDataset.size();
         }

         public void addItem(CardIcon item,int index){
             mDataset.add(item);
             notifyItemInserted(index);
         }

         public void deleteItem(int index){
             mDataset.remove(index);
             notifyItemRemoved(index);
         }

               public static class SongsHolder extends RecyclerView.ViewHolder
                     implements View.OnClickListener{


             TextView albumName;
             TextView songName;
             ImageView albumImg;

             public SongsHolder(View v){
                 super(v);
                 albumName = v.findViewById(R.id.album_name);
                 songName = v.findViewById(R.id.song_name);
                 albumImg = v.findViewById(R.id.album_image);

                 v.setOnClickListener(this);
             }


             @Override
             public void onClick(View view) {
                 CustomClickListener.onItemClick(getAdapterPosition(),view);
             }
         }
         public void setOnItemClickListener(CustomClickListener customClickListener){
             clickListener = customClickListener;
         }

         public SongsAdapter(ArrayList<CardIcon> myDataset){
             mDataset = myDataset;
         }

         public interface CustomClickListener{
             public static void onItemClick(int position,View v){};
         }


     }
