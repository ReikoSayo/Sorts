package ru.netology.javaqa.javaqamvn.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    Ticket bilet1 = new Ticket("France", "Russia", 10_000, 3, 6);
    Ticket bilet2 = new Ticket("Germany", "Russia", 25_000, 2, 10);
    Ticket bilet3 = new Ticket("London", "Russia", 8_000, 10, 12);
    Ticket bilet4 = new Ticket("Italy", "Russia", 14_000, 4, 9);
    Ticket bilet5 = new Ticket("London", "Russia", 16_000, 5, 6);
    Ticket bilet6 = new Ticket("France", "Russia", 16_000, 1, 6);
    Ticket bilet7 = new Ticket("Germany", "Russia", 16_000, 4, 12);
    Ticket bilet8 = new Ticket("Germany", "France", 18_000, 4, 6);
    TicketTimeComparator comparator = new TicketTimeComparator();

    @BeforeEach
    void addTickets() {
        aviaSouls.add(bilet1);
        aviaSouls.add(bilet2);
        aviaSouls.add(bilet3);
        aviaSouls.add(bilet4);
        aviaSouls.add(bilet5);
        aviaSouls.add(bilet6);
        aviaSouls.add(bilet7);
        aviaSouls.add(bilet8);
    }

    @Test
    void findAllTest() {
        Ticket[] expected = {bilet1, bilet2, bilet3, bilet4, bilet5, bilet6, bilet7, bilet8};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchTest() {
        Ticket[] expected = {bilet3, bilet5};
        Ticket[] actual = aviaSouls.search("London", "Russia");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void compareToT2moreT1Test() {
        int expected = -1;
        int actual = bilet1.compareTo(bilet4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void compareToEqualTest() {
        int expected = 0;
        int actual = bilet5.compareTo(bilet6);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void compareToT1moreT2Test() {
        int expected = 1;
        int actual = bilet2.compareTo(bilet3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void searchAndSortByT1moreT2Test() {
        Ticket[] expected = {bilet5, bilet3};
        Ticket[] actual = aviaSouls.searchAndSortBy("London", "Russia", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchAndSortByT2moreT1Test() {
        Ticket[] expected = {bilet1, bilet6};
        Ticket[] actual = aviaSouls.searchAndSortBy("France", "Russia", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchAndSortByEqualTicketsTest() {
        Ticket[] expected = {bilet7, bilet2};
        Ticket[] actual = aviaSouls.searchAndSortBy("Germany", "Russia", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
