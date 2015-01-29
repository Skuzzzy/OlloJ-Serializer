/**
 * Created by dan on 1/28/15.
 */
public class OlloJ {

    static final String open = "<";
    static final String close = ">";
    static final String secondopen = "</";
    static final String endl = "\n";

    String objectName;
    OlloJPair[] arguments;

    public OlloJ(String objectName,OlloJPair[] arguments)
    {
        this.objectName = objectName;
        this.arguments = arguments;
    }

    public String generateOlloJString()
    {
        return generateOlloJString(0);
    }

    public String generateOlloJString(int tabDepth)
    {

        StringBuilder OlloJContainer = new StringBuilder();
        OlloJContainer.append(getTabFromLevel(tabDepth-1)+open + objectName + close + endl);
        for(OlloJPair each : arguments)
        {
            if(each.containsOlloJ()) // Is an object
            {
                OlloJContainer.append(getTabFromLevel(tabDepth+1)+each.getOlloJ().generateOlloJString(tabDepth+1));
                OlloJContainer.append(endl);
            }
            else // Contains a string
            {
                OlloJContainer.append(getTabFromLevel(tabDepth+1)+open+each.getObjectName()+close);
                OlloJContainer.append(each.getValue());
                OlloJContainer.append(secondopen+each.getObjectName()+close);
                OlloJContainer.append(endl);
            }

        }
        OlloJContainer.append(getTabFromLevel(tabDepth)+secondopen+objectName+close);
        return OlloJContainer.toString();
    }

    public String getTabFromLevel(int level)
    {
        if(level == -1) //First Level object opener will have a tab depth of -1 (I should probably fix this but heck it works)
        {
            level = 0;
        }
        return new String(new char[level]).replace("\0", "\t");
    }
}
