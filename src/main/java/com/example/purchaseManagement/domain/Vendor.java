package com.example.purchaseManagement.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Vendor {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
