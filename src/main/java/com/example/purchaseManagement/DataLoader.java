package com.example.purchaseManagement;

import com.example.purchaseManagement.domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataLoader {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void loadTest() {
        //카테고리 생성
        Category category = new Category();
        category.setName("전자제품");
        em.persist(category); //DB에 저장.
        
        //아이템 생성
        Item item = new Item();
        item.setProduct_code("001-004"); //제품 코드
//        item.setCategory(category);
        item.setName("테스트1 아이템");
        item.setSpec(13);
        item.setUnit(Unit.KG);
        item.setBaseStock(100); //원래 재고
        item.setPurchasePrice(10000);
        item.setPurchaseTax(Taxtype.Taxable);
        item.setSalesPrice(15000);
        item.setSalesTax(Taxtype.Taxable);
        item.setTransactionDate(LocalDate.now());
        item.setMemo("비고에 메모중");

        em.persist(item); //DB에 저장

        //카테고리에 아이템 저장
        category.addItem(item);


        //멤버 생성
        Member vendor_member = new Member();
        vendor_member.setName("거래처 박대표");
        vendor_member.setType(MemberType.PARTNER);

        Member our_member = new Member();
        our_member.setName("우리 박대표");
        our_member.setType(MemberType.OUR);

        em.persist(vendor_member);
        em.persist(our_member);

        //우리회사 생성.
        Office our_office = new Office();
        our_office.setType(OfficeType.OUR_COMPANY);
        our_office.setRegisterNumber("123-111-111-111");//사업자 등록번호.
        our_office.setName("사과주식회사");
        our_office.setCeo_name("사과사장");
        our_office.setBusiness_type("제조업");
        our_office.setBusiness_item("자동차 부품"); //우선 한개만 저장.
        our_office.setAddress("서울 강동구 서초대로 12-1 2층");
        our_office.setZipcode("112-1111");
        our_office.setCellphone("010-1111-1111");
        our_office.setPax_number("567-9999");
        our_office.setTransactionDate(LocalDate.now()); //거래 시작일.
        our_office.setMemo("메모중.");

        em.persist(our_office);

        //거래처 회사 등록
        Office partner1 = new Office();
        partner1.setType(OfficeType.VENDOR); // 나중에 용어 통일.
        partner1.setRegisterNumber("222-111-111-111");  //사업자 등록번호.
        partner1.setName("배낭주식회사");
        partner1.setCeo_name("배낭사장");
        partner1.setBusiness_type("도소매업");
        partner1.setBusiness_item("의류"); //우선 한개만 저장.
        partner1.setAddress("서울 강동구 서초대로 12-1 2층");
        partner1.setZipcode("222-1111");
        partner1.setCellphone("010-2222-2222");
        partner1.setPax_number("111-2222");
        partner1.setTransactionDate(LocalDate.now()); //거래 시작일.
        partner1.setMemo("메모중.");

//        partner1.setItem(item);

        em.persist(partner1);


        //우리 회사 측 담당자 지정.(더디 체킹)
        our_office.addMember(our_member);
        partner1.addMember(vendor_member);

        //회사에 아이템 등록
        partner1.addItem(item);








    }
}
