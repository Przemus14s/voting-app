package com.example.grind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grind.R;
import com.example.grind.VoteRoomSession;
import com.example.grind.model.VotingQuestion;

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

        tvRoomName.setText("Pokój: " + session.getRoomTitle());
        tvRoomCode.setText("Kod: " + session.getRoomCode());

        StringBuilder builder = new StringBuilder();
        for (VotingQuestion question : session.getQuestions()) {
            builder.append("• ").append(question.getQuestion()).append("\n");
        }
        tvQuestions.setText(builder.toString());

        btnAddQuestion.setOnClickListener(view -> {
            Intent intent = new Intent(RoomManagementActivity.this, AddQuestionActivity.class);
            startActivity(intent);
        });
    }
}
