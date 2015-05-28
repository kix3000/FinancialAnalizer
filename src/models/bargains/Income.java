package models.bargains;

import java.time.LocalDate;

public class Income extends Payment
{
    public Income(LocalDate date, double amount, String place, String description) {
        super(date, amount, place, description);
    }
}
