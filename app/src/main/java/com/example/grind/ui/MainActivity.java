package com.example.grind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grind.R;

public class MainActivity extends AppCompatActivity {

    private Button btnModerator, btnUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnModerator = findViewById(R.id.btnModerator);
        btnUser = findViewById(R.id.btnUser);

        btnModerator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bez logowania
//                Intent intent = new Intent(MainActivity.this, ModeratorLoginActivity.class);
                Intent intent = new Intent(MainActivity.this, CreateRoomActivity.class);
                startActivity(intent);
            }
        });

        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JoinRoomActivity.class);
                startActivity(intent);
            }
        });
    }
}
