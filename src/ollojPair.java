/**
 * Created by dan on 1/28/15.
 */
public class ollojPair {

    String objectName;
    String value;

    private OllojSerializable ollojValue;
    private boolean containsOlloj;

    public ollojPair(String objectName,String value)
    {
        this.objectName = objectName;
        this.value = value;
        containsOlloj = false;
    }

    public ollojPair(OllojSerializable OlloJObj)
    {
        this.objectName = OlloJObj.getClass().getName();
        this.ollojValue = OlloJObj;
        containsOlloj = true;
    }
    public String getObjectName()
    {
        return objectName;
    }
    public String getValue()
    {
        return value;
    }

    public boolean containsOlloJ()
    {
        return containsOlloj;
    }
    public Olloj getOlloj()
    {
        return ollojValue.toOlloj();
    }
}
