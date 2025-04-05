package com.example.olio_ohjelmointi_vk12.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.olio_ohjelmointi_vk12.GameManager;
import com.example.olio_ohjelmointi_vk12.Monster;
import com.example.olio_ohjelmointi_vk12.Player;
import com.example.olio_ohjelmointi_vk12.R;

public class ShowMonsterFragment extends Fragment {

    private Monster currentMonster;
    private TextView monsterNameText;
    private TextView monsterLifeText;
    private ImageView monsterImage;
    private ImageButton attackMonsterButton;

    public ShowMonsterFragment() {
    }

    public static ShowMonsterFragment newInstance(String param1, String param2) {
        ShowMonsterFragment fragment = new ShowMonsterFragment();
        Bundle args = new Bundle();
        args.putString("ARG_PARAM1", param1);
        args.putString("ARG_PARAM2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String param1 = getArguments().getString("ARG_PARAM1");
            String param2 = getArguments().getString("ARG_PARAM2");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show_monster, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        monsterNameText = view.findViewById(R.id.MonsterNameText);
        monsterLifeText = view.findViewById(R.id.MonsterLifeText);
        monsterImage    = view.findViewById(R.id.MonsterImage);
        attackMonsterButton = view.findViewById(R.id.AttackMonsterButton);

        currentMonster = GameManager.getInstance().generateMonster();

        updateMonster();

        attackMonsterButton.setOnClickListener(v -> {
            Player player = GameManager.getInstance().getPlayer();
            player.attack(currentMonster);
            updateMonster();

        });
    }

    private void updateMonster() {
        monsterNameText.setText(currentMonster.getName());
        if (currentMonster.getLife() == 0) {
            currentMonster = GameManager.getInstance().generateMonster();
            monsterNameText.setText(currentMonster.getName());

        } else {
            monsterLifeText.setText(currentMonster.getLife() + "/" + currentMonster.getMaxLife()
            );
        }
    }
}