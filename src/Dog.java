/**
 * Created by dan on 1/28/15.
 */

// This class is trash and only was thrown together as a demonstration
public class Dog implements OlloJSerializable
{
    public int age = 5;
    public String name = "Faker";
    Cat catata = new Cat();

    public OlloJ toOlloJ()
    {
        OlloJPair[] arguments = {new OlloJPair("Age",String.valueOf(age)),new OlloJPair("Name",name),new OlloJPair(catata)};

        return new OlloJ(this.getClass().getName(),arguments);
    }
}
