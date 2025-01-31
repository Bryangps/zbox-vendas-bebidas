package com.zboxcross.bebida.entities.enums;

public enum PaymentMethod {

    PIX(1),
    CARTAO_CREDITO(2),
    CARTAO_DEBITO(3),
    DINHEIRO(4);

    private int code;

    private PaymentMethod(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

     public static PaymentMethod valueOf(int code){
        for (PaymentMethod value : PaymentMethod.values()){
            if (value.getCode() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
