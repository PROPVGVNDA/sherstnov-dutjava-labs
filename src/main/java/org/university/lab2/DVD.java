package org.university.lab2;

public class DVD extends Item
{
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration <= 0) throw new IllegalArgumentException("Duration cannot be 0 or less");
        this.duration = duration;
    }

    public DVD(String title, int duration) {
        super(title);
        if (duration <= 0) throw new IllegalArgumentException("Duration cannot be 0 or less");
        this.duration = duration;
    }

    @Override
    public void borrowItem() {
        if(this.isBorrowed) throw new RuntimeException("Attempt to borrow a borrowed DVD");
        System.out.printf("DVD \"%s\"(%ds)- borrowed(ID: %s)%n", this.title, this.duration, this.uniqueID);
        this.isBorrowed = true;
    }

    @Override
    public void returnItem() {
        if(!this.isBorrowed) throw new RuntimeException("Attempt to return an unborrowed DVD");
        System.out.printf("DVD \"%s\"(%ds)- returned(ID: %s)%n", this.title, this.duration, this.uniqueID);
        this.isBorrowed = false;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "duration=" + duration +
                ", title='" + title + '\'' +
                ", uniqueID='" + uniqueID + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}