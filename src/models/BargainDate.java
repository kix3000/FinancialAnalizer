package models;

import java.util.Calendar;

public class BargainDate extends Calendar {
    @Override
    protected void computeTime() {

    }

    @Override
    protected void computeFields() {

    }

    @Override
    public void add(int field, int amount) {

    }

    @Override
    public void roll(int field, boolean up) {

    }

    @Override
    public int getMinimum(int field) {
        return 0;
    }

    @Override
    public int getMaximum(int field) {
        return 0;
    }

    @Override
    public int getGreatestMinimum(int field) {
        return 0;
    }

    @Override
    public int getLeastMaximum(int field) {
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.get(this.DATE)) + "." + String.valueOf(this.get(this.MONTH)+1)+ "." + String.valueOf(this.get(this.YEAR));
    }


}
