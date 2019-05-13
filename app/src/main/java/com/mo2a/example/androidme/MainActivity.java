package com.mo2a.example.androidme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    public static final String HEAD_INDEX= "JH";
    public static final String BODY_INDEX= "KH";
    public static final String LEG_INDEX= "KJ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onImageSelected(int pos) {
        Toast.makeText(this, "position= " + pos, Toast.LENGTH_SHORT).show();
        int bodyPart = pos / 12;
        int listIndex = pos - 12 * bodyPart;

        switch (bodyPart) {
            case 0:
                headIndex = listIndex;
                Toast.makeText(this, "Picked head " + (listIndex+1), Toast.LENGTH_SHORT).show();

                break;
            case 1:
                bodyIndex = listIndex;
                Toast.makeText(this, "Picked body " + (listIndex+1), Toast.LENGTH_SHORT).show();

                break;
            case 2:
                legIndex = listIndex;
                Toast.makeText(this, "Picked legs " + (listIndex+1), Toast.LENGTH_SHORT).show();

                break;
            default:
                break;
        }

        Bundle b=new Bundle();
        b.putInt(HEAD_INDEX, headIndex);
        b.putInt(BODY_INDEX, bodyIndex);
        b.putInt(LEG_INDEX, legIndex);

        final Intent intent= new Intent(this,AndroidMeActivity.class);
        intent.putExtras(b);

        Button nextButton= findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
