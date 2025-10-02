package com.example.purchaseManagement.domain;

import lombok.Getter;

@Getter
public enum Unit {
    G("그램"),
    KG("킬로그램");

    private final String displayName;

    Unit(String displayName) {
        this.displayName = displayName;
    }
}
