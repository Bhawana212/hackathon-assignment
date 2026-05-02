import java.util.*;

class LoanAccount {
    private Date dueDate;
    private double outstandingBalance;
    private String accountId;

    public Date getDueDate() { return dueDate; }
    public double getOutstandingBalance() { return outstandingBalance; }
    public String getAccountId() { return accountId; }
}

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {
        // FIX: Initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Handle null input
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {
            // FIX: Null checks
            if (account != null && account.getDueDate() != null) {
                if (account.getDueDate().before(new Date())) {

                    // FIX: Only include accounts with balance > 0
                    if (account.getOutstandingBalance() > 0) {
                        result.add(account);
                    }
                }
            }
        }
        return result;
    }
}
