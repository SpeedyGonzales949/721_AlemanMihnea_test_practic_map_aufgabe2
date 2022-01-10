package com.company.View;

import com.company.Controller.Controller;

import java.util.Scanner;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);

        loop:
        while (true) {
            System.out.println("""
                     
                     0. Exit Program \r
                     1. Show all Products \r
                     2. Show all Bestellung \r
                     3. Add a Product \r
                     4. Add an Bestellung \r
                     5. Remove a Produkt \r
                     6. Remove an Bestellung \r
                     7. Update a Produkt \r
                     8. Update an Bestellung \r
                     9. Add Produkt  to Bestellung  \r
                     10. Get sortedBestellungen \r
                     11. Get Bestellung Filtered By Produkt \r
                    """);
            System.out.println("Enter input: ");
            int variant = scanner.nextInt();
            System.out.println("You've entered: " + variant);
            switch (variant) {
                case 0:
                    break loop;
                case 1:
                    showProdukt();
                    break;
                case 2:
                    showBestellung();
                    break;
                case 3:
                    addProdukt();
                    break;
                case 4:
                    addBestellung();
                    break;
                case 5:
                    deleteProdukt();
                    break;
                case 6:
                    deleteBestellung();
                    break;
                case 7:
                    updateProdukt();
                    break;
                case 8:
                    updateBestellung();
                    break;
                case 9:
                    addProdukttoBestellung();
                    break;
                case 10:
                    getSortedBestellungen();
                    break;
                case 11:
                    getFilteredByProdukt();
                    break;
            }

        }
    }

    private void getSortedBestellungen() {
        System.out.println(this.controller.sortByGesamtpreis());
    }

    private void addProdukttoBestellung() {
    }

    private void updateBestellung() {
    }

    private void updateProdukt() {
    }

    private void deleteBestellung() {
    }

    private void deleteProdukt() {
    }

    private void addBestellung() {
    }

    private void addProdukt() {
    }

    private void showBestellung() {
        System.out.println(this.controller.getBestellungen());
    }

    private void showProdukt() {
        System.out.println(this.controller.getProdukte());
    }
    private void getFilteredByProdukt(){

    }
}
