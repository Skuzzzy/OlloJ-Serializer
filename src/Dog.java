/**
 * Created by dan on 1/28/15.
 */

// This class is trash and only was thrown together as a demonstration
public class Dog implements OllojSerializable
{
    public int age = 5;
    public String name = "Faker";
    Cat catata = new Cat();

    public Olloj toOlloj()
    {
        ollojPair[] arguments = {new ollojPair("Age",String.valueOf(age)),new ollojPair("Name",name),new ollojPair(catata)};

        return new Olloj(this.getClass().getName(),arguments);
    }
}
