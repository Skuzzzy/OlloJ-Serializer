/**
 * Created by dan on 1/28/15.
 */
public class Olloj {

    static final String open = "<";
    static final String close = ">";
    static final String secondopen = "</";
    static final String endl = "\n";

    String objectName;
    ollojPair[] arguments;

    public Olloj(String objectName,ollojPair[] arguments)
    {
        this.objectName = objectName;
        this.arguments = arguments;
    }

    public String generateOllojString()
    {
        return generateOllojString(0);
    }

    public String generateOllojString(int tabDepth)
    {

        StringBuilder OllojContainer = new StringBuilder();
        OllojContainer.append(getTabFromLevel(tabDepth-1)+open + objectName + close + endl);
        for(ollojPair each : arguments)
        {
            if(each.containsOlloJ()) // Is an object
            {
                OllojContainer.append(getTabFromLevel(tabDepth+1)+each.getOlloj().generateOllojString(tabDepth + 1));
                OllojContainer.append(endl);
            }
            else // Contains a string
            {
                OllojContainer.append(getTabFromLevel(tabDepth+1)+open+each.getObjectName()+close);
                OllojContainer.append(each.getValue());
                OllojContainer.append(secondopen + each.getObjectName() + close);
                OllojContainer.append(endl);
            }

        }
        OllojContainer.append(getTabFromLevel(tabDepth)+secondopen+objectName+close);
        return OllojContainer.toString();
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
