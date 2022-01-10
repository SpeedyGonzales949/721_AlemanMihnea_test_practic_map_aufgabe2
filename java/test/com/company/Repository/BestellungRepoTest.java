package com.company.Repository;

import com.company.Model.Bestellung;
import com.company.Model.Produkt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BestellungRepoTest {
    Produkt produkt,produkt1,produkt2;
    BestellungRepo bestellungRepo;
    Bestellung bestellung1,bestellung2,bestellung3;

    @BeforeEach
    void setUp() {
        this.produkt=new Produkt("produs1",30);
        this.produkt1=new Produkt("produs2",30);
        this.produkt2=new Produkt("produs3",30);

        this.bestellungRepo=new BestellungRepo();
        this.bestellung1=new Bestellung("Adresa1", Arrays.asList(produkt,produkt1,produkt2));
        this.bestellung2=new Bestellung("Adresa2", Arrays.asList(produkt,produkt1,produkt2));
        this.bestellung3=new Bestellung("Adresa3", Arrays.asList(produkt,produkt1,produkt2));


    }

    @Test
    void findOne() {
        bestellungRepo.save(bestellung1);
        assert(bestellungRepo.findOne(bestellung1.getId())==bestellung1);//check for already existing id in repo
        assert(bestellungRepo.findOne(UUID.randomUUID())==null);//check for not existing id in repo

    }

    @Test
    void save() {
        assert(bestellungRepo.save(bestellung1)==null);//check for unsaved entity
        assert(bestellungRepo.save(bestellung1)==bestellung1);//check for already saved entity
        assert(bestellungRepo.save(bestellung2)==null);//check for unsaved entity
        assert(bestellungRepo.save(bestellung2)==bestellung2);//check for already saved entity

    }

    @Test
    void delete() {
        bestellungRepo.save(bestellung1);

        assert(this.bestellungRepo.delete(bestellung1.getId())==bestellung1);//check for deleting exisiting object
        assert(this.bestellungRepo.delete(UUID.randomUUID())==null);//check for deleting not existing object

    }

    @Test
    void update() {
        assert bestellungRepo.update(bestellung1)==bestellung1;//check for updating non existing object
        bestellungRepo.save(bestellung1);
        bestellung1.setAdresse("alt Adresa");
        assert bestellungRepo.update(bestellung1)==null;//check for updating exsting object
        assert bestellungRepo.save(bestellung1)==bestellung1;
        assert bestellungRepo.update(bestellung2)==bestellung2;
    }
}