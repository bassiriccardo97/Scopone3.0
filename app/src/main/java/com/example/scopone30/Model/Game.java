package com.example.scopone30.Model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;

@IgnoreExtraProperties
public class Game {

    public String room;

    public Player player0;
    public Player player1;
    public Player player2;
    public Player player3;

    public Card cardBoard0;
    public Card cardBoard1;
    public Card cardBoard2;
    public Card cardBoard3;
    public Card cardBoard4;
    public Card cardBoard5;
    public Card cardBoard6;
    public Card cardBoard7;
    public Card cardBoard8;
    public Card cardBoard9;

    public Card deck1Card0;
    public Card deck1Card1;
    public Card deck1Card2;
    public Card deck1Card3;
    public Card deck1Card4;
    public Card deck1Card5;
    public Card deck1Card6;
    public Card deck1Card7;
    public Card deck1Card8;
    public Card deck1Card9;
    public Card deck1Card10;
    public Card deck1Card11;
    public Card deck1Card12;
    public Card deck1Card13;
    public Card deck1Card14;
    public Card deck1Card15;
    public Card deck1Card16;
    public Card deck1Card17;
    public Card deck1Card18;
    public Card deck1Card19;
    public Card deck1Card20;
    public Card deck1Card21;
    public Card deck1Card22;
    public Card deck1Card23;
    public Card deck1Card24;
    public Card deck1Card25;
    public Card deck1Card26;
    public Card deck1Card27;
    public Card deck1Card28;
    public Card deck1Card29;
    public Card deck1Card30;
    public Card deck1Card31;
    public Card deck1Card32;
    public Card deck1Card33;
    public Card deck1Card34;
    public Card deck1Card35;
    public Card deck1Card36;
    public Card deck1Card37;
    public Card deck1Card38;
    public Card deck1Card39;

    public Card deck2Card0;
    public Card deck2Card1;
    public Card deck2Card2;
    public Card deck2Card3;
    public Card deck2Card4;
    public Card deck2Card5;
    public Card deck2Card6;
    public Card deck2Card7;
    public Card deck2Card8;
    public Card deck2Card9;
    public Card deck2Card10;
    public Card deck2Card11;
    public Card deck2Card12;
    public Card deck2Card13;
    public Card deck2Card14;
    public Card deck2Card15;
    public Card deck2Card16;
    public Card deck2Card17;
    public Card deck2Card18;
    public Card deck2Card19;
    public Card deck2Card20;
    public Card deck2Card21;
    public Card deck2Card22;
    public Card deck2Card23;
    public Card deck2Card24;
    public Card deck2Card25;
    public Card deck2Card26;
    public Card deck2Card27;
    public Card deck2Card28;
    public Card deck2Card29;
    public Card deck2Card30;
    public Card deck2Card31;
    public Card deck2Card32;
    public Card deck2Card33;
    public Card deck2Card34;
    public Card deck2Card35;
    public Card deck2Card36;
    public Card deck2Card37;
    public Card deck2Card38;
    public Card deck2Card39;

    public boolean start = false;
    public int playerCount = 0;
    public boolean ended = false;
    public int addPlayer = 0;

