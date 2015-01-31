import java.util.ArrayList;

/**
 * Created by dan on 1/30/15.
 */
public class OllojStructure
{
    String fullStructure;
    String internalStructure;

    String structureName;

    public OllojStructure(String fullStructure)
    {
        this.fullStructure = fullStructure;
        this.internalStructure = generateInternalStructure(fullStructure);
    }

    // This method assumes the person calling it will input a correct member name
    // This will return the first member with that name
    public OllojStructure getMember(String memberName)
    {
        return getMemberFromIndex(memberName,0);
    }

    public OllojStructure getMemberFromIndex(String memberName, int searchIndex)
    {
        int depth = 0;
        int structureOpeningIndex = fullStructure.indexOf(Olloj.open+memberName+Olloj.close,searchIndex);
        searchIndex = structureOpeningIndex + 1;

        while(searchIndex<fullStructure.length())
        {
            int possibleNestedIndex = fullStructure.indexOf(Olloj.open+memberName+Olloj.close,searchIndex);
            int closingIndex = fullStructure.indexOf(Olloj.secondopen+memberName+Olloj.close,searchIndex);

            if((possibleNestedIndex > 0) && (possibleNestedIndex < closingIndex)) // (We found another opening index with the same name) && (It comes before the expected closing index)
            {
                depth++; // We are now in a nested search
                searchIndex = possibleNestedIndex + 1; // Move search index past the nested index
            }
            else
            {
                if(depth>0)
                {
                    depth--;
                }

                searchIndex = closingIndex + 1; // Move search index past the closing index
            }

            if(depth == 0)
            {
                int endClosingIndex = fullStructure.indexOf(Olloj.close,searchIndex);
                return new OllojStructure(fullStructure.substring(structureOpeningIndex,endClosingIndex+1));
            }

        }

        throw new NullPointerException("Can't find the closing brace for a structure");
    }

    // This method assumes the person calling it will input a correct member name
    public OllojStructure[] getMembers(String memberName)
    {
        int currentSearchIndex = 0;
        ArrayList<OllojStructure> members = new ArrayList<OllojStructure>();

        while(fullStructure.indexOf(Olloj.open+memberName+Olloj.close,currentSearchIndex) > 0)
        {
            int openingIndex = fullStructure.indexOf(Olloj.open+memberName+Olloj.close,currentSearchIndex);
            members.add(getMemberFromIndex(memberName,openingIndex));
            currentSearchIndex = openingIndex+members.get(0).getFullStructure().length();
        }

        // Moving the ArrayList into an array for the return method
        OllojStructure[] membersArray = new OllojStructure[members.size()];
        for(int i=0;i<members.size();i++)
        {
            membersArray[i] = members.get(i);
        }

        return membersArray;
    }

    public String getInternalStructure()
    {
        return internalStructure;
    }

    public String getFullStructure()
    {
        return fullStructure;
    }

    public String getStructureName()
    {
        return structureName;
    }

    private String generateInternalStructure(String fullStructure)
    {
        int openingIndex = fullStructure.indexOf(Olloj.open);
        int closingIndex = fullStructure.indexOf(Olloj.close);

        this.structureName = fullStructure.substring(openingIndex+1,closingIndex);

        int endOpeningIndex = fullStructure.indexOf(Olloj.secondopen+structureName + Olloj.close);

        return fullStructure.substring(closingIndex+1,endOpeningIndex);
    }

}
