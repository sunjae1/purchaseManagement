package com.example.purchaseManagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Item {

    @Id @GeneratedValue
    private Long id;

    String product_code; //"ITEMA-1"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String name;
    private Integer spec; //규격 12 13 14호 ?

    @Enumerated(EnumType.STRING)
    private Unit unit; // G, KG

    private Integer baseStock; //기초 재고

    @OneToMany(mappedBy = "item")
    private List<Vendor> vendor; //공급처

    private Integer purchasePrice; //매입 단가(순수 단가)

    @Enumerated(EnumType.STRING)
    private Taxtype purchaseTax; //매입 단가 세금 타입.

    private Integer salesPrice; //매출 단가

    @Enumerated(EnumType.STRING)
    private Taxtype salesTax; //매출 단가 세금 타입.

    private LocalDate transactionDate; // 거래일자

    private String memo;




}
