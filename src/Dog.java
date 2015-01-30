import java.util.ArrayList;

/**
 * Created by dan on 1/28/15.
 */

// This class is trash and only was thrown together as a demonstration
public class Dog implements OllojSerializable
{
    public int age;
    public String name;
    Cat catata;
    ArrayList<String> toys;

    public Dog()
    {
        age = 5;
        name = "Faker";
        catata = new Cat();

        toys = new ArrayList<String>();
        toys.add("Ball");
        toys.add("Stick");
        toys.add("Sqeaky Ball");
        toys.add("Chips");
    }

    public Dog(OllojStructure oj)
    {
        this.age = Integer.parseInt(oj.getMember("Age").getInternalStructure());
        this.name = oj.getMember("Name").getInternalStructure();

        OllojStructure[] ojToys = oj.getMembers("Toy");
        toys = new ArrayList<String>();
        for(OllojStructure toy : ojToys)
        {
            toys.add(toy.getInternalStructure());
        }

        this.catata = new Cat(oj.getMember("Cat"));
    }

    public Olloj toOlloj()
    {
        ArrayList<OllojPair> arguments = new ArrayList<OllojPair>();
        arguments.add(new OllojPair("Age",String.valueOf(age)));
        arguments.add(new OllojPair("Name",name));
        arguments.add(new OllojPair(catata));

        for(String s : toys)
        {
            arguments.add(new OllojPair("Toy",s));
        }

        OllojPair[] members = arguments.toArray(new OllojPair[arguments.size()]);

        return new Olloj(this.getClass().getName(),members);
    }
}
