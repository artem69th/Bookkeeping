package model;

import exeption.ModelException;

import java.util.List;

public class Account extends Common {

    private String title;
    private Currency currency;
    private double startAmount;
    private double amount;

    public Account() {

    }

    public Account(String title, Currency currency, double startAmount) throws ModelException {
        if (title.isEmpty()) {
            throw new ModelException(ModelException.TITLE_EMPTY);
        }
        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
    }

    @Override
    public String getValueForComboBox() {
        return title;
    }

    public void setAmountFromAccount(List<Transaction> transactions, List<Transfer> transfers) {
        this.amount = startAmount;
        for (Transaction transaction : transactions) {
            if (transaction.getAccount().equals(this)) {
                this.amount += transaction.getAmount();
            }
        }

        for (Transfer transfer : transfers) {
            if (transfer.getFromAccount().equals(this)) {
                this.amount -= transfer.getFromAmount();
            }
        }

        for (Transfer transfer : transfers) {
            if (transfer.getToAccount().equals(this)) {
                this.amount += transfer.getToAmount();
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
