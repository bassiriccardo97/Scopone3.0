package com.example.scopone30.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.scopone30.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WaitingRoomActivity extends AppCompatActivity implements View.OnClickListener{

    private String firebaseURL;
    private DatabaseReference gameRef;
    private int plNum;
    private String username;
    private String gameName;

    private int pc = -1;

    private TextView player0View;
    private TextView player1View;
    private TextView player2View;
    private TextView player3View;
    private Button start;

    private final ValueEventListener pcListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            //System.out.println(snapshot.getValue());
            pc = snapshot.getValue(int.class);

            String player0;
            String player1;
            String player2;
            if(pc == 1){
                player0 = snapshot.child("0").getValue(String.class);
                player0View.setText(player0);
            }else if (pc == 2){
                player0 = snapshot.child("0").getValue(String.class);
                player1 = snapshot.child("1").getValue(String.class);
                player0View.setText(player0);
                player1View.setText(player1);
            }else if (pc == 3){
                player0 = snapshot.child("0").getValue(String.class);
                player1 = snapshot.child("1").getValue(String.class);
                player2 = snapshot.child("2").getValue(String.class);
                player0View.setText(player0);
                player1View.setText(player1);
                player2View.setText(player2);
            }else{
                player0 = snapshot.child("0").getValue(String.class);
                player1 = snapshot.child("1").getValue(String.class);
                player2 = snapshot.child("2").getValue(String.class);
                String player3 = snapshot.child("3").getValue(String.class);
                player0View.setText(player0);
                player1View.setText(player1);
                player2View.setText(player2);
                player3View.setText(player3);
                start.setClickable(true);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    private final ValueEventListener startGame = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            if (snapshot.getValue(boolean.class)){
                gameRef.child("pc").removeEventListener(pcListener);
                gameRef.child("start").removeEventListener(startGame);
                //pcRef.setValue(0);

                Intent gameActivity = new Intent(WaitingRoomActivity.this, GameActivity.class);
                gameActivity.putExtra("firebaseURL", firebaseURL);
                gameActivity.putExtra("username", username);
                gameActivity.putExtra("plNum", plNum);
                gameActivity.putExtra("gameName", gameName);

                startActivity(gameActivity);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParameters();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_wait_players);

        player0View = findViewById(R.id.player0);
        player1View = findViewById(R.id.player1);
        player2View = findViewById(R.id.player2);
        player3View = findViewById(R.id.player3);
        start = findViewById(R.id.start);
        start.setClickable(false);

        gameRef.child("pc").addValueEventListener(pcListener);
        //GameSetupActivity.gameRef.child(String.valueOf(GameSetupActivity.plNum)).child("username").setValue(GameSetupActivity.username);
        //GameSetupActivity.gameRef.child("pc").setValue(1);
    }

    private void getParameters(){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        firebaseURL = extras.getString("firebaseURL");
        gameName = extras.getString("gameName");
        plNum = extras.getInt("plNum");
        username = extras.getString("username");
        FirebaseDatabase database = FirebaseDatabase.getInstance(firebaseURL);
        DatabaseReference myRef = database.getReference();
        gameRef = myRef.child(gameName);
        if (pc != 4) {
            gameRef.child("start").addValueEventListener(startGame);
        }
    }

    @Override
    public void onClick(View v) {
        if (pc == 4) {
            //gameRef.child("start").setValue(true);
            gameRef.child("pc").removeEventListener(pcListener);
            //gameRef.child("start").removeEventListener(startGame);
            //pcRef.setValue(0);

            Intent gameActivity = new Intent(WaitingRoomActivity.this, GameActivity.class);
            gameActivity.putExtra("firebaseURL", firebaseURL);
            gameActivity.putExtra("username", username);
            gameActivity.putExtra("plNum", plNum);
            gameActivity.putExtra("gameName", gameName);

            startActivity(gameActivity);
        }
    }
}
