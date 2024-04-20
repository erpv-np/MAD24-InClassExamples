package sg.edu.np.mad.wk2_classactivity;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//import these for class activity
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MaiActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Java Class objects
        Title title   = new Title("John John");
        Banner banner = new Banner("New Application");

        // Find Text Views by ID
        TextView tvTitle  = findViewById(R.id.tvView1);
        TextView tvBanner = findViewById(R.id.tvBanner);

        // Find the buttons by ID
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        tvTitle.setText(title.name);
        tvBanner.setText(banner.banner_name);

        // Set the click listeners for each button
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i(TAG, "Button 1 pressed");

                title.update("Jane Doe");
                tvTitle.setText(title.name);
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i(TAG,"Button 2 pressed");

                title.update("John Doe");
                tvTitle.setText(title.name);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i(TAG, "Button 3 pressed");

                banner.update("New APP 1");
                tvBanner.setText(banner.banner_name);

            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i(TAG, "Button 4 pressed");

                banner.update("New APP 2");
                tvBanner.setText(banner.banner_name);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Application visible - onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Application resumed - onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Application paused - onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Application stopped - onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Application closed - onDestroy()");
    }

}