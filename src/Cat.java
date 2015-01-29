/**
 * Created by dan on 1/28/15.
 */
public class Cat implements OlloJSerializable
{
    public int age = 200;
    public String name = "Muffins";

    public OlloJ toOlloJ()
    {
        OlloJPair[] chips = new OlloJPair[2];
        chips[0] = new OlloJPair("Age",String.valueOf(age));
        chips[1] = new OlloJPair("Name",name);

        return new OlloJ("Cat",chips);
    }
}