    public Game() {
        //default constructor necessary for Realtime Database
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public int getAddPlayer() {
        return addPlayer;
    }

    public void setAddPlayer(int addPlayer) {
        this.addPlayer = addPlayer;
    }

    public Player getPlayer0() {
        return player0;
    }

    public void setPlayer0(Player player0) {
        this.player0 = player0;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer3() {
        return player3;
    }

    public void setPlayer3(Player player3) {
        this.player3 = player3;
    }

    public Card getCardBoard0() {
        return cardBoard0;
    }

    public void setCardBoard0(Card cardBoard0) {
        this.cardBoard0 = cardBoard0;
    }

    public Card getCardBoard1() {
        return cardBoard1;
    }

    public void setCardBoard1(Card cardBoard1) {
        this.cardBoard1 = cardBoard1;
    }

    public Card getCardBoard2() {
        return cardBoard2;
    }

    public void setCardBoard2(Card cardBoard2) {
        this.cardBoard2 = cardBoard2;
    }

    public Card getCardBoard3() {
        return cardBoard3;
    }

    public void setCardBoard3(Card cardBoard3) {
        this.cardBoard3 = cardBoard3;
    }

    public Card getCardBoard4() {
        return cardBoard4;
    }

    public void setCardBoard4(Card cardBoard4) {
        this.cardBoard4 = cardBoard4;
    }

    public Card getCardBoard5() {
        return cardBoard5;
    }

    public void setCardBoard5(Card cardBoard5) {
        this.cardBoard5 = cardBoard5;
    }

    public Card getCardBoard6() {
        return cardBoard6;
    }

    public void setCardBoard6(Card cardBoard6) {
        this.cardBoard6 = cardBoard6;
    }

    public Card getCardBoard7() {
        return cardBoard7;
    }

    public void setCardBoard7(Card cardBoard7) {
        this.cardBoard7 = cardBoard7;
    }

    public Card getCardBoard8() {
        return cardBoard8;
    }

    public void setCardBoard8(Card cardBoard8) {
        this.cardBoard8 = cardBoard8;
    }

    public Card getCardBoard9() {
        return cardBoard9;
    }

    public void setCardBoard9(Card cardBoard9) {
        this.cardBoard9 = cardBoard9;
    }

    public Card getDeck1Card0() {
        return deck1Card0;
    }

    public void setDeck1Card0(Card deck1Card0) {
        this.deck1Card0 = deck1Card0;
    }

    public Card getDeck1Card1() {
        return deck1Card1;
    }

    public void setDeck1Card1(Card deck1Card1) {
        this.deck1Card1 = deck1Card1;
    }

    public Card getDeck1Card2() {
        return deck1Card2;
    }

    public void setDeck1Card2(Card deck1Card2) {
        this.deck1Card2 = deck1Card2;
    }

    public Card getDeck1Card3() {
        return deck1Card3;
    }

    public void setDeck1Card3(Card deck1Card3) {
        this.deck1Card3 = deck1Card3;
    }

    public Card getDeck1Card4() {
        return deck1Card4;
    }

    public void setDeck1Card4(Card deck1Card4) {
        this.deck1Card4 = deck1Card4;
    }

    public Card getDeck1Card5() {
        return deck1Card5;
    }

    public void setDeck1Card5(Card deck1Card5) {
        this.deck1Card5 = deck1Card5;
    }

    public Card getDeck1Card6() {
        return deck1Card6;
    }

    public void setDeck1Card6(Card deck1Card6) {
        this.deck1Card6 = deck1Card6;
    }

    public Card getDeck1Card7() {
        return deck1Card7;
    }

    public void setDeck1Card7(Card deck1Card7) {
        this.deck1Card7 = deck1Card7;
    }

    public Card getDeck1Card8() {
        return deck1Card8;
    }

    public void setDeck1Card8(Card deck1Card8) {
        this.deck1Card8 = deck1Card8;
    }

    public Card getDeck1Card9() {
        return deck1Card9;
    }

    public void setDeck1Card9(Card deck1Card9) {
        this.deck1Card9 = deck1Card9;
    }

    public Card getDeck1Card10() {
        return deck1Card10;
    }

    public void setDeck1Card10(Card deck1Card10) {
        this.deck1Card10 = deck1Card10;
    }

    public Card getDeck1Card11() {
        return deck1Card11;
    }

    public void setDeck1Card11(Card deck1Card11) {
        this.deck1Card11 = deck1Card11;
    }

    public Card getDeck1Card12() {
        return deck1Card12;
    }

    public void setDeck1Card12(Card deck1Card12) {
        this.deck1Card12 = deck1Card12;
    }

    public Card getDeck1Card13() {
        return deck1Card13;
    }

    public void setDeck1Card13(Card deck1Card13) {
        this.deck1Card13 = deck1Card13;
    }

    public Card getDeck1Card14() {
        return deck1Card14;
    }

    public void setDeck1Card14(Card deck1Card14) {
        this.deck1Card14 = deck1Card14;
    }

    public Card getDeck1Card15() {
        return deck1Card15;
    }

    public void setDeck1Card15(Card deck1Card15) {
        this.deck1Card15 = deck1Card15;
    }

    public Card getDeck1Card16() {
        return deck1Card16;
    }

    public void setDeck1Card16(Card deck1Card16) {
        this.deck1Card16 = deck1Card16;
    }

    public Card getDeck1Card17() {
        return deck1Card17;
    }

    public void setDeck1Card17(Card deck1Card17) {
        this.deck1Card17 = deck1Card17;
    }

    public Card getDeck1Card18() {
        return deck1Card18;
    }

    public void setDeck1Card18(Card deck1Card18) {
        this.deck1Card18 = deck1Card18;
    }

    public Card getDeck1Card19() {
        return deck1Card19;
    }

    public void setDeck1Card19(Card deck1Card19) {
        this.deck1Card19 = deck1Card19;
    }

    public Card getDeck1Card20() {
        return deck1Card20;
    }

    public void setDeck1Card20(Card deck1Card20) {
        this.deck1Card20 = deck1Card20;
    }

    public Card getDeck1Card21() {
        return deck1Card21;
    }

    public void setDeck1Card21(Card deck1Card21) {
        this.deck1Card21 = deck1Card21;
    }

    public Card getDeck1Card22() {
        return deck1Card22;
    }

    public void setDeck1Card22(Card deck1Card22) {
        this.deck1Card22 = deck1Card22;
    }

    public Card getDeck1Card23() {
        return deck1Card23;
    }

    public void setDeck1Card23(Card deck1Card23) {
        this.deck1Card23 = deck1Card23;
    }

    public Card getDeck1Card24() {
        return deck1Card24;
    }

    public void setDeck1Card24(Card deck1Card24) {
        this.deck1Card24 = deck1Card24;
    }

    public Card getDeck1Card25() {
        return deck1Card25;
    }

    public void setDeck1Card25(Card deck1Card25) {
        this.deck1Card25 = deck1Card25;
    }

    public Card getDeck1Card26() {
        return deck1Card26;
    }

    public void setDeck1Card26(Card deck1Card26) {
        this.deck1Card26 = deck1Card26;
    }

    public Card getDeck1Card27() {
        return deck1Card27;
    }

    public void setDeck1Card27(Card deck1Card27) {
        this.deck1Card27 = deck1Card27;
    }

    public Card getDeck1Card28() {
        return deck1Card28;
    }

    public void setDeck1Card28(Card deck1Card28) {
        this.deck1Card28 = deck1Card28;
    }

    public Card getDeck1Card29() {
        return deck1Card29;
    }

    public void setDeck1Card29(Card deck1Card29) {
        this.deck1Card29 = deck1Card29;
    }

    public Card getDeck1Card30() {
        return deck1Card30;
    }

    public void setDeck1Card30(Card deck1Card30) {
        this.deck1Card30 = deck1Card30;
    }

    public Card getDeck1Card31() {
        return deck1Card31;
    }

    public void setDeck1Card31(Card deck1Card31) {
        this.deck1Card31 = deck1Card31;
    }

    public Card getDeck1Card32() {
        return deck1Card32;
    }

    public void setDeck1Card32(Card deck1Card32) {
        this.deck1Card32 = deck1Card32;
    }

    public Card getDeck1Card33() {
        return deck1Card33;
    }

    public void setDeck1Card33(Card deck1Card33) {
        this.deck1Card33 = deck1Card33;
    }

    public Card getDeck1Card34() {
        return deck1Card34;
    }

    public void setDeck1Card34(Card deck1Card34) {
        this.deck1Card34 = deck1Card34;
    }

    public Card getDeck1Card35() {
        return deck1Card35;
    }

    public void setDeck1Card35(Card deck1Card35) {
        this.deck1Card35 = deck1Card35;
    }

    public Card getDeck1Card36() {
        return deck1Card36;
    }

    public void setDeck1Card36(Card deck1Card36) {
        this.deck1Card36 = deck1Card36;
    }

    public Card getDeck1Card37() {
        return deck1Card37;
    }

    public void setDeck1Card37(Card deck1Card37) {
        this.deck1Card37 = deck1Card37;
    }

    public Card getDeck1Card38() {
        return deck1Card38;
    }

    public void setDeck1Card38(Card deck1Card38) {
        this.deck1Card38 = deck1Card38;
    }

    public Card getDeck1Card39() {
        return deck1Card39;
    }

    public void setDeck1Card39(Card deck1Card39) {
        this.deck1Card39 = deck1Card39;
    }

    public Card getDeck2Card0() {
        return deck2Card0;
    }

    public void setDeck2Card0(Card deck2Card0) {
        this.deck2Card0 = deck2Card0;
    }

    public Card getDeck2Card1() {
        return deck2Card1;
    }

    public void setDeck2Card1(Card deck2Card1) {
        this.deck2Card1 = deck2Card1;
    }

    public Card getDeck2Card2() {
        return deck2Card2;
    }

    public void setDeck2Card2(Card deck2Card2) {
        this.deck2Card2 = deck2Card2;
    }

    public Card getDeck2Card3() {
        return deck2Card3;
    }

    public void setDeck2Card3(Card deck2Card3) {
        this.deck2Card3 = deck2Card3;
    }

    public Card getDeck2Card4() {
        return deck2Card4;
    }

    public void setDeck2Card4(Card deck2Card4) {
        this.deck2Card4 = deck2Card4;
    }

    public Card getDeck2Card5() {
        return deck2Card5;
    }

    public void setDeck2Card5(Card deck2Card5) {
        this.deck2Card5 = deck2Card5;
    }

    public Card getDeck2Card6() {
        return deck2Card6;
    }

    public void setDeck2Card6(Card deck2Card6) {
        this.deck2Card6 = deck2Card6;
    }

    public Card getDeck2Card7() {
        return deck2Card7;
    }

    public void setDeck2Card7(Card deck2Card7) {
        this.deck2Card7 = deck2Card7;
    }

    public Card getDeck2Card8() {
        return deck2Card8;
    }

    public void setDeck2Card8(Card deck2Card8) {
        this.deck2Card8 = deck2Card8;
    }

    public Card getDeck2Card9() {
        return deck2Card9;
    }

    public void setDeck2Card9(Card deck2Card9) {
        this.deck2Card9 = deck2Card9;
    }

    public Card getDeck2Card10() {
        return deck2Card10;
    }

    public void setDeck2Card10(Card deck2Card10) {
        this.deck2Card10 = deck2Card10;
    }

    public Card getDeck2Card11() {
        return deck2Card11;
    }

    public void setDeck2Card11(Card deck2Card11) {
        this.deck2Card11 = deck2Card11;
    }

    public Card getDeck2Card12() {
        return deck2Card12;
    }

    public void setDeck2Card12(Card deck2Card12) {
        this.deck2Card12 = deck2Card12;
    }

    public Card getDeck2Card13() {
        return deck2Card13;
    }

    public void setDeck2Card13(Card deck2Card13) {
        this.deck2Card13 = deck2Card13;
    }

    public Card getDeck2Card14() {
        return deck2Card14;
    }

    public void setDeck2Card14(Card deck2Card14) {
        this.deck2Card14 = deck2Card14;
    }

    public Card getDeck2Card15() {
        return deck2Card15;
    }

    public void setDeck2Card15(Card deck2Card15) {
        this.deck2Card15 = deck2Card15;
    }

    public Card getDeck2Card16() {
        return deck2Card16;
    }

    public void setDeck2Card16(Card deck2Card16) {
        this.deck2Card16 = deck2Card16;
    }

    public Card getDeck2Card17() {
        return deck2Card17;
    }

    public void setDeck2Card17(Card deck2Card17) {
        this.deck2Card17 = deck2Card17;
    }

    public Card getDeck2Card18() {
        return deck2Card18;
    }

    public void setDeck2Card18(Card deck2Card18) {
        this.deck2Card18 = deck2Card18;
    }

    public Card getDeck2Card19() {
        return deck2Card19;
    }

    public void setDeck2Card19(Card deck2Card19) {
        this.deck2Card19 = deck2Card19;
    }

    public Card getDeck2Card20() {
        return deck2Card20;
    }

    public void setDeck2Card20(Card deck2Card20) {
        this.deck2Card20 = deck2Card20;
    }

    public Card getDeck2Card21() {
        return deck2Card21;
    }

    public void setDeck2Card21(Card deck2Card21) {
        this.deck2Card21 = deck2Card21;
    }

    public Card getDeck2Card22() {
        return deck2Card22;
    }

    public void setDeck2Card22(Card deck2Card22) {
        this.deck2Card22 = deck2Card22;
    }

    public Card getDeck2Card23() {
        return deck2Card23;
    }

    public void setDeck2Card23(Card deck2Card23) {
        this.deck2Card23 = deck2Card23;
    }

    public Card getDeck2Card24() {
        return deck2Card24;
    }

    public void setDeck2Card24(Card deck2Card24) {
        this.deck2Card24 = deck2Card24;
    }

    public Card getDeck2Card25() {
        return deck2Card25;
    }

    public void setDeck2Card25(Card deck2Card25) {
        this.deck2Card25 = deck2Card25;
    }

    public Card getDeck2Card26() {
        return deck2Card26;
    }

    public void setDeck2Card26(Card deck2Card26) {
        this.deck2Card26 = deck2Card26;
    }

    public Card getDeck2Card27() {
        return deck2Card27;
    }

    public void setDeck2Card27(Card deck2Card27) {
        this.deck2Card27 = deck2Card27;
    }

    public Card getDeck2Card28() {
        return deck2Card28;
    }

    public void setDeck2Card28(Card deck2Card28) {
        this.deck2Card28 = deck2Card28;
    }

    public Card getDeck2Card29() {
        return deck2Card29;
    }

    public void setDeck2Card29(Card deck2Card29) {
        this.deck2Card29 = deck2Card29;
    }

    public Card getDeck2Card30() {
        return deck2Card30;
    }

    public void setDeck2Card30(Card deck2Card30) {
        this.deck2Card30 = deck2Card30;
    }

    public Card getDeck2Card31() {
        return deck2Card31;
    }

    public void setDeck2Card31(Card deck2Card31) {
        this.deck2Card31 = deck2Card31;
    }

    public Card getDeck2Card32() {
        return deck2Card32;
    }

    public void setDeck2Card32(Card deck2Card32) {
        this.deck2Card32 = deck2Card32;
    }

    public Card getDeck2Card33() {
        return deck2Card33;
    }

    public void setDeck2Card33(Card deck2Card33) {
        this.deck2Card33 = deck2Card33;
    }

    public Card getDeck2Card34() {
        return deck2Card34;
    }

    public void setDeck2Card34(Card deck2Card34) {
        this.deck2Card34 = deck2Card34;
    }

    public Card getDeck2Card35() {
        return deck2Card35;
    }

    public void setDeck2Card35(Card deck2Card35) {
        this.deck2Card35 = deck2Card35;
    }

    public Card getDeck2Card36() {
        return deck2Card36;
    }

    public void setDeck2Card36(Card deck2Card36) {
        this.deck2Card36 = deck2Card36;
    }

    public Card getDeck2Card37() {
        return deck2Card37;
    }

    public void setDeck2Card37(Card deck2Card37) {
        this.deck2Card37 = deck2Card37;
    }

    public Card getDeck2Card38() {
        return deck2Card38;
    }

    public void setDeck2Card38(Card deck2Card38) {
        this.deck2Card38 = deck2Card38;
    }

    public Card getDeck2Card39() {
        return deck2Card39;
    }

    public void setDeck2Card39(Card deck2Card39) {
        this.deck2Card39 = deck2Card39;
    }
}
