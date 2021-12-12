package com.example.Synesis.Model;

import java.time.LocalDate;
import java.util.Objects;

public class CurrencyPOJO {
    private String currency;
    private double rate;
    private LocalDate date;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyPOJO that = (CurrencyPOJO) o;
        return Double.compare(that.rate, rate) == 0 && Objects.equals(currency, that.currency) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, rate, date);
    }
}
