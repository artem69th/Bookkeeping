package model;

import exeption.ModelException;

import java.util.Objects;

public class Currency extends Common {
    private String title;
    private String code;
    private double rate;
    private boolean on;
    private boolean basic;

    public Currency() {

    }

    public Currency(String title, String code, double rate, boolean isOn, boolean basic) throws ModelException {
        if (title.isEmpty()) {
            throw new ModelException(ModelException.TITLE_EMPTY);
        }
        this.title = title;
        this.code = code;
        this.rate = rate;
        this.on = isOn;
        this.basic = basic;
    }

    @Override
    public String getValueForComboBox() {
        return title;
    }

    public double getRateByCurrency(Currency currency) {
        return rate / currency.getRate();
    }

    @Override
    public String toString() {
        return "Currency{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", rate=" + rate +
                ", on=" + on +
                ", basic=" + basic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return code.equals(currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isBasic() {
        return basic;
    }

    public void setBasic(boolean basic) {
        this.basic = basic;
    }
}
