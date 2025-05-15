package com.example.grind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grind.R;
import com.example.grind.VoteRoomSession;

import java.util.Random;

public class CreateRoomActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_room_activity);

        VoteRoomSession session = VoteRoomSession.getInstance();
        int roomCode = generateRoomCode();
        EditText roomNameInput = findViewById(R.id.etRoomName);
        Button createRoomButton = findViewById(R.id.btnCreate);

        createRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String roomName = roomNameInput.getText().toString();

                if (!roomName.isEmpty()) {
                    session.setRoom(roomCode, roomName);

                    Intent intent = new Intent(CreateRoomActivity.this, RoomManagementActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(CreateRoomActivity.this, "Musisz podać nazwę!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int generateRoomCode() {
        Random random = new Random();
        // Zakres od 100000 do 999999
        return 100000 + random.nextInt(900000);
    }
}
