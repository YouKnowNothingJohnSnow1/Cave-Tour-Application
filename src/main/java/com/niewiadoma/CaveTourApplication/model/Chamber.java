package com.niewiadoma.CaveTourApplication.model;


import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Chamber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isExternal;

    @OneToMany(mappedBy = "chamberFrom")
    private Set<Corridor> corridorsFrom;

    @OneToMany(mappedBy = "chamberTo")
    private Set<Corridor> corridorsTo;

    public Chamber() {
    }

    public Chamber(int id, boolean isExternal, Set<Corridor> corridorsFrom,
                   Set<Corridor> corridorsTo) {
        this.id = id;
        this.isExternal = isExternal;
        this.corridorsFrom = corridorsFrom;
        this.corridorsTo = corridorsTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isExternal() {
        return isExternal;
    }

    public void setExternal(boolean external) {
        isExternal = external;
    }

    public Set<Corridor> getCorridorsFrom() {
        return corridorsFrom;
    }

    public void setCorridorsFrom(Set<Corridor> corridorsFrom) {
        this.corridorsFrom = corridorsFrom;
    }

    public Set<Corridor> getCorridorsTo() {
        return corridorsTo;
    }

    public void setCorridorsTo(Set<Corridor> corridorsTo) {
        this.corridorsTo = corridorsTo;
    }

    @Override
    public String toString() {
        return "Chamber{" +
                "id=" + id +
                ", isExternal=" + isExternal +
                ", corridorsFrom=" + corridorsFrom +
                ", corridorsTo=" + corridorsTo +
                '}';
    }
}
