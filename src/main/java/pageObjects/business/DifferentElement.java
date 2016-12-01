package pageObjects.business;


import pageObjects.enums.Colors;
import pageObjects.enums.Metals;
import pageObjects.enums.NaturalElements;

public class DifferentElement
{
    public NaturalElements naturalElements;
    public Metals metals;
    public Colors colors;

    public DifferentElement(NaturalElements naturalElements, Metals metals, Colors colors) {
        this.naturalElements = naturalElements;
        this.metals = metals;
        this.colors = colors;
    }
}
