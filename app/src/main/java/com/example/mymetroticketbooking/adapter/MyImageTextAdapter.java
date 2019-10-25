package com.example.mymetroticketbooking.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymetroticketbooking.R;
import com.example.mymetroticketbooking.adapter.otheractivities.JourneyPlannerActivity;

import java.util.ArrayList;
import java.util.List;

public class MyImageTextAdapter extends RecyclerView.Adapter
<MyImageTextAdapter.MyViewHolder>
{
    int [] images;
    List<String> nameList , detailsList;

    public MyImageTextAdapter(int[] images, List<String> nameList, List<String> detailsList) {
        this.images = images;
        this.nameList = nameList;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ui_for_home_frag, parent , false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.imageView.setImageResource(images[position]);
        holder.names.setText(nameList.get(position));
        holder.details.setText(detailsList.get(position));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position)
                {
                    case 0:
                        Toast.makeText(view.getContext(),
                                nameList.get(position), Toast.LENGTH_SHORT).show(); break;
                                
                    case 1: gotoJourneyPlannerActivity(view , holder);
                        break;
                    
                    case 2: Toast.makeText(view.getContext(),
                            nameList.get(position), Toast.LENGTH_SHORT).show();break;
                            
                    case 3:Toast.makeText(view.getContext(),
                            nameList.get(position), Toast.LENGTH_SHORT).show(); break;
                }
            }
        });
    }

    private void gotoJourneyPlannerActivity(View view, MyViewHolder holder) {

        Intent intent = new Intent(holder.view.getContext() , JourneyPlannerActivity.class);
        holder.view.getContext().startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private ImageView imageView;
        private TextView names ,details;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            imageView = view.findViewById(R.id.id_id_imageView);
            names = view.findViewById(R.id.tv1);
            details = itemView.findViewById(R.id.id_tv2);
        }

    }

//    public void updateList(List<String> newList)
//    {
//        nameList = new ArrayList<>();
//        nameList.addAll(newList);
//        notifyDataSetChanged();
//    }
}
