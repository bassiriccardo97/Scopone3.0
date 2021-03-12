package com.example.scopone30.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scopone30.Model.Card;
import com.example.scopone30.Model.Player;
import com.example.scopone30.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference gameRef;
    private int plNum;

    private Player thisPlayer;
    private List<Card> cardsBoard = new ArrayList<>();
    private List<Card> takenDeck = new ArrayList<>();
    private boolean turn = false;

    private DatabaseReference thisPlayerHandRef;
    private DatabaseReference cardsOnBoardRef;
    private DatabaseReference takenRef;
    private DatabaseReference endedRef;
    private DatabaseReference turnRef;
    private DatabaseReference playedCardRef;

    private List<List<Integer>> options = new ArrayList<>();
    private List<Integer> choices = new ArrayList<>();
    private int playedCard;

    private String player0Name;
    private String player1Name;
    private String player2Name;
    private String player3Name;
    private List<ImageButton> deck = new ArrayList<>();
    private List<ImageButton> cardBoardButtons = new ArrayList<>();
    private List<ImageView> cardBoardImages = new ArrayList<>();
    private TextView north_name;
    private TextView west_name;
    private TextView east_name;
    private ImageView north;
    private ImageView east;
    private ImageView west;
    private TextView yourTurn;
    private ProgressBar progressBar;
    private ValueEventListener thisPlayerHandListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            List<Card> hand = new ArrayList<>();
            for (DataSnapshot handCard : snapshot.getChildren()){
                hand.add(handCard.getValue(Card.class));
            }
            thisPlayer.hand.clear();
            thisPlayer.hand = hand;
            updateHandButtons();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    private ValueEventListener boardListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            List<Card> tmpCardsBoard = new ArrayList<>();
            for (DataSnapshot cardBoard : snapshot.getChildren()){
                tmpCardsBoard.add(cardBoard.getValue(Card.class));
            }
            cardsBoard.clear();
            cardsBoard = tmpCardsBoard;

            updateBoardImages();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    private ValueEventListener takenListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            List<Card> taken = new ArrayList<>();
            for (DataSnapshot takenCard : snapshot.getChildren()){
                taken.add(takenCard.getValue(Card.class));
            }
            takenDeck.clear();
            takenDeck = taken;
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    private ValueEventListener playedCardListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            int player = snapshot.child("pl").getValue(int.class);
            String card = snapshot.child("card").getValue(String.class);

            if (player == plNum || player == -1 || card.equals("empty")) {
                east.setBackgroundResource(R.drawable.back);
                north.setBackgroundResource(R.drawable.back);
                west.setBackgroundResource(R.drawable.back);
            } else {
                if ((player == plNum + 1 && plNum != 4) || (plNum == 4 && player == 0)) {
                    setPlayedCardRes(east, card);
                    north.setBackgroundResource(R.drawable.back);
                    west.setBackgroundResource(R.drawable.back);
                } else if ((player == plNum + 2 && plNum != 4) || (plNum == 4 && player == 1)) {
                    setPlayedCardRes(north, card);
                    east.setBackgroundResource(R.drawable.back);
                    west.setBackgroundResource(R.drawable.back);
                } else if ((player == plNum + 3 && plNum != 4) || (plNum == 4 && player == 2)) {
                    setPlayedCardRes(west, card);
                    east.setBackgroundResource(R.drawable.back);
                    north.setBackgroundResource(R.drawable.back);
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    private ValueEventListener turnListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            int turn1 = snapshot.getValue(int.class);
            yourTurn = findViewById(R.id.your_turn);
            yourTurn.setVisibility(View.INVISIBLE);
            yourTurn.setTextColor(Color.YELLOW);
            if (turn1 == plNum) {
                yourTurn.setVisibility(View.VISIBLE);
                turn = true;
                east_name.setTextColor(Color.WHITE);
                north_name.setTextColor(Color.WHITE);
                west_name.setTextColor(Color.WHITE);
            }else {
                if ((turn1 == plNum + 1 && plNum != 4) || (plNum == 4 && turn1 == 0)){
                    east_name.setTextColor(Color.RED);
                    north_name.setTextColor(Color.WHITE);
                    west_name.setTextColor(Color.WHITE);
                }else if ((turn1 == plNum + 2 && plNum != 4) || (plNum == 4 && turn1 == 1)){
                    north_name.setTextColor(Color.RED);
                    east_name.setTextColor(Color.WHITE);
                    west_name.setTextColor(Color.WHITE);
                }else if ((turn1 == plNum + 3 && plNum != 4) || (plNum == 4 && turn1 == 2)){
                    west_name.setTextColor(Color.RED);
                    east_name.setTextColor(Color.WHITE);
                    north_name.setTextColor(Color.WHITE);
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    private ValueEventListener endedListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            countPoints();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game);

        setButtons();
    }

    private void getParameters(){

        thisPlayer = new Player();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String firebaseURL = extras.getString("firebaseURL");
        String gameName = extras.getString("gameName");
        plNum = extras.getInt("plNum");
        FirebaseDatabase database = FirebaseDatabase.getInstance(firebaseURL);
        DatabaseReference myRef = database.getReference();
        gameRef = myRef.child(gameName);

        gameRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                player0Name = snapshot.child("0").getValue(String.class);
                player1Name = snapshot.child("1").getValue(String.class);
                player2Name = snapshot.child("2").getValue(String.class);
                player3Name = snapshot.child("3").getValue(String.class);

                int turn1 = snapshot.child("turn").getValue(int.class);
                yourTurn = findViewById(R.id.your_turn);
                if (turn1 == plNum) {
                    yourTurn.setVisibility(View.VISIBLE);
                    turn = true;
                    east_name.setTextColor(Color.WHITE);
                    north_name.setTextColor(Color.WHITE);
                    west_name.setTextColor(Color.WHITE);
                }else {
                    yourTurn.setVisibility(View.INVISIBLE);
                    if ((turn1 == plNum + 1 && plNum != 4) || (plNum == 4 && turn1 == 0)){
                        east_name.setTextColor(Color.RED);
                        north_name.setTextColor(Color.WHITE);
                        west_name.setTextColor(Color.WHITE);
                    }else if ((turn1 == plNum + 2 && plNum != 4) || (plNum == 4 && turn1 == 1)){
                        north_name.setTextColor(Color.RED);
                        east_name.setTextColor(Color.WHITE);
                        west_name.setTextColor(Color.WHITE);
                    }else if ((turn1 == plNum + 3 && plNum != 4) || (plNum == 4 && turn1 == 2)){
                        west_name.setTextColor(Color.RED);
                        east_name.setTextColor(Color.WHITE);
                        north_name.setTextColor(Color.WHITE);
                    }
                }

                switch (plNum){
                    case 0:
                        east_name.setText(player1Name);
                        north_name.setText(player2Name);
                        west_name.setText(player3Name);
                        thisPlayer.setUsername(player0Name);
                        break;
                    case 1:
                        east_name.setText(player2Name);
                        north_name.setText(player3Name);
                        west_name.setText(player0Name);
                        thisPlayer.setUsername(player1Name);
                        break;
                    case 2:
                        east_name.setText(player3Name);
                        north_name.setText(player0Name);
                        west_name.setText(player1Name);
                        thisPlayer.setUsername(player2Name);
                        break;
                    case 3:
                        east_name.setText(player0Name);
                        north_name.setText(player1Name);
                        west_name.setText(player2Name);
                        thisPlayer.setUsername(player3Name);
                        break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        gameRef.child("pc").setValue(plNum);
        //gameRef.child("start").setValue(true);
        thisPlayerHandRef = gameRef.child("pl" + plNum).child("hand").getRef();
        thisPlayerHandRef.addValueEventListener(thisPlayerHandListener);
        cardsOnBoardRef = gameRef.child("board").getRef();
        cardsOnBoardRef.addValueEventListener(boardListener);
        turnRef = gameRef.child("turn").getRef();
        turnRef.addValueEventListener(turnListener);
        endedRef = gameRef.child("ended").getRef();
        endedRef.addValueEventListener(endedListener);
        takenRef = gameRef.child("taken" + plNum % 2).getRef();
        takenRef.addValueEventListener(takenListener);
        playedCardRef = gameRef.child("playedCard").getRef();
        playedCardRef.addValueEventListener(playedCardListener);

        if (plNum == 3) {
            gameRef.child("start").setValue(true);
        }else {
            gameRef.child("pc").setValue(plNum);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        getParameters();

        if(plNum == 3){
            createPlayersAndDistributeCards(createCards());

            Random r = new Random();
            int n = r.nextInt(4);
            if (n == 3){
                turn = true;
            }
            gameRef.child("turn").setValue(n);
        }


    }

    private List<Card> createCards(){
        List<Card> cards = new ArrayList<>();

        for (int i = 1; i < 11; i++){
            cards.add(new Card("c" + i));
        }
        for (int i = 1; i < 11; i++){
            cards.add(new Card("d" + i));
        }
        for (int i = 1; i < 11; i++){
            cards.add(new Card("h" + i));
        }
        for (int i = 1; i < 11; i++){
            cards.add(new Card("s" + i));
        }

        Collections.shuffle(cards);

        return cards;
    }

    private void createPlayersAndDistributeCards(List<Card> cards){
        List<Card> p0Hand = sortHand(cards.subList(0, 10));
        List<Card> p1Hand = sortHand(cards.subList(10, 20));
        List<Card> p2Hand = sortHand(cards.subList(20, 30));
        List<Card> p3Hand = sortHand(cards.subList(30, 40));

        for (int i = 0; i < 10; i++){
            cardsBoard.add(new Card("empty"));
        }
        for (int i = 0; i < 40; i++){
            takenDeck.add(new Card("empty"));
        }

        gameRef.child("pl0").child("hand").setValue(p0Hand);
        gameRef.child("pl1").child("hand").setValue(p1Hand);
        gameRef.child("pl2").child("hand").setValue(p2Hand);
        gameRef.child("pl3").child("hand").setValue(p3Hand);
        gameRef.child("board").setValue(cardsBoard);
        gameRef.child("taken" + plNum % 2).setValue(takenDeck);
    }

    private void setButtons(){
        north_name = findViewById(R.id.north_player_name);
        east_name = findViewById(R.id.east_player_name);
        west_name = findViewById(R.id.west_player_name);

        north = findViewById(R.id.cardNorth);
        east = findViewById(R.id.cardEast);
        west = findViewById(R.id.cardWest);
        north.setImageResource(R.drawable.back);
        west.setImageResource(R.drawable.back);
        west.setRotation(90);
        west.setMaxHeight(north.getWidth());
        east.setImageResource(R.drawable.back);
        east.setRotation(90);
        east.setMaxHeight(north.getWidth());

        progressBar = findViewById(R.id.progress_this_player);
        progressBar.setVisibility(View.INVISIBLE);

        deck.add(findViewById(R.id.card0));
        deck.add(findViewById(R.id.card1));
        deck.add(findViewById(R.id.card2));
        deck.add(findViewById(R.id.card3));
        deck.add(findViewById(R.id.card4));
        deck.add(findViewById(R.id.card5));
        deck.add(findViewById(R.id.card6));
        deck.add(findViewById(R.id.card7));
        deck.add(findViewById(R.id.card8));
        deck.add(findViewById(R.id.card9));

        for (ImageButton b : deck){
            b.setVisibility(View.INVISIBLE);
        }

        cardBoardButtons.add(findViewById(R.id.cardBoardButton0));
        cardBoardButtons.add(findViewById(R.id.cardBoardButton1));
        cardBoardButtons.add(findViewById(R.id.cardBoardButton2));
        cardBoardButtons.add(findViewById(R.id.cardBoardButton3));
        cardBoardButtons.add(findViewById(R.id.cardBoardButton4));
        cardBoardButtons.add(findViewById(R.id.cardBoardButton5));
        cardBoardButtons.add(findViewById(R.id.cardBoardButton6));
        cardBoardButtons.add(findViewById(R.id.cardBoardButton7));
        cardBoardButtons.add(findViewById(R.id.cardBoardButton8));
        cardBoardButtons.add(findViewById(R.id.cardBoardButton9));

        for (ImageButton b : cardBoardButtons){
            b.setVisibility(View.INVISIBLE);
            b.setClickable(false);
        }

        cardBoardImages.add(findViewById(R.id.cardBoardImage0));
        cardBoardImages.add(findViewById(R.id.cardBoardImage1));
        cardBoardImages.add(findViewById(R.id.cardBoardImage2));
        cardBoardImages.add(findViewById(R.id.cardBoardImage3));
        cardBoardImages.add(findViewById(R.id.cardBoardImage4));
        cardBoardImages.add(findViewById(R.id.cardBoardImage5));
        cardBoardImages.add(findViewById(R.id.cardBoardImage6));
        cardBoardImages.add(findViewById(R.id.cardBoardImage7));
        cardBoardImages.add(findViewById(R.id.cardBoardImage8));
        cardBoardImages.add(findViewById(R.id.cardBoardImage9));

        for (ImageView i : cardBoardImages){
            i.setVisibility(View.INVISIBLE);
            i.setBackgroundColor(Color.YELLOW);
        }
    }

    private void updateHandButtons(){
        for (int i = 0; i < deck.size(); i++){
            setRes(deck.get(i), thisPlayer.hand.get(i).name);
        }
    }

    private void updateBoardImages(){
        for (int i = 0; i < cardsBoard.size(); i++){
            setRes(cardBoardButtons.get(i), cardsBoard.get(i).name);
        }
    }

    private void setRes(ImageButton b, String r) {
        boolean visible = true;
        switch (r) {
            case "c1":
                b.setBackgroundResource(R.drawable.c1);
                break;
            case "c2":
                b.setBackgroundResource(R.drawable.c2);
                break;
            case "c3":
                b.setBackgroundResource(R.drawable.c3);
                break;
            case "c4":
                b.setBackgroundResource(R.drawable.c4);
                break;
            case "c5":
                b.setBackgroundResource(R.drawable.c5);
                break;
            case "c6":
                b.setBackgroundResource(R.drawable.c6);
                break;
            case "c7":
                b.setBackgroundResource(R.drawable.c7);
                break;
            case "c8":
                b.setBackgroundResource(R.drawable.c8);
                break;
            case "c9":
                b.setBackgroundResource(R.drawable.c9);
                break;
            case "c10":
                b.setBackgroundResource(R.drawable.c10);
                break;
            case "d1":
                b.setBackgroundResource(R.drawable.d1);
                break;
            case "d2":
                b.setBackgroundResource(R.drawable.d2);
                break;
            case "d3":
                b.setBackgroundResource(R.drawable.d3);
                break;
            case "d4":
                b.setBackgroundResource(R.drawable.d4);
                break;
            case "d5":
                b.setBackgroundResource(R.drawable.d5);
                break;
            case "d6":
                b.setBackgroundResource(R.drawable.d6);
                break;
            case "d7":
                b.setBackgroundResource(R.drawable.d7);
                break;
            case "d8":
                b.setBackgroundResource(R.drawable.d8);
                break;
            case "d9":
                b.setBackgroundResource(R.drawable.d9);
                break;
            case "d10":
                b.setBackgroundResource(R.drawable.d10);
                break;
            case "h1":
                b.setBackgroundResource(R.drawable.h1);
                break;
            case "h2":
                b.setBackgroundResource(R.drawable.h2);
                break;
            case "h3":
                b.setBackgroundResource(R.drawable.h3);
                break;
            case "h4":
                b.setBackgroundResource(R.drawable.h4);
                break;
            case "h5":
                b.setBackgroundResource(R.drawable.h5);
                break;
            case "h6":
                b.setBackgroundResource(R.drawable.h6);
                break;
            case "h7":
                b.setBackgroundResource(R.drawable.h7);
                break;
            case "h8":
                b.setBackgroundResource(R.drawable.h8);
                break;
            case "h9":
                b.setBackgroundResource(R.drawable.h9);
                break;
            case "h10":
                b.setBackgroundResource(R.drawable.h10);
                break;
            case "s1":
                b.setBackgroundResource(R.drawable.s1);
                break;
            case "s2":
                b.setBackgroundResource(R.drawable.s2);
                break;
            case "s3":
                b.setBackgroundResource(R.drawable.s3);
                break;
            case "s4":
                b.setBackgroundResource(R.drawable.s4);
                break;
            case "s5":
                b.setBackgroundResource(R.drawable.s5);
                break;
            case "s6":
                b.setBackgroundResource(R.drawable.s6);
                break;
            case "s7":
                b.setBackgroundResource(R.drawable.s7);
                break;
            case "s8":
                b.setBackgroundResource(R.drawable.s8);
                break;
            case "s9":
                b.setBackgroundResource(R.drawable.s9);
                break;
            case "s10":
                b.setBackgroundResource(R.drawable.s10);
                break;
            default:
                visible = false;
        }

        b.setClickable(visible);
        if (visible){
            b.setVisibility(View.VISIBLE);
        }else {
            b.setVisibility(View.INVISIBLE);
        }
    }

    private void setPlayedCardRes(ImageView b, String r) {
        switch (r) {
            case "c1":
                b.setBackgroundResource(R.drawable.c1);
                break;
            case "c2":
                b.setBackgroundResource(R.drawable.c2);
                break;
            case "c3":
                b.setBackgroundResource(R.drawable.c3);
                break;
            case "c4":
                b.setBackgroundResource(R.drawable.c4);
                break;
            case "c5":
                b.setBackgroundResource(R.drawable.c5);
                break;
            case "c6":
                b.setBackgroundResource(R.drawable.c6);
                break;
            case "c7":
                b.setBackgroundResource(R.drawable.c7);
                break;
            case "c8":
                b.setBackgroundResource(R.drawable.c8);
                break;
            case "c9":
                b.setBackgroundResource(R.drawable.c9);
                break;
            case "c10":
                b.setBackgroundResource(R.drawable.c10);
                break;
            case "d1":
                b.setBackgroundResource(R.drawable.d1);
                break;
            case "d2":
                b.setBackgroundResource(R.drawable.d2);
                break;
            case "d3":
                b.setBackgroundResource(R.drawable.d3);
                break;
            case "d4":
                b.setBackgroundResource(R.drawable.d4);
                break;
            case "d5":
                b.setBackgroundResource(R.drawable.d5);
                break;
            case "d6":
                b.setBackgroundResource(R.drawable.d6);
                break;
            case "d7":
                b.setBackgroundResource(R.drawable.d7);
                break;
            case "d8":
                b.setBackgroundResource(R.drawable.d8);
                break;
            case "d9":
                b.setBackgroundResource(R.drawable.d9);
                break;
            case "d10":
                b.setBackgroundResource(R.drawable.d10);
                break;
            case "h1":
                b.setBackgroundResource(R.drawable.h1);
                break;
            case "h2":
                b.setBackgroundResource(R.drawable.h2);
                break;
            case "h3":
                b.setBackgroundResource(R.drawable.h3);
                break;
            case "h4":
                b.setBackgroundResource(R.drawable.h4);
                break;
            case "h5":
                b.setBackgroundResource(R.drawable.h5);
                break;
            case "h6":
                b.setBackgroundResource(R.drawable.h6);
                break;
            case "h7":
                b.setBackgroundResource(R.drawable.h7);
                break;
            case "h8":
                b.setBackgroundResource(R.drawable.h8);
                break;
            case "h9":
                b.setBackgroundResource(R.drawable.h9);
                break;
            case "h10":
                b.setBackgroundResource(R.drawable.h10);
                break;
            case "s1":
                b.setBackgroundResource(R.drawable.s1);
                break;
            case "s2":
                b.setBackgroundResource(R.drawable.s2);
                break;
            case "s3":
                b.setBackgroundResource(R.drawable.s3);
                break;
            case "s4":
                b.setBackgroundResource(R.drawable.s4);
                break;
            case "s5":
                b.setBackgroundResource(R.drawable.s5);
                break;
            case "s6":
                b.setBackgroundResource(R.drawable.s6);
                break;
            case "s7":
                b.setBackgroundResource(R.drawable.s7);
                break;
            case "s8":
                b.setBackgroundResource(R.drawable.s8);
                break;
            case "s9":
                b.setBackgroundResource(R.drawable.s9);
                break;
            case "s10":
                b.setBackgroundResource(R.drawable.s10);
                break;
        }
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick(View v) {
        if (!turn){
            return;
        }
        int index = -1;
        switch (v.getId()){
            case R.id.card0:
                index = 0;
                break;
            case R.id.card1:
                index = 1;
                break;
            case R.id.card2:
                index = 2;
                break;
            case R.id.card3:
                index = 3;
                break;
            case R.id.card4:
                index = 4;
                break;
            case R.id.card5:
                index = 5;
                break;
            case R.id.card6:
                index = 6;
                break;
            case R.id.card7:
                index = 7;
                break;
            case R.id.card8:
                index = 8;
                break;
            case R.id.card9:
                index = 9;
                break;
            case R.id.cardBoardButton0:
                index = 10;
                break;
            case R.id.cardBoardButton1:
                index = 11;
                break;
            case R.id.cardBoardButton2:
                index = 12;
                break;
            case R.id.cardBoardButton3:
                index = 13;
                break;
            case R.id.cardBoardButton4:
                index = 14;
                break;
            case R.id.cardBoardButton5:
                index = 15;
                break;
            case R.id.cardBoardButton6:
                index = 16;
                break;
            case R.id.cardBoardButton7:
                index = 17;
                break;
            case R.id.cardBoardButton8:
                index = 18;
                break;
            case R.id.cardBoardButton9:
                index = 19;
                break;
        }
        if (index >= 0 && index < 10) {
            playedCard = index;
            playCard(v);
        }else{
            checkChoicesAndCompleteAction(index);
        }
    }

    private void evaluateOptions(){

        if (getCardValue(thisPlayer.hand.get(playedCard)) == 1){
            assoPigliaTutto(playedCard);
            return;
        }
        if (cardsBoard.isEmpty()){
            cardsOnBoardRef.child(String.valueOf(0)).setValue(thisPlayer.hand.get(playedCard));
            thisPlayerHandRef.child(String.valueOf(playedCard)).setValue(new Card("empty"));
            nextTurn();
            return;
        }

        List<Integer> tuple = new ArrayList<>();
        for (int i=0; i < cardsBoard.size(); i++){
            if (!cardsBoard.get(i).name.equals("empty") && !thisPlayer.hand.get(playedCard).name.equals("empty") && getCardValue(cardsBoard.get(i)) == getCardValue(thisPlayer.hand.get(playedCard))){
                tuple.add(i);
                options.add(tuple);
            }
            for (int j= i + 1; j < cardsBoard.size(); j++){
                if (!cardsBoard.get(i).name.equals("empty") && !cardsBoard.get(j).name.equals("empty") && !thisPlayer.hand.get(playedCard).name.equals("empty") && getCardValue(cardsBoard.get(i)) + getCardValue(cardsBoard.get(j)) == getCardValue(thisPlayer.hand.get(playedCard))){
                    tuple.add(i);
                    tuple.add(j);
                    options.add(tuple);
                }
                for (int k = j + 1; k < cardsBoard.size(); k++){
                    if (!cardsBoard.get(i).name.equals("empty") && !cardsBoard.get(j).name.equals("empty") && !cardsBoard.get(k).name.equals("empty") && !thisPlayer.hand.get(playedCard).name.equals("empty") && getCardValue(cardsBoard.get(i)) + getCardValue(cardsBoard.get(j)) + getCardValue(cardsBoard.get(j)) == getCardValue(thisPlayer.hand.get(playedCard))){
                        tuple.add(i);
                        tuple.add(j);
                        tuple.add(k);
                        options.add(tuple);
                    }
                }
            }
        }

        if (options.isEmpty()){
            cardsOnBoardRef.child(String.valueOf(getFirstEmptyInBoard())).setValue(thisPlayer.hand.get(playedCard));
            thisPlayerHandRef.child(String.valueOf(playedCard)).setValue(new Card("empty"));
            nextTurn();
            return;
        }

        if (options.size() == 1) {

            int takenIndex = getFirstEmptyInTaken();

            if (options.get(0).size() == 1) {
                thisPlayer.hand.get(playedCard).scopa = true;
            }
            for (Integer i : options.get(0)) {
                takenRef.child(String.valueOf(takenIndex)).setValue(cardsBoard.get(i));
                cardsOnBoardRef.child(String.valueOf(i)).setValue(new Card("empty"));
                takenIndex++;
            }
            takenRef.child(String.valueOf(takenIndex)).setValue(thisPlayer.hand.get(playedCard));
            thisPlayerHandRef.child(String.valueOf(playedCard)).setValue(new Card("empty"));
            nextTurn();
        }
    }

    private void checkChoicesAndCompleteAction(int boardCardIndex){

        int takenIndex = getFirstEmptyInTaken();

        choices.add(boardCardIndex);

        if (options.contains(choices)){
            for (Integer integer : choices){
                takenRef.child(String.valueOf(takenIndex)).setValue(cardsBoard.get(integer));
                cardsOnBoardRef.child(String.valueOf(integer)).setValue(new Card("empty"));
                takenIndex++;
            }
            takenRef.child(String.valueOf(takenIndex)).setValue(thisPlayer.hand.get(playedCard));
            thisPlayerHandRef.child(String.valueOf(playedCard)).setValue(new Card("empty"));
            nextTurn();
        }
    }

    private void assoPigliaTutto(int assoIndex){

        int takenIndex = getFirstEmptyInTaken();

        for (int i = takenIndex, j = 0; i < takenDeck.size() && j < cardsBoard.size(); i++, j++) {
            if (cardsBoard.get(j).name.equals("empty")){
                takenIndex = i;
                break;
            }
            takenRef.child(String.valueOf(i)).setValue(cardsBoard.get(j));
        }

        takenRef.child(String.valueOf(takenIndex)).setValue(thisPlayer.hand.get(assoIndex));

        List<Card> emptyBoard = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            emptyBoard.add(new Card("empty"));
        }
        cardsOnBoardRef.setValue(emptyBoard);
        thisPlayerHandRef.child(String.valueOf(assoIndex)).setValue(new Card("empty"));
        nextTurn();
    }

    private int getFirstEmptyInTaken(){
        int takenIndex = -1;
        for (int i = 0; i < takenDeck.size(); i++){
            if (takenDeck.get(i).name.equals("empty")){
                takenIndex = i;
                break;
            }
        }
        return takenIndex;
    }

    private int getFirstEmptyInBoard(){
        int boardIndex = -1;
        for (int i = 0; i < cardsBoard.size(); i++){
            if (cardsBoard.get(i).name.equals("empty")){
                boardIndex = i;
                break;
            }
        }
        return boardIndex;
    }

    private int getCardValue(Card c){
        if (c.name.length() == 3) {
            return 10;
        }
        return Integer.parseInt(String.valueOf(c.name.charAt(1)));
    }

    private void enableBoardButtons(){

        boolean toSelect = false;

        for (List<Integer> optionList : options){
            for (Integer i : optionList){
                for (List<Integer> optionList1 : options){
                    if (!optionList1.contains(i)){
                        toSelect = true;
                    }
                }
                if (toSelect) {
                    cardBoardButtons.get(i).setClickable(true);
                    cardBoardImages.get(i).setVisibility(View.VISIBLE);
                }
                toSelect = false;
            }
        }
    }

    private void playCard(View v){
        playedCardRef.child("pl").setValue(plNum);
        playedCardRef.child("card").setValue(thisPlayer.hand.get(playedCard).name);
        v.animate().setDuration(1000).scaleXBy(0.5f).scaleYBy(0.5f).translationY(-400f).withEndAction(() -> {
            v.setVisibility(View.INVISIBLE);
            v.setClickable(false);
            evaluateOptions();
            enableBoardButtons();
        }).start();
    }

    private List<Card> sortHand(List<Card> a) {
        boolean sorted = false;
        Card temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < a.size() - 1; i++) {
                if (getCardValue(a.get(i)) > getCardValue(a.get(i + 1))) {
                    temp = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return a;
    }

    private void nextTurn(){
        playedCard = -1;
        playedCardRef.child("pl").setValue(-1);
        playedCardRef.child("card").setValue(thisPlayer.hand.get(playedCard).name);
        choices.clear();
        options.clear();
        if (plNum < 4) {
            turnRef.setValue(plNum + 1);
        }else {
            turnRef.setValue(0);
        }
    }

    private void countPoints(){

    }
}
