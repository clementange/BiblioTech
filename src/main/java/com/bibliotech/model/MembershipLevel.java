package main.java.com.bibliotech.model;

public enum MembershipLevel {
    STANDARD(3, 14), PREMIUM(10,30), STAFF(20,60);
    private final  int maxLoans;
    private final int loanDurationDays;

    MembershipLevel(int maxLoans, int loanDurationDays) {
        this.maxLoans = maxLoans;
        this.loanDurationDays = loanDurationDays;
    }

    public int getMaxLoans() {
        return maxLoans;
    }

    public int getLoanDurationDays() {
        return loanDurationDays;
    }

}
