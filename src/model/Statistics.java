package model;

import repo.SaveData;

import java.util.HashMap;
import java.util.List;

public class Statistics {
    public static double getBalanceCurrency(Currency currency) {
        SaveData saveData = SaveData.getInstance();
        double amount = 0;

        for (Account account : saveData.getAccounts()) {
            if (account.getCurrency().equals(currency)) {
                amount += account.getAmount();
            }
        }
        return amount;
    }

    public static double getBalance(Currency currency) {
        SaveData saveData = SaveData.getInstance();
        double amount = 0;

        for (Account account : saveData.getAccounts()) {
            amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }

    public static HashMap<String, Double> getDataForChartOnIncomeArticles() {
        return getDateForChartOnArticls(true);
    }


    public static HashMap<String, Double> getDataForChartOnExpArticles() {
        return getDateForChartOnArticls(false);
    }

    private static HashMap<String, Double> getDateForChartOnArticls(boolean income) {
        List<Transaction> transactionList = SaveData.getInstance().getTransactions();
        HashMap<String, Double> data = new HashMap<>();
        for (Transaction t : transactionList) {
            if ((income && t.getAmount() > 0) || (!income && t.getAmount() < 0)) {
                double amount = t.getAmount();
                String key = t.getArticle().getTitle();
                double sum = 0;
                if (!income) {
                    amount *= -1;
                }
                if (data.containsKey(key)) {
                    sum = data.get(t.getArticle().getTitle());
                }
                sum += amount * t.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                data.put(key, round(sum));
            }
        }
        return data;
    }

    private static double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}
