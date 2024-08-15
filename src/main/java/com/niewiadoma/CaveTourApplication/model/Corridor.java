package com.niewiadoma.CaveTourApplication.model;

import jakarta.persistence.*;

@Entity
public class Corridor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "chamber_from_id")
    private Chamber chamberFrom;

    @ManyToOne
    @JoinColumn(name = "chamber_to_id")
    private Chamber chamberTo;

    private boolean isDifficult;

    // Domyślny konstruktor
    public Corridor() {}

    // Konstruktor z argumentami
    public Corridor(int id, Chamber chamberFrom, Chamber chamberTo, boolean isDifficult) {
        this.id = id;
        this.chamberFrom = chamberFrom;
        this.chamberTo = chamberTo;
        this.isDifficult = isDifficult;
    }

    // Gettery i settery
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Chamber getChamberFrom() {
        return chamberFrom;
    }

    public void setChamberFrom(Chamber chamberFrom) {
        this.chamberFrom = chamberFrom;
    }

    public Chamber getChamberTo() {
        return chamberTo;
    }

    public void setChamberTo(Chamber chamberTo) {
        this.chamberTo = chamberTo;
    }

    public boolean isDifficult() {
        return isDifficult;
    }

    public void setDifficult(boolean difficult) {
        isDifficult = difficult;
    }

    @Override
    public String toString() {
        return "Corridor{" +
                "id=" + id +
                ", chamberFrom=" + chamberFrom +
                ", chamberTo=" + chamberTo +
                ", isDifficult=" + isDifficult +
                '}';
    }

}
