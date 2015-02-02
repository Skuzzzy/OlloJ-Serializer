import olloj.Olloj;
import olloj.OllojPair;
import olloj.OllojSerializable;
import olloj.OllojStructure;

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

    public Cat(OllojStructure oj)
    {
        this.age = Integer.parseInt(oj.getMember("Age").getInternalStructure());
        this.name = oj.getMember("Name").getInternalStructure();
    }

    public Olloj toOlloj()
    {
        OllojPair[] arguments = {new OllojPair("Age",String.valueOf(age)),new OllojPair("Name",name)};

        return new Olloj(this.getClass().getName(),arguments);
    }
}
