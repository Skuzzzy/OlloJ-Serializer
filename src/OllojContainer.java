/**
 * Created by dan on 1/29/15.
 */
public class OllojContainer implements OllojSerializable{
    String structureName;
    OllojSerializable[] members;

    public OllojContainer(String structureName,OllojSerializable[] members)
    {
        this.structureName = structureName;
        this.members = members;
    }

    public Olloj toOlloj() //TODO
    {
        Olloj[] arguments = new Olloj[members.length];
        for(int index=0;index<members.length;index++)
        {
            arguments[index] = members[index].toOlloj(); // TODO
        }
        return arguments[0]; //TODO
    }
}
