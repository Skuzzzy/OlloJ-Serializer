import java.util.ArrayList;

/**
 * Created by dan on 1/28/15.
 */

// This class is trash and only was thrown together as a demonstration
public class Dog implements OllojSerializable
{
    public int age = 5;
    public String name = "Faker";
    Cat catata = new Cat();
    ArrayList<String> toys;

    public Dog()
    {
        toys = new ArrayList<String>();
        toys.add("Ball");
        toys.add("Stick");
        toys.add("Sqeaky Ball");
        toys.add("Chips");
    }

    public Olloj toOlloj()
    {
        ArrayList<ollojPair> arguments = new ArrayList<ollojPair>();
        arguments.add(new ollojPair("Age",String.valueOf(age)));
        arguments.add(new ollojPair("Name",name));
        arguments.add(new ollojPair(catata));
        for(String s : toys)
        {
            arguments.add(new ollojPair("Toy",s));
        }

        ollojPair[] members = arguments.toArray(new ollojPair[arguments.size()]);

        return new Olloj(this.getClass().getName(),members);
    }
}
