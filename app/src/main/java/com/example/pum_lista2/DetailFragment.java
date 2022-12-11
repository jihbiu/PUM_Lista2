package com.example.pum_lista2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import java.util.LinkedList;


public class DetailFragment extends Fragment {

    LinkedList<Crime> crimeList = new LinkedList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        crimeList = getArguments() != null ? (LinkedList<Crime>) getArguments().getSerializable("crimeList") : null;

        Bundle args = new Bundle();

        if(crimeList != null){
            args.putSerializable("crimeList", crimeList);
        }

        view.findViewById(R.id.fabB).setOnClickListener(v ->{
            //NavDirections action = DetailFragmentDirections.actionFragmentB2ToFragmentA2();

            Navigation.findNavController(view).navigate(R.id.action_fragmentB2_to_fragmentA2, args);
        });

        TextView TextViewStudentId = view.findViewById(R.id.studentIdDetail);
        TextView TextViewCrimeSolved = view.findViewById(R.id.crimeSolvedDetail);
        TextView TextViewCrimeDate = view.findViewById(R.id.crimeDateDetail);
        TextView TextViewCrimeDescription = view.findViewById(R.id.descriptionDetail);

        TextViewStudentId.setText(String.valueOf(
                getArguments() != null ? getArguments().getString("studentId") : 0
        ));
        TextViewCrimeSolved.setText(String.valueOf(
                getArguments() != null ? getArguments().getString("solved") : 0
        ));
        TextViewCrimeDate.setText(String.valueOf(
                getArguments() != null ? getArguments().getString("date") : 0
        ));
        TextViewCrimeDescription.setText(String.valueOf(
            getArguments() != null ? getArguments().getString("description") : 0
        ));


        return view;
    }
}

