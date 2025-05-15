package com.example.grind.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grind.R;
import com.example.grind.VoteRoomSession;

public class RoomManagementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_managment_activity);

        VoteRoomSession session = VoteRoomSession.getInstance();

        TextView tvRoomName = findViewById(R.id.tvRoomName);
        TextView tvRoomCode = findViewById(R.id.tvRoomCode);

        tvRoomName.setText("Pokój: " + session.getRoomTitle());
        tvRoomCode.setText("Kod: " + session.getRoomCode());
    }
}
