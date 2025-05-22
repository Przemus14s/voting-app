package com.example.grind.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grind.R;
import com.example.grind.VoteRoomSession;
import com.example.grind.model.Voting;

import java.util.ArrayList;
import java.util.List;

public class AddVotingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_voting_activity);

        EditText etQuestion = findViewById(R.id.etQuestion);
        EditText etOption1 = findViewById(R.id.etOption1);
        EditText etOption2 = findViewById(R.id.etOption2);
        EditText etOption3 = findViewById(R.id.etOption3);
        Button btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String questionText = etQuestion.getText().toString().trim();
                String option1 = etOption1.getText().toString().trim();
                String option2 = etOption2.getText().toString().trim();
                String option3 = etOption3.getText().toString().trim();

                if (questionText.isEmpty() || option1.isEmpty() || option2.isEmpty()) {
                    Toast.makeText(AddVotingActivity.this, "Wprowadź pytanie i przynajmniej 2 opcje!", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<String> options = new ArrayList<>();
                options.add(option1);
                options.add(option2);
                if (!option3.isEmpty()) {
                    options.add(option3);
                }

                Voting voting = new Voting(questionText, options);
                VoteRoomSession.getInstance().addVoting(voting);

                Toast.makeText(AddVotingActivity.this, "Pytanie dodane!", Toast.LENGTH_SHORT).show();

                // Czyszczenie pól
                etQuestion.setText("");
                etOption1.setText("");
                etOption2.setText("");
                etOption3.setText("");
            }
        });
    }
}
