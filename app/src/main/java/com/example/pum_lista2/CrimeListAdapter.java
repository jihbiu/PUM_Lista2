package com.example.pum_lista2;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;


public class CrimeListAdapter extends RecyclerView.Adapter<CrimeListAdapter.CrimeListViewHolder> {

    Context context;
    private LinkedList<Crime> crimeList = new LinkedList<>();
    private final LayoutInflater inflater;
    private View itemView;

    public CrimeListAdapter(Context context, LinkedList<Crime> crimeList){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.crimeList = crimeList;
    }

    @NonNull
    @Override
    public CrimeListAdapter.CrimeListViewHolder onCreateViewHolder(@NonNull ViewGroup container, int viewType) {
        itemView = inflater.inflate(R.layout.crime_list_item, container, false);
        return new CrimeListViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CrimeListAdapter.CrimeListViewHolder holder, int position) {
        Crime crime = crimeList.get(position);
        holder.crimeId.setText("Crime #" + crime.getIdString());
        holder.crimeDate.setText(crime.getDate().toString());
        if(crime.isSolved() == true){
            holder.crimeCommitedImg.setImageResource(R.drawable.ic_baseline_stars_24);
        }
        holder.itemView.setOnClickListener(v->{
            Bundle args = new Bundle();
            args.putString("id", Integer.toString(crime.getId()));
            args.putString("date", crime.getDateString());
            args.putString("solved", crime.isSolvedString());
            args.putString("description", crime.getDescription());
            args.putString("studentId", Integer.toString(crime.getStudentId()));
            args.putSerializable("crimeList", crimeList);
            //args.putParcelableArrayList(crimeList);

            Navigation.findNavController(itemView).navigate(
                    R.id.action_fragmentA2_to_fragmentB2,
                    args
            );
        });

    }

    @Override
    public int getItemCount() {
        return crimeList.size();
    }

    protected static class CrimeListViewHolder extends RecyclerView.ViewHolder {

        private final TextView crimeId;
        private final TextView crimeDate;
        private final ImageView crimeCommitedImg;
        final CrimeListAdapter adapter;

        public CrimeListViewHolder(@NonNull View itemView, CrimeListAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            crimeId = itemView.findViewById(R.id.crimeId);
            crimeDate = itemView.findViewById(R.id.crimeDate);
            crimeCommitedImg = itemView.findViewById(R.id.crimeCommited);
        }
    }


}
