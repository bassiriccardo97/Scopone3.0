package com.example.scopone30.Model;

public class Card {

    public String name;
    public boolean scopa = false;

    public Card() {
    }

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isScopa() {
        return scopa;
    }

    public void setScopa(boolean scopa) {
        this.scopa = scopa;
    }
}
