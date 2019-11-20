package repo;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class SaveData {
    private List<Account> accounts = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private List<Article> articles = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();

    private static SaveData instance;

    private SaveData() {
    }

    public static SaveData getInstance() {
        if (instance == null) {
            instance = new SaveData();
        }
        return instance;
    }

    public Currency getBaseCurrency() {
        for (Currency currency : currencies) {
            if (currency.isBasic()) {
                return currency;
            }
            return new Currency();
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }
}
