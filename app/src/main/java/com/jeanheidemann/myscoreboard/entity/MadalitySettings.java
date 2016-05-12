package com.jeanheidemann.myscoreboard.entity;

import com.jeanheidemann.myscoreboard.enums.Order;

import java.util.ArrayList;

/**
 * Created by jean.heidemann on 12/05/2016.
 */
public class MadalitySettings {
    private String name;
    private Order order;
    private ArrayList<Integer> listPossiblePoints;
    private int maxTeams;
    private int initialPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ArrayList<Integer> getListPossiblePoints() {
        return listPossiblePoints;
    }

    public void setListPossiblePoints(ArrayList<Integer> listPossiblePoints) {
        this.listPossiblePoints = listPossiblePoints;
    }

    public int getMaxTeams() {
        return maxTeams;
    }

    public void setMaxTeams(int maxTeams) {
        this.maxTeams = maxTeams;
    }

    public int getInitialPoints() {
        return initialPoints;
    }

    public void setInitialPoints(int initialPoints) {
        this.initialPoints = initialPoints;
    }
}
