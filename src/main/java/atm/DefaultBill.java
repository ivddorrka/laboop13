package atm;

import atm.Bill;

public class DefaultBill implements Bill {
    private final int billAmount;
    private Bill next;

    public DefaultBill(int billAmount){
        this.billAmount = billAmount;
    }

    @Override
    public void setNext(Bill next) {
        this.next = next;
    }

    @Override
    public void process(int amount) {
        if (next != null) {
            next.process(amount % billAmount);
        }
        else if (amount % billAmount != 0) {
            throw new IllegalArgumentException();
        }
        System.out.println("Your amount of money is " + amount / billAmount + " out of " + billAmount + " UAH bills.");

    }
}