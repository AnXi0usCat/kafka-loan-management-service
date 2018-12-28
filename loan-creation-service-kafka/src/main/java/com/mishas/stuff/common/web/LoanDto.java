package com.mishas.stuff.common.web;

import java.io.Serializable;
import java.util.Objects;

public class LoanDto implements Serializable {

    private String loanId;
    private Boolean issued;
    private Integer loanAmont;

    public LoanDto() {
        super();
    }

    public LoanDto(String loanId, Boolean issued, Integer loanAmont) {
        this.loanId = loanId;
        this.issued = issued;
        this.loanAmont = loanAmont;
    }

    public String getLoanId() {
        return loanId;
    }

    public Boolean getIssued() {
        return issued;
    }

    public Integer getLoanAmont() {
        return loanAmont;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanDto loanDto = (LoanDto) o;
        return Objects.equals(getLoanId(), loanDto.getLoanId()) &&
                Objects.equals(getIssued(), loanDto.getIssued()) &&
                Objects.equals(getLoanAmont(), loanDto.getLoanAmont());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLoanId(), getIssued(), getLoanAmont());
    }
}
