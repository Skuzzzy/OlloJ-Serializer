/**
 * Created by dan on 1/28/15.
 */
public class OllojPair {

    private String objectName;

    // The pair value will either be a string or an OllojSerializable object
    private String value;
    private OllojSerializable ollojValue;

    // When the olloJPair is constructed, this is set to indicate if the pair is (String,String) or (String,OllojSerializable)
    private boolean containsOlloj;

    // (String,String)
    public OllojPair(String objectName,String value)
    {
        this.objectName = objectName;
        this.value = value;
        containsOlloj = false;
    }

    // (String,OllojSerializable)
    // String is generated from the OllojSerializable object class name
    public OllojPair(OllojSerializable OlloJObj)
    {
        this.objectName = OlloJObj.getClass().getName();
        this.ollojValue = OlloJObj;
        containsOlloj = true;
    }

    public String getObjectName()
    {
        return objectName;
    }

    // Get the String value the pair contains, throws error if it contains an OllojObject instead
    public String getValue()
    {
        if(!containsOlloj)
        {
            return value;
        }
        else
        {
            throw new NullPointerException("Trying to access a String value of ollojPair when it is a OllojSerializable");
        }
    }
    // Get the OllojObject value the pair contains, throws error if it contains an String instead
    public Olloj getOlloj()
    {
        if(containsOlloj)
        {
            return ollojValue.toOlloj();
        }
        else
        {
            throw new NullPointerException("Trying to access a OllojSerializable value of ollojPair when it is a String");
        }
    }

    // Boolean to check which pairing type the pair is so we don't try to read null objects
    public boolean containsOlloJ()
    {
        return containsOlloj;
    }

}
