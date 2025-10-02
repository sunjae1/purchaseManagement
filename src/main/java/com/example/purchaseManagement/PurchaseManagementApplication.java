package com.example.purchaseManagement;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PurchaseManagementApplication {

    private final DataLoader dataLoader;

    public PurchaseManagementApplication(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    public static void main(String[] args) {
		SpringApplication.run(PurchaseManagementApplication.class, args);
	}


    //DI 주입 후, 테스트 데이터 입력.
    @PostConstruct
    public void init() {
        dataLoader.loadTest();
    }
}
