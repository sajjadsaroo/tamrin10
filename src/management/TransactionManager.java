package management;

import datastructures.lists.CustomArrayList;
import library.Transaction;

public class TransactionManager {
    private CustomArrayList<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new CustomArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {
        String id = "T" + (transactions.size() + 1);
        Transaction transaction = new Transaction(id, bookTitle, memberName, type);
        transactions.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        return transactions.get(index);
    }
}
