package models;

import java.io.Serializable;

public class Bank implements Serializable{

    private String name;
    private Boolean isCardPayable;

    private Double cardPayRelease;
    private Double cardCost;

    public Bank(String name, Boolean isCardPayable) {
        this.name = name;
        this.isCardPayable = isCardPayable;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsCardPayable() {
        return isCardPayable;
    }
}
