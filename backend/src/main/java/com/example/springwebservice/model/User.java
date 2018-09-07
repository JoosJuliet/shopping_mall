package com.example.springwebservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.OneToMany;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;


    @Column(name = "jsonWebToekn")
    private String jsonWebToken;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Collection<PurchaseHistory> purchaseHistory;
    public void addPurchase(PurchaseHistory purchase){
        if(purchaseHistory == null){
            purchaseHistory = new ArrayList<PurchaseHistory>();
        }
        purchaseHistory.add(purchase);
    }



    public User(String name) {
        this.name = name;
    }
    public User(String name, String jsonWebToken, String userName, String password, String phoneNumber) {
        this.password = password;
        this.userName = userName;
        this.jsonWebToken = jsonWebToken;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }


}

