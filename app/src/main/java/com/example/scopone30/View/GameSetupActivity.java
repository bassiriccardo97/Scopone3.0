package com.example.scopone30.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scopone30.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GameSetupActivity extends AppCompatActivity implements View.OnClickListener{

    private final String firebaseURL = "https://scopone3-default-rtdb.europe-west1.firebasedatabase.app/";
    private final FirebaseDatabase database = FirebaseDatabase.getInstance(firebaseURL);
    private final DatabaseReference myRef = database.getReference();
    private DatabaseReference gameRef;
    private int pc = 0;
    private int plNum = -1;
    private String username;
    private String gameName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game_setup);
    }

    private void createGame(){
        EditText nickname = findViewById(R.id.nickname);
        EditText room = findViewById(R.id.gameName);
        String roomStr = room.getText().toString();
        EditText password = findViewById(R.id.gamePassword);
        String passwordStr = password.getText().toString();

        gameName = roomStr + "-" + passwordStr;

        //check if game already exists !!

        pc += 1;
        plNum = 0;

        //System.out.println("PROVO A SCRIVERE");
        //database.getReference(gameName).setValue(0);

        //init and set db
        username = nickname.getText().toString();
        myRef.child(gameName).child(String.valueOf(plNum)).setValue(username);
        //gameRef.child(String.valueOf(plNum)).setValue(nickname.getText().toString());
        gameRef = myRef.child(gameName);
        gameRef.child("pc").setValue(pc);
        gameRef.child("start").setValue(false);
        gameRef.child("ended").setValue(false);
        gameRef.child("pl0").setValue(0);
        gameRef.child("pl1").setValue(0);
        gameRef.child("pl2").setValue(0);
        gameRef.child("pl3").setValue(0);
        gameRef.child("board").setValue(0);
        gameRef.child("turn").setValue(-1);
        gameRef.child("taken0").setValue(0);
        gameRef.child("taken1").setValue(0);
        gameRef.child("playedCard").child("pl").setValue(-1);
        gameRef.child("playedCard").child("card").setValue("empty");

        Intent waitingRoom = new Intent(GameSetupActivity.this, WaitingRoomActivity.class);
        waitingRoom.putExtra("firebaseURL", firebaseURL);
        waitingRoom.putExtra("username", username);
        waitingRoom.putExtra("plNum", plNum);
        waitingRoom.putExtra("gameName", gameName);

        startActivity(waitingRoom);
    }

    private void joinGame(){
        EditText nickname = findViewById(R.id.nickname);
        String nicknameStr = nickname.getText().toString();
        EditText room = findViewById(R.id.gameName);
        String roomStr = room.getText().toString();
        EditText password = findViewById(R.id.gamePassword);
        String passwordStr = password.getText().toString();

        gameName = roomStr + "-" + passwordStr;

        //retrieve db
        username = nicknameStr;
        gameRef = myRef.child(gameName);
        gameRef.child("pc").get().addOnCompleteListener(task -> {
            if(!task.isSuccessful()){
                Log.e("firebase", "Error getting data", task.getException());
            }else{
                pc = task.getResult().getValue(int.class);

                if (pc == 1) {
                    pc += 1;
                    gameRef.child("pc").setValue(pc);
                    plNum = 1;
                    gameRef.child(String.valueOf(plNum)).setValue(nicknameStr);
                } else if (pc == 2) {
                    pc += 1;
                    gameRef.child("pc").setValue(pc);
                    plNum = 2;
                    gameRef.child(String.valueOf(plNum)).setValue(nicknameStr);
                } else if (pc == 3){
                    pc += 1;
                    gameRef.child("pc").setValue(pc);
                    plNum = 3;
                    gameRef.child(String.valueOf(plNum)).setValue(nicknameStr);
                } else {
                    Toast.makeText(GameSetupActivity.this, "Game is full.", Toast.LENGTH_SHORT).show();
                }
                if (pc <= 4){
                    Intent waitingRoom = new Intent(GameSetupActivity.this, WaitingRoomActivity.class);
                    waitingRoom.putExtra("firebaseURL", firebaseURL);
                    waitingRoom.putExtra("username", username);
                    waitingRoom.putExtra("plNum", plNum);
                    waitingRoom.putExtra("gameName", gameName);

                    startActivity(waitingRoom);
                }
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.joinGameButton:
                joinGame();
                break;
            case R.id.createGameButton:
                createGame();
                break;
        }
    }
}
