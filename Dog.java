import java.util.ArrayList;
import java.util.Objects;

/**
 * Dog class with race, dog age counter and the array of the actual vaccines for dog.
 * Expired vaccine can be removed.
 * @author Jakub Modrzewski 297792
 * @author Hubert Świech 304527
 * @version 1.0.0
 */
public class Dog extends Pet {
    /**
     * The list of names of the vaccines for Dog.
     */

    private final ArrayList<String> vaccines  = new ArrayList<>();

    private String race = "Boxer";

    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * Simply counts dog's age based on human years
     * @return dog age
     */
    public int getDogAge() {
        return 5 * getAge();
    }

    /**
     * Adds the vaccine name to the array.
     * @param vaccineName the name of the vaccine to be added.
     */

    public void addVaccine(String vaccineName) {
        if(!vaccines.contains(vaccineName)) {
            vaccines.add(vaccineName);
        }
        else {
            throw new RuntimeException( getClass().getSimpleName() + " is already vaccinated by " + vaccineName + "!");
        }
    }

    /**
     * Removes the vaccine name from the array.
     * @param vaccineName the name of the vaccine to be expired
     */
    public void expireVaccine(String vaccineName) {
        if(vaccines.remove(vaccineName)) {
            System.out.print(vaccineName + " expired!");
        }
        else {
            throw new RuntimeException( getClass().getSimpleName() + "is not vaccinated by " + vaccineName + "!");
        }
    }

    public ArrayList<String> getVaccineNames() {
        return vaccines;
    }


    public Dog() {
        super("Saba", "brown", "female");
        getDogAge();
        setIsMammal(true);
        setCanFly(false);

    }

    @Override
    public String toString() {
        return super.toString() + " This " + getClass().getSimpleName() + " is " +
                "[race: " + getRace() + ", vaccines: " + getVaccineNames() + ", dog age: " + getDogAge()  + "]";
    }

    @Override
    public boolean equals(Object anObject) {
       if (this == anObject) return true;
       if (anObject instanceof Dog && super.equals(anObject)) {
           Dog other = (Dog) anObject;
           return getRace().equals(other.getRace()) && getVaccineNames().equals(other.getVaccineNames());
       }
       return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRace(), getVaccineNames());
    }

    /**
     * Test for the class
     * @param args no used
     */
    public static void main(String... args) {
        Dog d = new Dog();
        d.setAge(5);
        d.setRace("Bulldog");
        d.setWeight(30);
        d.eat();
        System.out.println(d);

        d.addVaccine("Astranezeca");
        System.out.println(d.getVaccineNames());

        d.addVaccine("Pfizer");
        System.out.println(d.getVaccineNames());

        d.addVaccine("Sputnik");
        System.out.println(d.getVaccineNames());

        d.expireVaccine("Astranezeca");
        System.out.println( d.getVaccineNames());


        Dog d2 = new Dog();
        System.out.println(d == d2);
        System.out.println(d.equals(d2));
        System.out.println(d2.equals(d));


    }

}