package com.example.springwebservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PurchaseHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;


    @Column(name = "user_id")
    private int userId;

    @Column(name = "item_id")
    private int itemId;



//    public PurchaseHistory(String name){
//        this.name = name;
//    }

    public PurchaseHistory(int userId, int itemId){
        this.userId = userId;
        this.itemId = itemId;
    }
}
