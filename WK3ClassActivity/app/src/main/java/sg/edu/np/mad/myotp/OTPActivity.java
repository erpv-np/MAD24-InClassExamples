package sg.edu.np.mad.myotp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class OTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CountDownTimer countDownTimer;
        Button generateOTP = findViewById(R.id.btnGenOTP);
        TextView tvOTP = findViewById(R.id.tvOTP);
        TextView tvTime = findViewById(R.id.tvTime);

        tvOTP.setText("-----");
        tvTime.setText("00:30");

        // Set the timer duration and interval
        long duration = 30000;  // 30 seconds in milliseconds
        long interval = 1000;   // 1 second in milliseconds

        countDownTimer = new CountDownTimer(duration, interval) {
            public void onTick(long millisUntilFinished) {
                // Update the TextView each second
                tvTime.setText(formatTime(millisUntilFinished));
            }

            public void onFinish() {
                // Display a message when the countdown is finished
                tvOTP.setText("-----");
                tvTime.setText("00:30");
                generateOTP.setEnabled(true);
                Toast.makeText(OTPActivity.this, "Time's up!", Toast.LENGTH_SHORT).show();
            }
        };

        generateOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
                generateOTP.setEnabled(false);
                int otp = new Random().nextInt(99999);
                tvOTP.setText(String.format("%05d", otp));
                Toast.makeText(OTPActivity.this, "Generating OTP.", Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Helper method to format time in minutes and seconds
    private String formatTime(long millis) {
        int seconds = (int) (millis / 1000) % 60 ;
        int minutes = (int) ((millis / (1000*60)) % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }
}