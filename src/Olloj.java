/**
 * Created by dan on 1/28/15.
 */
public class Olloj {

    // String constants used in constructing the serialization
    static final String open = "<";
    static final String close = ">";
    static final String secondopen = "</";
    static final String endl = "\n";

    // Objectname contains all the arguments
    String objectName;
    OllojPair[] arguments;

    public Olloj(String objectName,OllojPair[] arguments)
    {
        this.objectName = objectName;
        this.arguments = arguments;
    }

    // If someone trys to generate an OllojString, they want it to start at 0 tabs
    public String generateOllojString()
    {
        return generateOllojString(0);
    }

    // Recursively generates the OllojString by iterating through the arguments
    // Appends the tabDepth to the front of the current string in order to keep structure indented properly
    public String generateOllojString(int tabDepth)
    {

        StringBuilder OllojContainer = new StringBuilder();

        // Creates the main object container for the current Olloj
        // tabDepth-1 is used as when recursively getting objects, we want them to be printed with one less tab than their members
        OllojContainer.append(getTabFromLevel(tabDepth-1)+open + objectName + close + endl);
        for(OllojPair each : arguments)
        {
            if(each.containsOlloJ()) // Contains an object
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
        // Finally append the closing object container for the current Olloj
        OllojContainer.append(getTabFromLevel(tabDepth)+secondopen+objectName+close);
        return OllojContainer.toString();
    }

    public String getTabFromLevel(int level)
    {
        //First Level object opener will have a tabDepth of -1. We actually want it to have a tabDepth of 0
        if(level == -1)
        {
            level = 0;
        }
        // Creates a character array containing only null characters of a certain length, then replaces those with tabs, and concatenates them as a string
        return new String(new char[level]).replace("\0", "\t");
    }
}
