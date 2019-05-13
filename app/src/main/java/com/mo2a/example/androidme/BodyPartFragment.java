package com.mo2a.example.androidme;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    public static final String LIST= "list";
    public static final String INDEX= "index";
    private static final String TAG = "BodyPartFragment";
    private List<Integer> imageIds;
    private int listIndex;

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }

    public void setListIndex(int listIndex) {
        this.listIndex = listIndex;
    }

    public BodyPartFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null){
            imageIds=  savedInstanceState.getIntegerArrayList(LIST);
            listIndex= savedInstanceState.getInt(INDEX);
        }

        View rootView= inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView= rootView.findViewById(R.id.body_part_image_view);
        if(imageIds != null){
            imageView.setImageResource(imageIds.get(listIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listIndex < imageIds.size()-1){
                        listIndex++;
                    }else{
                        listIndex =0;
                    }
                    imageView.setImageResource(imageIds.get(listIndex));
                }
            });
        }else{
            Log.d(TAG, "onCreateView: null imageList");
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(LIST, (ArrayList<Integer>)imageIds);
        outState.putInt(INDEX, listIndex);
        super.onSaveInstanceState(outState);
    }
}
