package com.example.android.audio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.android.audio.utilities.ActivityHelper;
import com.example.android.audio.utilities.AudioHelper;

public class MainActivity extends AppCompatActivity {

    private ScrollView mScroll;
    private TextView mLog;

    private AudioHelper mAudioHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Initialize the logging components
        mScroll = (ScrollView) findViewById(R.id.scrollLog);
        mLog = (TextView) findViewById(R.id.tvLog);
        mLog.setText("");

    }

    public void onRunBtnClick(View v) {
        displayMessage("Running code!");
        if (mAudioHelper != null) {
            mAudioHelper.stop();
        }
        mAudioHelper = new AudioHelper(this, "musicFile.mp3");
        mAudioHelper.prepareAndPlay();
        displayMessage("Playing!");
    }

    public void onClearBtnClick(View v) {
        mLog.setText("");
        mScroll.scrollTo(0, mScroll.getBottom());
    }

    public void displayMessage(String message) {
        ActivityHelper.log(this, mLog, message, true);
        mScroll.scrollTo(0, mScroll.getBottom());
    }

    public void onStopBtnClick(View view) {
        if (mAudioHelper != null) {
            mAudioHelper.stop();
            displayMessage("Stopping!");
        }
    }
}