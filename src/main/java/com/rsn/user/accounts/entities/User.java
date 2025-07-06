package com.rsn.user.accounts.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String name;
    private LocalDate dateOfBirth;
    @Column(length = 500)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id" )
    private Account account;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<EmailData> emailData = new HashSet<EmailData>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Set<PhoneData> phoneData = new HashSet<PhoneData>();
}
