/**
 * Created by dan on 1/28/15.
 */

// This class is trash and only was thrown together as a demonstration
public class Cat implements OlloJSerializable
{
    public int age = 200;
    public String name = "Muffins";

    public OlloJ toOlloJ()
    {
        OlloJPair[] arguments = {new OlloJPair("Age",String.valueOf(age)),new OlloJPair("Name",name)};

        return new OlloJ(this.getClass().getName(),arguments);
    }
}
