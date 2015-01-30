/**
 * Created by dan on 1/29/15.
 */
public class OllojContainer implements OllojSerializable{
    String structureName;
    OllojPair[] members;

    public OllojContainer(String structureName,OllojPair[] members)
    {
        this.structureName = structureName;
        this.members = members;
    }

    public Olloj toOlloj()
    {
        return new Olloj(structureName,members);
    }
}
