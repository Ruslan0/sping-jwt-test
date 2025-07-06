package com.rsn.user.accounts.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "phone_data")
public class PhoneData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 13, unique = true)
    String phone;
}
