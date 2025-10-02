package com.example.purchaseManagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private MemberType type; //우리 회사, 거래처 인지.

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;




}
