package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static junit.runner.Version.id;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button mBtop, mBbottom;
    private TextView mTVstory;
    private int mStoryIndex = 0;
    private char mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mBtop = (Button) findViewById(R.id.buttonTop);
        mBbottom = (Button) findViewById(R.id.buttonBottom);
        mTVstory = (TextView) findViewById(R.id.storyTextView);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mBtop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex += 3;
                mode = 't';
                setStory(mStoryIndex);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex += 2;
                mode = 'b';
                setStory(mStoryIndex);
            }
        });
    } // end onCreate()

    public void setStory(int index) {
        if(mode == 't') {
            if(index == 3 || index == 5) {
                mTVstory.setText(R.string.T3_Story);
                mBtop.setText(R.string.T3_Ans1);
                mBbottom.setText(R.string.T3_Ans2);
            } else if(index == 6 || index == 8) {
                mTVstory.setText(R.string.T6_End);
                mBtop.setVisibility(View.GONE);
                mBbottom.setVisibility(View.GONE);
            } else {
                mTVstory.setText(R.string.T5_End);
                mBtop.setVisibility(View.GONE);
                mBbottom.setVisibility(View.GONE);
            }
        } else {
            if(index == 2) {
                mTVstory.setText(R.string.T2_Story);
                mBtop.setText(R.string.T2_Ans1);
                mBbottom.setText(R.string.T2_Ans2);
            } else if(index == 4) {
                mTVstory.setText(R.string.T4_End);
                mBtop.setVisibility(View.GONE);
                mBbottom.setVisibility(View.GONE);
            } else if(index == 5 || index == 7) {
                mTVstory.setText(R.string.T5_End);
                mBtop.setVisibility(View.GONE);
                mBbottom.setVisibility(View.GONE);
            }
        }
    }
} // end MainActivity
