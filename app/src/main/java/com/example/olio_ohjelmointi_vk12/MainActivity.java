package com.example.olio_ohjelmointi_vk12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView PlayerScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            PlayerScoreText = findViewById(R.id.PlayerScoreText);
            int score = GameManager.getInstance().getPlayer().getScore();
            PlayerScoreText.setText("Pisteesi: " + String.valueOf(score));
            return insets;
        });
    }

    public void switchToFightMonsterActivity(View view) {
        Intent intent = new Intent(this, FightMonstersActivity.class);
        startActivity(intent);
    }
}
