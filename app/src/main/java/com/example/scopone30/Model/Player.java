package com.example.scopone30.Model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@IgnoreExtraProperties
public class Player {

    public String username;

    public List<Card> hand = new ArrayList<>();

    /*public Card card0;
    public Card card1;
    public Card card2;
    public Card card3;
    public Card card4;
    public Card card5;
    public Card card6;
    public Card card7;
    public Card card8;
    public Card card9;*/

    public List<Card> taken = new ArrayList<>();

    /*public Card takenCard0;
    public Card takenCard1;
    public Card takenCard2;
    public Card takenCard3;
    public Card takenCard4;
    public Card takenCard5;
    public Card takenCard6;
    public Card takenCard7;
    public Card takenCard8;
    public Card takenCard9;
    public Card takenCard10;
    public Card takenCard11;
    public Card takenCard12;
    public Card takenCard13;
    public Card takenCard14;
    public Card takenCard15;
    public Card takenCard16;
    public Card takenCard17;
    public Card takenCard18;
    public Card takenCard19;
    public Card takenCard20;
    public Card takenCard21;
    public Card takenCard22;
    public Card takenCard23;
    public Card takenCard24;
    public Card takenCard25;
    public Card takenCard26;
    public Card takenCard27;
    public Card takenCard28;
    public Card takenCard29;
    public Card takenCard30;
    public Card takenCard31;
    public Card takenCard32;
    public Card takenCard33;
    public Card takenCard34;
    public Card takenCard35;
    public Card takenCard36;
    public Card takenCard37;
    public Card takenCard38;
    public Card takenCard39;*/

    public int points = 0;
    public boolean turn = false;

    public Player() {
        // Default constructor required for Realtime Database
    }

