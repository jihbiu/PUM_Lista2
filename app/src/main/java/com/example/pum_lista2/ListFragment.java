package com.example.pum_lista2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;
import java.util.LinkedList;
import java.util.Random;


public class ListFragment extends Fragment {

    private LinkedList<Crime> crimeList = new LinkedList<>();
    Random random = new Random();
    public static ListFragment listFrag;

    static boolean wasCreated = false;

    //public static ListFragment newInstance() {
    //    if(listFrag == null) {
    //        listFrag = new ListFragment();
    //    }
    //    Bundle args = new Bundle();
//
    //    listFrag.setArguments(args);
    //    return listFrag;
    //}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceStats){
        View view = inflater.inflate(R.layout.fragment_a, container, false);


        if(!wasCreated) {
            initData();
            wasCreated = true;
        }
        else{
            crimeList = getArguments() != null ? (LinkedList<Crime>) getArguments().getSerializable("crimeList") : null;
        }


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        CrimeListAdapter crimeListAdapter = new CrimeListAdapter(getContext(), crimeList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(crimeListAdapter);

        return view;
    }



    private void initData() {
        crimeList.clear();
        String[] crimes;
        crimes = getResources().getStringArray(R.array.crimes_description);

        boolean isSolved;
        int yearOfCrime;
        int monthOfCrime;
        int dayOfCrime;
        int studentId;
        Date dateOfCrime;
        for(int i = 0; i < crimes.length; i++){
            //System.out.println(crimes[i]);

            isSolved = random.nextInt(10) % 2 == 0;

            yearOfCrime = random.nextInt(2022 - 2017) + 2017;
            monthOfCrime = random.nextInt(12);
            dayOfCrime = random.nextInt(31);
            studentId = random.nextInt(299999 - 250000) + 250000;
            dateOfCrime = new Date(yearOfCrime, monthOfCrime, dayOfCrime);
            //System.out.println(dateOfCrime);
            //System.out.println(yearOfCrime);
            crimeList.add(new Crime(
                    i,
                    isSolved,
                    dateOfCrime,
                    crimes[i],
                    studentId
            ));
        }
    }
}
