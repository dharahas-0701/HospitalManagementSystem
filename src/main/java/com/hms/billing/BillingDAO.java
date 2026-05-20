package com.hms.billing;

import java.util.ArrayList;

public interface BillingDAO {
    void generateBill(Bill b);

    ArrayList<Bill> getAllBills();

    Bill getBillById(int id);

    void markBillAsPaid(int id);

    void printDetails(Bill b);

}
