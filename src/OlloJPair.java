/**
 * Created by dan on 1/28/15.
 */
public class OlloJPair {

    String objectName;
    String value;

    private OlloJSerializable OlloJvalue;
    private boolean containsOlloJ;

    public OlloJPair(String objectName,String value)
    {
        this.objectName = objectName;
        this.value = value;
        containsOlloJ = false;
    }

    public OlloJPair(OlloJSerializable OlloJObj)
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
