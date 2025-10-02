package com.example.purchaseManagement;

import com.example.purchaseManagement.domain.Category;
import com.example.purchaseManagement.domain.Item;
import com.example.purchaseManagement.domain.Taxtype;
import com.example.purchaseManagement.domain.Unit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

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
        item.setProduct_code("ITEM-A1");
        item.setCategory(category);
        item.setName("테스트1 아이템");
        item.setSpec(13);
        item.setUnit(Unit.KG);
        item.setBaseStock(100); //원래 재고
        item.setPurchasePrice(10000);
        item.setPurchaseTax(Taxtype.Taxable);
        item.setSalesPrice(15000);
        item.setSalesTax(Taxtype.Taxable);
        item.setTransactionDate(LocalDate.now());
        item.setMemo("테스트용");
        
        em.persist(item); //DB에 저장
        
    }
}
