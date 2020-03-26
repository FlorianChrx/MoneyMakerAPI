package com.florianchiraux.MoneyMakerAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Trader {
    @Id
    private String id;
    @JsonIgnore
    private String pwd;

    public Trader(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public Trader() {}

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trader)) return false;
        Trader trader = (Trader) o;
        return getId().equals(trader.getId()) &&
                Objects.equals(getPwd(), trader.getPwd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPwd());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
