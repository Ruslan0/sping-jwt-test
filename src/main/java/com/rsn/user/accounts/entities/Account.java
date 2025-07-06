package com.rsn.user.accounts.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="balance", precision=9, scale=2)
    @Range(min = 0)
    private BigDecimal balance;
}
