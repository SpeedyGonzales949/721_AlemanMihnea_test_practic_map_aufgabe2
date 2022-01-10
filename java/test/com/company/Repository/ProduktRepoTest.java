package com.company.Repository;

import com.company.Model.Produkt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProduktRepoTest {

    ProduktRepo produktRepo;
    Produkt produkt,produkt1,produkt2;
    @BeforeEach
    void setUp() {
        this.produktRepo=new ProduktRepo();
        this.produkt=new Produkt("produs1",30);
        this.produkt1=new Produkt("produs2",30);
        this.produkt2=new Produkt("produs3",30);

    }

    @Test
    void findOne() {
        produktRepo.save(produkt);
        assert(produktRepo.findOne(produkt.getId())==produkt);//check for already existing id in repo
        assert(produktRepo.findOne(UUID.randomUUID())==null);//check for not existing id in repo

    }

    @Test
    void save() {
        assert(produktRepo.save(produkt)==null);//check for unsaved entity
        assert(produktRepo.save(produkt)==produkt);//check for already saved entity
        assert(produktRepo.save(produkt1)==null);//check for unsaved entity
        assert(produktRepo.save(produkt1)==produkt1);//check for already saved entity

    }

    @Test
    void delete() {
        produktRepo.save(produkt);

        assert(this.produktRepo.delete(produkt.getId())==produkt);//check for deleting exisiting object
        assert(this.produktRepo.delete(UUID.randomUUID())==null);//check for deleting not existing object
    }

    @Test
    void update() {
        assert produktRepo.update(produkt)==produkt;//check for updating non existing object
        produktRepo.save(produkt);
        produkt.setName("alt Produs");
        assert produktRepo.update(produkt)==null;//check for updating exsting object
        assert produktRepo.save(produkt)==produkt;
        assert produktRepo.update(produkt1)==produkt1;
    }
}