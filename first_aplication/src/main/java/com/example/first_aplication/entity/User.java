package com.example.first_aplication.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
public class User implements Serializable{

    private static final long serialVersionUID = -6833167247955613395L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native",strategy="native")
    private Long id;

    @Column
    @NotBlank
    private String firstName;
    @Column
    @NotBlank
    private String lastName;
    @Column(unique = true)
    @NotBlank
    private String email;
    @NotBlank
    @Column(unique = true)
    private String username;
    @NotBlank
    @Column
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns=@JoinColumn(name="users_id"),
            inverseJoinColumns=@JoinColumn(name="role_id"))
    private Set<Role> roles;

    public User() {	}

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, username, password, confirmPassword, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", roles=" + roles +
                '}';
    }
}