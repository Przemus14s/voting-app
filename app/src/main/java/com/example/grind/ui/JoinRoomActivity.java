package com.example.grind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grind.R;
import com.example.grind.VoteRoomSession;

public class JoinRoomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_room_activity);

        // Pobierz instancję sesji
        VoteRoomSession session = VoteRoomSession.getInstance();

        EditText etRoomCode = findViewById(R.id.etRoomCode);
        EditText etUsername = findViewById(R.id.etUsername);
        Button btnJoin = findViewById(R.id.btnJoin);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomCode = etRoomCode.getText().toString().trim();
                String username = etUsername.getText().toString().trim();

                if (!roomCode.isEmpty() && !username.isEmpty()) {
                    if (roomCode.equals(String.valueOf(session.getRoomCode()))) {

                        session.addUser(username);


                        Intent intent = new Intent(JoinRoomActivity.this, RoomSessionActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
