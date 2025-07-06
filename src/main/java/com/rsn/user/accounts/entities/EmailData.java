package com.rsn.user.accounts.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "email_data")
public class EmailData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, unique = true)
    String email;
}
