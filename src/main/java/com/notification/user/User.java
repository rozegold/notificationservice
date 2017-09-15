package com.notification.user;

public class User {

    private String id;
    private String active;
    private String dispatchingOption;
    private String email;
    private String phone;

    public User(String id, String active, String dispatchingOption, String email, String phone) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.dispatchingOption = dispatchingOption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDispatchingOption() {
        return dispatchingOption;
    }

    public void setDispatchingOption(String dispatchingOption) {
        this.dispatchingOption = dispatchingOption;
    }
}
