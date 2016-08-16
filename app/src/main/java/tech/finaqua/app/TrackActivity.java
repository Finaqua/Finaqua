package tech.finaqua.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
    }

    public void startTracker(View v){
        startActivity(new Intent(getApplicationContext(), MapTrackingActivity.class));
    }
}
