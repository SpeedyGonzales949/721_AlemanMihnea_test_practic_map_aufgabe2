package com.company.Repository;

import com.company.Model.Bestellung;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BestellungRepo implements CrudRepo<Bestellung>{
    private List<Bestellung> bestellungList;

    public BestellungRepo() {
        this.bestellungList = new ArrayList<>();
    }

    @Override
    public Bestellung findOne(@NotNull UUID id) {
        return this.bestellungList
                .stream()
                .filter(bestellung -> bestellung.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Bestellung> findAll() {
        return this.bestellungList;
    }

    @Override
    public Bestellung save(@NotNull Bestellung entity) {
        if(this.findOne(entity.getId())==null) {
            this.bestellungList.add(entity);
            return null;
        }
        return entity;
    }

    @Override
    public Bestellung delete(@NotNull UUID id) {
        Bestellung bestellung=this.findOne(id);
        if(bestellung!=null){
            this.bestellungList.remove(bestellung);
        }
        return bestellung;
    }

    @Override
    public Bestellung update(@NotNull Bestellung entity) {
        if (this.bestellungList.stream().filter(bestellung -> bestellung.getId() == entity.getId()).map(bestellung -> entity).anyMatch(bestellung -> true)) {
            return null;
        }
        return entity;
    }
}
