package framework.domain;

import common.domain.Customer;

import java.time.LocalDate;

public class IndividualCustomer extends Customer {
    private LocalDate birthDate;

    public IndividualCustomer(int customerId,
                              String name,
                              String street,
                              String city,
                              String state,
                              int zip,
                              String email,
                              LocalDate birthDate) {
        super(customerId, name, street, city, state, zip, email);
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
