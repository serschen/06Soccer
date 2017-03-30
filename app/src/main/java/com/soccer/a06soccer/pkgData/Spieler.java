package com.soccer.a06soccer.pkgData;

import android.support.annotation.NonNull;

import java.util.TreeSet;

/**
 * Created by qwerqwer on 23.03.2017.
 */

public class Spieler implements Comparable<Spieler>{

    private String name = null;
    private TreeSet<Position> positions = null;
    private int goalDefault = 0;
    private int goalPenalty = 0;
    private int goalHead = 0;
    private int goalHeadSnow = 0;
    private int goalOwn = 0;
    private int nuttmeg = 0;

    public Spieler(String name, TreeSet<Position> positions, int goalDefault, int goalPenalty, int goalHead, int goalHeadSnow, int goalOwn, int nuttmeg) {
        this.name = name;
        this.positions = positions;
        this.goalDefault = goalDefault;
        this.goalPenalty = goalPenalty;
        this.goalHead = goalHead;
        this.goalHeadSnow = goalHeadSnow;
        this.goalOwn = goalOwn;
        this.nuttmeg = nuttmeg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<Position> getPositions() {
        return positions;
    }

    public void setPositions(TreeSet<Position> positions) {
        this.positions = positions;
    }

    public int getGoalDefault() {
        return goalDefault;
    }

    public int getGoalPenalty() {
        return goalPenalty;
    }

    public void setGoalPenalty(int goalPenalty) {
        this.goalPenalty = goalPenalty;
    }

    public int getGoalHead() {
        return goalHead;
    }

    public void setGoalHead(int goalHead) {
        this.goalHead = goalHead;
    }

    public int getGoalHeadSnow() {
        return goalHeadSnow;
    }

    public void setGoalHeadSnow(int goalHeadSnow) {
        this.goalHeadSnow = goalHeadSnow;
    }

    public int getGoalOwn() {
        return goalOwn;
    }

    public void setGoalOwn(int goalOwn) {
        this.goalOwn = goalOwn;
    }

    public int getNuttmeg() {
        return nuttmeg;
    }

    public void setNuttmeg(int nuttmeg) {
        this.nuttmeg = nuttmeg;
    }

    @Override
    public int compareTo(@NonNull Spieler o) {
        return this.name.compareTo(o.getName());
    }
}
