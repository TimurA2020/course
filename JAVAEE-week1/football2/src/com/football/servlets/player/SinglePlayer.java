package com.football.servlets.player;

public class SinglePlayer {
    String name;
    String surname;
    String club;
    int salary;
    int transferPrice;

    public SinglePlayer() {
    }

    public SinglePlayer(String name, String surname, String club, int salary, int transferPrice) {
        this.name = name;
        this.surname = surname;
        this.club = club;
        this.salary = salary;
        this.transferPrice = transferPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(int transferPrice) {
        this.transferPrice = transferPrice;
    }
}

