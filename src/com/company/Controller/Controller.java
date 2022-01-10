package com.company.Controller;

import com.company.Model.Bestellung;
import com.company.Model.Produkt;
import com.company.Repository.BestellungRepo;
import com.company.Repository.ProduktRepo;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Controller {
    private ProduktRepo produktRepo;
    private BestellungRepo bestellungRepo;

    public Controller(ProduktRepo produktRepo, BestellungRepo bestellungRepo) {
        this.produktRepo = produktRepo;
        this.bestellungRepo = bestellungRepo;
    }

    public UUID addProdukt(String name, int preis){
        Produkt produkt=new Produkt(name,preis);
        if(this.produktRepo.save(produkt)==null){
            return produkt.getId();
        }
        return null;
    }

    public void deleteProdukt(String id){
        this.produktRepo.delete(UUID.fromString(id));
    }

    public List<Produkt> getProdukte(){
        return this.produktRepo.findAll();
    }
    public void updateProdukt(String id,String name,int preis){
        Produkt produkt=new Produkt(name, preis, UUID.fromString(id));
        this.produktRepo.update(produkt);
    }
    public Produkt findProdukt(String id){
        return this.produktRepo.findOne(UUID.fromString(id));
    }
    public UUID addBestellung(String adresse, List<Produkt> list){
        Bestellung bestellung=new Bestellung(adresse,list);
        if(this.bestellungRepo.save(bestellung)==null){
            return bestellung.getId();
        }
        return null;
    }
    public void deleteBestellung(String id){
        this.bestellungRepo.delete(UUID.fromString(id));
    }
    public  List<Bestellung> getBestellungen(){
        return this.bestellungRepo.findAll();
    }
    public void updateBestellung(String id,String adresse,List<Produkt>produktList){
        Bestellung bestellung=new Bestellung(UUID.fromString(id),adresse,produktList);
        this.bestellungRepo.update(bestellung);
    }
    public Bestellung findBestellung(String id){
        return this.bestellungRepo.findOne(UUID.fromString(id));
    }
    public List<Bestellung> filterbyProdukt(String produktid){
        return this.bestellungRepo
                .findAll()
                .stream()
                .filter(bestellung -> bestellung.getProduktList()
                        .stream()
                        .filter(produkt -> produktid.toString().equals(produktid))
                        .findFirst()
                        .isPresent())
                .collect(Collectors.toList());

    }
    public List<Bestellung> sortByGesamtpreis(){
        return this.bestellungRepo
                .findAll()
                .stream()
                .sorted(Comparator.comparing(bestellung ->
                        bestellung
                                .getProduktList()
                                .stream()
                                .map(produkt -> produkt.getPreis())
                                .collect(Collectors.summingInt(Integer::intValue))))
                .collect(Collectors.toList());
    }

}
