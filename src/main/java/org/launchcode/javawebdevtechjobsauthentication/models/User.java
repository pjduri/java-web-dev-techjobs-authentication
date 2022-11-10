package org.launchcode.javawebdevtechjobsauthentication.models;

import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity {

    @NotNull
    @Size(min = 3, max = 55)
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User () {}

    public User(String username, String password) {
        super();
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public String getName() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
