/**
 * Created by dan on 1/28/15.
 */

// This class is trash and only was thrown together as a demonstration
public class Cat implements OllojSerializable
{
    public int age = 200;
    public String name = "Muffins";

    public Olloj toOlloj()
    {
        ollojPair[] arguments = {new ollojPair("Age",String.valueOf(age)),new ollojPair("Name",name)};

        return new Olloj(this.getClass().getName(),arguments);
    }
}
