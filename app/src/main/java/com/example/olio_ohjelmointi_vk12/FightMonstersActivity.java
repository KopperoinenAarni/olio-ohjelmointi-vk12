package com.example.olio_ohjelmointi_vk12;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.olio_ohjelmointi_vk12.fragments.BossFightFragment;
import com.example.olio_ohjelmointi_vk12.fragments.ShowMonsterFragment;

public class FightMonstersActivity extends AppCompatActivity {

    private Button showMonsterButton;
    private Button bossFightButton;
    private Button returnFromFightButton;

    private int playerPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_monsters);

        showMonsterButton = findViewById(R.id.ShowMonsterFragmentButton);
        bossFightButton = findViewById(R.id.BossFightFragmentButton);
        returnFromFightButton = findViewById(R.id.ReturnFromFightButton);

        bossFightButton.setEnabled(playerPoints >= 100);

        showMonsterButton.setOnClickListener(listener);
        bossFightButton.setOnClickListener(listener);
    }

    private final View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = null;

            int id = view.getId();
            if (id == R.id.ShowMonsterFragmentButton) {
                fragment = new ShowMonsterFragment();

                bossFightButton.setEnabled(playerPoints >= 100);

            } else if (id == R.id.BossFightFragmentButton) {
                fragment = new BossFightFragment();
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.FightMonstersFrame, fragment)
                        .commit();
            }
        }
    };

    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
