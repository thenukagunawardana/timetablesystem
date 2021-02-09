package com.eea.timetablesystem.DTO;

public class UserRegistrationDto
{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String Role;

    public UserRegistrationDto()
    {

    }

    public UserRegistrationDto(String firstName, String lastName, String email, String password,String Role) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.Role=Role;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole()
    {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
