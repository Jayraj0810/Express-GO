package com.cpimca.Mylibrary;

public class UserModel {

    private String firstname,lastname,mobile,signupEmail,signupPassword;

    public UserModel() {
    }

    public UserModel(String firstname, String lastname, String mobile, String signupEmail, String signupPassword) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
        this.signupEmail = signupEmail;
        this.signupPassword = signupPassword;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSignupEmail() {
        return signupEmail;
    }

    public void setSignupEmail(String signupEmail) {
        this.signupEmail = signupEmail;
    }

    public String getSignupPassword() {
        return signupPassword;
    }

    public void setSignupPassword(String signupPassword) {
        this.signupPassword = signupPassword;
    }
}
