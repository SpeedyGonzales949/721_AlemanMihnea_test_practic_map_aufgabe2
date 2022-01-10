package com.company.Model;

import java.util.Objects;
import java.util.UUID;

public class Produkt {
    private String name;
    private int preis;
    private UUID id;

    public Produkt(String name, int preis, UUID id) {
        this.name = name;
        this.preis = preis;
        this.id = id;
    }

    public Produkt(String name, int preis) {
        this.name = name;
        this.preis = preis;
        this.id=UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produkt)) return false;
        Produkt produkt = (Produkt) o;
        return getPreis() == produkt.getPreis() && Objects.equals(getName(), produkt.getName()) && Objects.equals(getId(), produkt.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPreis(), getId());
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "name='" + name + '\'' +
                ", preis=" + preis +
                ", id=" + id +
                '}';
    }
}