    public Player(List<Card> deck){
        this.hand = deck;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    /*public Card getCard0() {
        return card0;
    }

    public void setCard0(Card card0) {
        this.card0 = card0;
    }

    public Card getCard1() {
        return card1;
    }

    public void setCard1(Card card1) {
        this.card1 = card1;
    }

    public Card getCard2() {
        return card2;
    }

    public void setCard2(Card card2) {
        this.card2 = card2;
    }

    public Card getCard3() {
        return card3;
    }

    public void setCard3(Card card3) {
        this.card3 = card3;
    }

    public Card getCard4() {
        return card4;
    }

    public void setCard4(Card card4) {
        this.card4 = card4;
    }

    public Card getCard5() {
        return card5;
    }

    public void setCard5(Card card5) {
        this.card5 = card5;
    }

    public Card getCard6() {
        return card6;
    }

    public void setCard6(Card card6) {
        this.card6 = card6;
    }

    public Card getCard7() {
        return card7;
    }

    public void setCard7(Card card7) {
        this.card7 = card7;
    }

    public Card getCard8() {
        return card8;
    }

    public void setCard8(Card card8) {
        this.card8 = card8;
    }

    public Card getCard9() {
        return card9;
    }

    public void setCard9(Card card9) {
        this.card9 = card9;
    }

    public Card getTakenCard0() {
        return takenCard0;
    }

    public void setTakenCard0(Card takenCard0) {
        this.takenCard0 = takenCard0;
    }

    public Card getTakenCard1() {
        return takenCard1;
    }

    public void setTakenCard1(Card takenCard1) {
        this.takenCard1 = takenCard1;
    }

    public Card getTakenCard2() {
        return takenCard2;
    }

    public void setTakenCard2(Card takenCard2) {
        this.takenCard2 = takenCard2;
    }

    public Card getTakenCard3() {
        return takenCard3;
    }

    public void setTakenCard3(Card takenCard3) {
        this.takenCard3 = takenCard3;
    }

    public Card getTakenCard4() {
        return takenCard4;
    }

    public void setTakenCard4(Card takenCard4) {
        this.takenCard4 = takenCard4;
    }

    public Card getTakenCard5() {
        return takenCard5;
    }

    public void setTakenCard5(Card takenCard5) {
        this.takenCard5 = takenCard5;
    }

    public Card getTakenCard6() {
        return takenCard6;
    }

    public void setTakenCard6(Card takenCard6) {
        this.takenCard6 = takenCard6;
    }

    public Card getTakenCard7() {
        return takenCard7;
    }

    public void setTakenCard7(Card takenCard7) {
        this.takenCard7 = takenCard7;
    }

    public Card getTakenCard8() {
        return takenCard8;
    }

    public void setTakenCard8(Card takenCard8) {
        this.takenCard8 = takenCard8;
    }

    public Card getTakenCard9() {
        return takenCard9;
    }

    public void setTakenCard9(Card takenCard9) {
        this.takenCard9 = takenCard9;
    }

    public Card getTakenCard10() {
        return takenCard10;
    }

    public void setTakenCard10(Card takenCard10) {
        this.takenCard10 = takenCard10;
    }

    public Card getTakenCard11() {
        return takenCard11;
    }

    public void setTakenCard11(Card takenCard11) {
        this.takenCard11 = takenCard11;
    }

    public Card getTakenCard12() {
        return takenCard12;
    }

    public void setTakenCard12(Card takenCard12) {
        this.takenCard12 = takenCard12;
    }

    public Card getTakenCard13() {
        return takenCard13;
    }

    public void setTakenCard13(Card takenCard13) {
        this.takenCard13 = takenCard13;
    }

    public Card getTakenCard14() {
        return takenCard14;
    }

    public void setTakenCard14(Card takenCard14) {
        this.takenCard14 = takenCard14;
    }

    public Card getTakenCard15() {
        return takenCard15;
    }

    public void setTakenCard15(Card takenCard15) {
        this.takenCard15 = takenCard15;
    }

    public Card getTakenCard16() {
        return takenCard16;
    }

    public void setTakenCard16(Card takenCard16) {
        this.takenCard16 = takenCard16;
    }

    public Card getTakenCard17() {
        return takenCard17;
    }

    public void setTakenCard17(Card takenCard17) {
        this.takenCard17 = takenCard17;
    }

    public Card getTakenCard18() {
        return takenCard18;
    }

    public void setTakenCard18(Card takenCard18) {
        this.takenCard18 = takenCard18;
    }

    public Card getTakenCard19() {
        return takenCard19;
    }

    public void setTakenCard19(Card takenCard19) {
        this.takenCard19 = takenCard19;
    }

    public Card getTakenCard20() {
        return takenCard20;
    }

    public void setTakenCard20(Card takenCard20) {
        this.takenCard20 = takenCard20;
    }

    public Card getTakenCard21() {
        return takenCard21;
    }

    public void setTakenCard21(Card takenCard21) {
        this.takenCard21 = takenCard21;
    }

    public Card getTakenCard22() {
        return takenCard22;
    }

    public void setTakenCard22(Card takenCard22) {
        this.takenCard22 = takenCard22;
    }

    public Card getTakenCard23() {
        return takenCard23;
    }

    public void setTakenCard23(Card takenCard23) {
        this.takenCard23 = takenCard23;
    }

    public Card getTakenCard24() {
        return takenCard24;
    }

    public void setTakenCard24(Card takenCard24) {
        this.takenCard24 = takenCard24;
    }

    public Card getTakenCard25() {
        return takenCard25;
    }

    public void setTakenCard25(Card takenCard25) {
        this.takenCard25 = takenCard25;
    }

    public Card getTakenCard26() {
        return takenCard26;
    }

    public void setTakenCard26(Card takenCard26) {
        this.takenCard26 = takenCard26;
    }

    public Card getTakenCard27() {
        return takenCard27;
    }

    public void setTakenCard27(Card takenCard27) {
        this.takenCard27 = takenCard27;
    }

    public Card getTakenCard28() {
        return takenCard28;
    }

    public void setTakenCard28(Card takenCard28) {
        this.takenCard28 = takenCard28;
    }

    public Card getTakenCard29() {
        return takenCard29;
    }

    public void setTakenCard29(Card takenCard29) {
        this.takenCard29 = takenCard29;
    }

    public Card getTakenCard30() {
        return takenCard30;
    }

    public void setTakenCard30(Card takenCard30) {
        this.takenCard30 = takenCard30;
    }

    public Card getTakenCard31() {
        return takenCard31;
    }

    public void setTakenCard31(Card takenCard31) {
        this.takenCard31 = takenCard31;
    }

    public Card getTakenCard32() {
        return takenCard32;
    }

    public void setTakenCard32(Card takenCard32) {
        this.takenCard32 = takenCard32;
    }

    public Card getTakenCard33() {
        return takenCard33;
    }

    public void setTakenCard33(Card takenCard33) {
        this.takenCard33 = takenCard33;
    }

    public Card getTakenCard34() {
        return takenCard34;
    }

    public void setTakenCard34(Card takenCard34) {
        this.takenCard34 = takenCard34;
    }

    public Card getTakenCard35() {
        return takenCard35;
    }

    public void setTakenCard35(Card takenCard35) {
        this.takenCard35 = takenCard35;
    }

    public Card getTakenCard36() {
        return takenCard36;
    }

    public void setTakenCard36(Card takenCard36) {
        this.takenCard36 = takenCard36;
    }

    public Card getTakenCard37() {
        return takenCard37;
    }

    public void setTakenCard37(Card takenCard37) {
        this.takenCard37 = takenCard37;
    }

    public Card getTakenCard38() {
        return takenCard38;
    }

    public void setTakenCard38(Card takenCard38) {
        this.takenCard38 = takenCard38;
    }

    public Card getTakenCard39() {
        return takenCard39;
    }

    public void setTakenCard39(Card takenCard39) {
        this.takenCard39 = takenCard39;
    }*/
}
