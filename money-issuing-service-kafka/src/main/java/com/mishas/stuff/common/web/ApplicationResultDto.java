package com.mishas.stuff.common.web;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class ApplicationResultDto implements Serializable {

    @NotNull
    private String applicationId;
    @NotNull
    private boolean approved;
    @NotNull
    private int loanAmount;

    public ApplicationResultDto() {
        super();
    }

    public String getApplicationId() {
        return applicationId;
    }

    public boolean isApproved() {
        return approved;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public ApplicationResultDto(String applicationId, boolean approved, int loanAmount) {
        this.applicationId = applicationId;
        this.approved = approved;
        this.loanAmount = loanAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationResultDto that = (ApplicationResultDto) o;
        return isApproved() == that.isApproved() &&
                getLoanAmount() == that.getLoanAmount() &&
                Objects.equals(getApplicationId(), that.getApplicationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getApplicationId(), isApproved(), getLoanAmount());
    }

    @Override
    public String toString() {
        return "ApplicationResultDto{" +
                "applicationId='" + applicationId + '\'' +
                ", approved=" + approved +
                ", loanAmount=" + loanAmount +
                '}';
    }
}
