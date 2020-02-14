package com.registro.registroapp.service.builder.model;

import java.io.Serializable;

public class PhoneVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String number;
    private String citycode;
    private String contrycode;

    public PhoneVO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getContrycode() {
        return contrycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }
}
