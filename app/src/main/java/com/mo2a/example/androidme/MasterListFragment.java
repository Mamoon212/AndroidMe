package com.mo2a.example.androidme;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterListFragment extends Fragment {
    OnImageClickListener callback;

    public interface OnImageClickListener{
        void onImageSelected(int pos);
    }
    public MasterListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            callback=(OnImageClickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException("must implement OnImage");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        MasterListAdapter masterListAdapter= new MasterListAdapter(this.getActivity(), AndroidImageAssets.getAll());

        View rootView= inflater.inflate(R.layout.fragment_master_list, container, false);
        GridView gridView= rootView.findViewById(R.id.master_grid);
        gridView.setAdapter(masterListAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callback.onImageSelected(position);
            }
        });
        return rootView;
    }

}
