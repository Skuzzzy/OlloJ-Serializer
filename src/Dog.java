/**
 * Created by dan on 1/28/15.
 */
public class Dog implements OlloJSerializable
{
    public int age = 5;
    public String name = "Faker";

    public OlloJ toOlloJ()
    {
        Cat catata = new Cat();

        OlloJPair[] chips = new OlloJPair[3];
        chips[0] = new OlloJPair("Age",String.valueOf(age));
        chips[1] = new OlloJPair("Name",name);
        chips[2] = new OlloJPair(catata);

        return new OlloJ(this.getClass().getName(),chips);
    }
}
