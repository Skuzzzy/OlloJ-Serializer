/**
 * Created by dan on 1/28/15.
 */
public class ollojPair {

     private String objectName;

    // The pair value will either be a string or an OllojSerializable object
    private String value;
    private OllojSerializable ollojValue;

    // When the olloJPair is constructed, this is set to indicate if the pair is (String,String) or (String,OllojSerializable)
    private boolean containsOlloj;

    // (String,String)
    public ollojPair(String objectName,String value)
    {
        this.objectName = objectName;
        this.value = value;
        containsOlloj = false;
    }

    // (String,OllojSerializable)
    // String is generated from the OllojSerializable object class name
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
        if(!containsOlloj)
        {
            return value;
        }
        else
        {
            throw new NullPointerException("Trying to access a String value of ollojPair when it is a OllojSerializable");
        }
    }
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

    public boolean containsOlloJ()
    {
        return containsOlloj;
    }

}
