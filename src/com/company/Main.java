package com.company;

import com.company.Controller.Controller;
import com.company.Model.Bestellung;
import com.company.Model.Produkt;
import com.company.Repository.BestellungRepo;
import com.company.Repository.ProduktRepo;
import com.company.View.View;

import java.util.ConcurrentModificationException;

public class Main {

    public static void main(String[] args) {
        BestellungRepo bestellungRepo=new BestellungRepo();
        ProduktRepo produktRepo=new ProduktRepo();
        Controller controller=new Controller(produktRepo, bestellungRepo);
        View view=new View(controller);
        view.run();
    }
}
