/**
 * Created by dan on 1/28/15.
 */

// This class is trash and only was thrown together as a demonstration
public class Cat implements OllojSerializable
{
    public int age;
    public String name;

    public Cat()
    {
        age = 200;
        name = "Muffins";
    }


    public Olloj toOlloj()
    {
        OllojPair[] arguments = {new OllojPair("Age",String.valueOf(age)),new OllojPair("Name",name)};

        return new Olloj(this.getClass().getName(),arguments);
    }
}
