package pageObjects.business;

import pageObjects.enums.*;

public class Plate
{

    public Odds odds;
    public Even even;
    public NaturalElements naturalElements;
    public Colors colors;
    public Metals metals;
    public Food food;

    public Plate(Odds odds, Even even, NaturalElements naturalElements, Colors colors, Metals metals, Food food) {
        this.odds = odds;
        this.even = even;
        this.naturalElements = naturalElements;
        this.colors = colors;
        this.metals = metals;
        this.food = food;
    }
}
