package com.company.Model;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Bestellung {
    private UUID id;
    private String adresse;
    private List<Produkt> produktList;

    public Bestellung(UUID id, String adresse, List<Produkt> produktList) {
        this.id = id;
        this.adresse = adresse;
        this.produktList = produktList;
    }

    public Bestellung(String adresse, List<Produkt> produktList) {
        this.adresse = adresse;
        this.produktList = produktList;
        this.id=UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Produkt> getProduktList() {
        return produktList;
    }

    public void setProduktList(List<Produkt> produktList) {
        this.produktList = produktList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bestellung)) return false;
        Bestellung that = (Bestellung) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getAdresse(), that.getAdresse()) && Objects.equals(getProduktList(), that.getProduktList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAdresse(), getProduktList());
    }

    @Override
    public String toString() {
        return "Bestellung{" +
                "id=" + id +
                ", adresse='" + adresse + '\'' +
                ", produktList=" + produktList +
                '}';
    }
}
