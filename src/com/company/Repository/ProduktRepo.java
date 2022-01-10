package com.company.Repository;

import com.company.Model.Produkt;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProduktRepo implements CrudRepo<Produkt> {
    private List<Produkt>produktList;

    public ProduktRepo() {
        this.produktList = new ArrayList<>();
    }

    @Override
    public Produkt findOne(@NotNull UUID id) {
        return this.produktList
                .stream()
                .filter(produkt -> produkt.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Produkt> findAll() {
        return this.produktList;
    }

    @Override
    public Produkt save(@NotNull Produkt entity) {
        if(this.findOne(entity.getId())==null) {
            this.produktList.add(entity);
            return null;
        }
        return entity;
    }

    @Override
    public Produkt delete(@NotNull UUID id) {
        Produkt produkt=this.findOne(id);
        if(produkt!=null){
            this.produktList.remove(produkt);
        }
        return produkt;
    }

    @Override
    public Produkt update(@NotNull Produkt entity) {
        if (this.produktList.stream().filter(produkt -> produkt.getId() == entity.getId()).map(produkt -> entity).anyMatch(produkt -> true)) {
            return null;
        }
        return entity;
    }
}
