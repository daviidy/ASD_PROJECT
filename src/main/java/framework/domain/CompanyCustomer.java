package framework.domain;

import common.domain.Customer;

public class CompanyCustomer extends Customer {
    private int numOfEmployee;

    public CompanyCustomer(int customerId,
                           String name,
                           String street,
                           String city,
                           String state,
                           int zip,
                           String email,
                           int numOfEmployee) {
            super(customerId, name, street, city, state, zip, email);
            this.numOfEmployee = numOfEmployee;
    }

    public int getNumOfEmployee() {
        return numOfEmployee;
    }

    public void setNumOfEmployee(int numOfEmployee) {
        this.numOfEmployee = numOfEmployee;
    }
}
