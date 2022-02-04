package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;

public class OwnerDto {

    @NotEmpty(message = "Please provide first name")
    private String firstName;

    @NotEmpty(message = "Please provide middle name")
    private String middleName;

    @NotEmpty(message = "Please provide last name")
    private String lastName;


    @NotEmpty(message = "Please provide birth date")
    private String dateOfBirth;

    public OwnerDto() {

    }

    public OwnerDto(String firstName, String middleName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String date) {
        this.dateOfBirth = date;
    }

    @Override
    public String toString() {
        return "OwnerDto{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
