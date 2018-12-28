package com.mishas.stuff.common.web;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class ApplicationDto implements Serializable {

    public ApplicationDto() {
        super();
    }

    public ApplicationDto(
            String id,
            String firstname,
            String surname,
            int loanAmount) {


        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.loanAmount = loanAmount;
    }

    @NotNull
    private String id;
    @NotNull
    private String firstname;
    @NotNull
    private String surname;
    @NotNull
    private int loanAmount;

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationDto that = (ApplicationDto) o;
        return getLoanAmount() == that.getLoanAmount() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFirstname(), that.getFirstname()) &&
                Objects.equals(getSurname(), that.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstname(), getSurname(), getLoanAmount());
    }

    @Override
    public String toString() {
        return "ApplicationDto{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", loanAmount=" + loanAmount +
                '}';
    }
}
