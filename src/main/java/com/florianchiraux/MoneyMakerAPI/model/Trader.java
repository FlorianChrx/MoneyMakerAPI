package com.florianchiraux.MoneyMakerAPI.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Trader {
    @Id
    private String id;

    public Trader(String id) {
        this.id = id;
    }

    public Trader() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trader)) return false;
        Trader trader = (Trader) o;
        return getId().equals(trader.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
