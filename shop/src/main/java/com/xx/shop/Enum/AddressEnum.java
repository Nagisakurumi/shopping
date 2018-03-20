package com.xx.shop.Enum;

public enum AddressEnum {
    NoDefault(0,"不是默认地址"), Default(1,"默认地址");
    int value;
    String name;

    AddressEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
