package com.zboxcross.bebida.entities.enums;

public enum OrderStatus {

    PENDING(1),
    PAID(2);

    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid orderStatus code");
    }
}
