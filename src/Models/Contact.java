package Models;

import java.time.LocalDate;

public class Contact {

    //declaring instance variables
    private Integer personID;
    private String firstName, lastName, address, phoneNumber, image;
    private LocalDate birthday;

    /**
     * This constructor will set all the instance variables to have a value.
     * @param personID
     * @param firstName
     * @param lastName
     * @param address
     * @param phoneNumber
     * @param birthday
     * @param image
     */
    public Contact(Integer personID, String firstName, String lastName, String address, String phoneNumber, LocalDate birthday, String image) {
        setPersonID(personID);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        setBirthday(birthday);
        setImage(image);
    }

    /**
     * Returns the value of the instance variable.
     * @return
     */
    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    /**
     * Returns the value of the instance variable.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Validates that the argument firstName is not empty and between 0-20 char, throws an IllegalArgumentException if it is.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if (!firstName.isEmpty() && firstName.length() <20)
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("Fist name must be between 0-20 characters and not empty");
    }

    /**
     * Returns the value of the instance variable.
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Validates that the argument lastName is not empty and between 0-20 char, throws an IllegalArgumentException if it is.
     * @param lastName
     */
    public void setLastName(String lastName) {
        if (!lastName.isEmpty() && lastName.length() <20)
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("Last name must be between 0-20 characters and not empty");
    }

    /**
     * Returns the value of the instance variable.
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Validates that the argument address is not empty and between 0-30 char, throws an IllegalArgumentException if it is.
     * @param address
     */
    public void setAddress(String address) {
        if (!address.isEmpty() && address.length() <30)
            this.address = address;
        else
            throw new IllegalArgumentException("Address must be between 0-30 characters and not empty");
    }

    /**
     * Returns the value of the instance variable.
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Validates that the argument phoneNumber is not empty and between 0-12 char, throws an IllegalArgumentException if it is.
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.isEmpty() && phoneNumber.length() <= 12)
            this.phoneNumber = phoneNumber;
        else
            throw new IllegalArgumentException("Phone number must be between 0-12 characters and not empty");
    }

    /**
     * Returns the value of the instance variable.
     * @return
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Validates that the argument is birthday is after the present date, throws an IllegalArgumentException if it is.
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        if (!birthday.isAfter(LocalDate.now()))
            this.birthday = birthday;
        else
            throw new IllegalArgumentException("Birthdays cannot be in the future!");
    }

    /**
     * Returns the value of the instance variable.
     * @return
     */
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Override toString method
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

}//end of Contact
