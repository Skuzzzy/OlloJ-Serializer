/**
 * Created by dan on 1/28/15.
 */
public class ollojPair {

    String objectName;
    String value;

    private OllojSerializable OlloJvalue;
    private boolean containsOlloJ;

    public ollojPair(String objectName,String value)
    {
        this.objectName = objectName;
        this.value = value;
        containsOlloJ = false;
    }

    public ollojPair(OllojSerializable OlloJObj)
    {
        this.objectName = OlloJObj.getClass().getName();
        this.OlloJvalue = OlloJObj;
        containsOlloJ = true;
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
        return containsOlloJ;
    }
    public OlloJ getOlloJ()
    {
        return OlloJvalue.toOlloJ();
    }
}
