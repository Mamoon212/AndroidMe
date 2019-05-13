package com.mo2a.example.androidme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import static com.mo2a.example.androidme.MainActivity.BODY_INDEX;
import static com.mo2a.example.androidme.MainActivity.HEAD_INDEX;
import static com.mo2a.example.androidme.MainActivity.LEG_INDEX;

public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        Intent intent= getIntent();
        int headIndex = intent.getIntExtra(HEAD_INDEX, 0);
        int bodyIndex = intent.getIntExtra(BODY_INDEX, 0);
        int legIndex = intent.getIntExtra(LEG_INDEX, 0);

        if (savedInstanceState == null) {

            BodyPartFragment headFragment = new BodyPartFragment();
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            headFragment.setListIndex(headIndex);
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            bodyFragment.setListIndex(bodyIndex);
            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            legFragment.setListIndex(legIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }
    }
}
