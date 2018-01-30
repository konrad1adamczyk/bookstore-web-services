package com.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class UserPayment implements Serializable {

    private static final long serialVersionUID = 78091345L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String type;
    private String cardName;
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvc;
    private String holderName;
    private boolean defaultPayment;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @OneToOne(cascade=CascadeType.ALL, mappedBy = "userPayment")
    private UserBilling userBilling;
}
