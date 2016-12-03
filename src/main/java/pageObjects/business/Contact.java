package pageObjects.business;

import pageObjects.enums.Even;
import pageObjects.enums.Odds;

public class Contact
{

    public String name;
    public String lastName;
    public String description;
    public Odds highRadioButton;
    public Even lowRadioButton;

    public Contact(String name, String lastName, String description, Odds highRadioButton, Even lowRadioButton) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.highRadioButton = highRadioButton;
        this.lowRadioButton = lowRadioButton;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "'" + name + '\'' +
                ", '" + lastName + '\'' +
                ", '" + description + '\'' +
                ", " + highRadioButton +
                ", " + lowRadioButton +
                '}';
    }
}
