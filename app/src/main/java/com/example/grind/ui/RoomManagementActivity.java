package com.example.grind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grind.R;
import com.example.grind.VoteRoomSession;
import com.example.grind.model.Voting;

public class RoomManagementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_managment_activity);

        VoteRoomSession session = VoteRoomSession.getInstance();

        TextView tvRoomName = findViewById(R.id.tvRoomName);
        TextView tvRoomCode = findViewById(R.id.tvRoomCode);
        TextView tvQuestions = findViewById(R.id.tvQuestions);
        Button btnAddQuestion = findViewById(R.id.btnAddQuestion);
        Button btnStartVoting = findViewById(R.id.btnStartVoting);

        tvRoomName.setText("Pokój: " + session.getRoomTitle());
        tvRoomCode.setText("Kod: " + session.getRoomCode());

        StringBuilder builder = new StringBuilder();
        for (Voting voting : session.getVotings()) {
            builder.append("• ").append(voting.getQuestion()).append("\n");
        }
        tvQuestions.setText(builder.toString());

        btnAddQuestion.setOnClickListener(view -> {
            Intent intent = new Intent(RoomManagementActivity.this, AddVotingActivity.class);
            startActivity(intent);
        });

        btnStartVoting.setOnClickListener(view -> {
            if (!session.getVotings().isEmpty()) {
                Intent intent = new Intent(RoomManagementActivity.this, ModeratorVotingActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Musisz dodać co najmniej 1 głosowanie", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
