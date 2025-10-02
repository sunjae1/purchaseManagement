package com.example.purchaseManagement.repository;

import com.example.purchaseManagement.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ItemRepository {

    @PersistenceContext
    private EntityManager em;

    //저장 (persist -> INSERT)
    public void save(Item item) {
        em.persist(item);
    }

    //수정 (merge -> UPDATE)
    public Item update(Item item) {
        return em.merge(item);
    }


}
