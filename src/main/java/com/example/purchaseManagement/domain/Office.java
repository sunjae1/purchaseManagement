package com.example.purchaseManagement.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Office {

    @Id @GeneratedValue
    private Long id;

    private String name;//회사명

    private String registerNumber; //사업자 등록번호 : 214-88-13306
    private String ceo_name;
    private String business_type; //업태 : 업무형태, 예)도소매업, 제조업, 서비스업
    private String business_item; //업태 : 제조업, => 종목 : 자동차 부품, 가구, 전자기기

    private String zipcode;//우편번호
    private String address; //우선, 주소 전체 저장. 예)"서울 강동구 암사동 500-1 2층" 그대로 저장.
    private String cellphone; //핸드폰 번호 010-1111-2222
    private String pax_number; //팩스 번호 0504-123-4567(인터넷 팩스 특수케이스 가능)

    @Enumerated(EnumType.STRING)
    private OfficeType type;

    //담당자들
    @OneToMany(mappedBy = "office")
    private List<Member> members = new ArrayList<>();

    private LocalDate transactionDate;
    private String memo;

    @OneToMany(mappedBy = "office")
    private List<Item> items = new ArrayList<>();


    //연관관계 편의 메소드 One에서 주로 만듬.
    public void addMember(Member member) {
        members.add(member);
        member.setOffice(this);
    }

    public void removeMember(Member member) {
        members.remove(member);
        member.setOffice(null);
    }

    public void addItem(Item item) {
        items.add(item);
        item.setOffice(this);
    }
    public void removeItem(Item item) {
        items.remove(item);
        item.setOffice(null);
    }

}
