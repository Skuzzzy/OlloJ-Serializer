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

    private String generateInternalStructure(String fullStructure)
    {
        int openingIndex = fullStructure.indexOf(Olloj.open);
        int closingIndex = fullStructure.indexOf(Olloj.close);

        this.structureName = fullStructure.substring(openingIndex+1,closingIndex);

        int endOpeningIndex = fullStructure.indexOf(Olloj.secondopen+structureName + Olloj.close);

        return fullStructure.substring(closingIndex+1,endOpeningIndex);
    }

    // This method assumes the person calling it will input a correct member name
    // This will return the first member with that name
    // The user will call this method when they assume there is only one member with the particular name
    public OllojStructure getMember(String memberName)
    {
        // Utilize getMemberFromIndex and find the first instance of the name (starting search at index 0)
        return getMemberFromIndex(memberName,0);
    }

    public OllojStructure getMemberFromIndex(String memberName, int searchIndex)
    {
        int depth = 0; // Depth is incremented when we go into a structure of the same name, and decremented when we leave that structure. This protects against nested structures of the same name
        int structureOpeningIndex = fullStructure.indexOf(Olloj.open+memberName+Olloj.close,searchIndex);
        searchIndex = structureOpeningIndex + 1;

        while(searchIndex<fullStructure.length()) // while(true) but without the out of index search, this loop should never be left as the only return statement is within itself
        {
            int possibleNestedIndex = fullStructure.indexOf(Olloj.open+memberName+Olloj.close,searchIndex); //Index of next opening
            int closingIndex = fullStructure.indexOf(Olloj.secondopen+memberName+Olloj.close,searchIndex); // Index of next closing

            // (We found another opening index with the same name) && (It comes before the expected closing index)
            if((possibleNestedIndex > 0) && (possibleNestedIndex < closingIndex))
            {
                depth++; // We are now in a nested search
                searchIndex = possibleNestedIndex + 1; // Move search index past the nested index
            }
            else // The next closing index is before the (possibly not existing) opening index
            {
                // If depth is 0, it means we have found an opening tag and are not in any structure
                if(depth == 0)
                {
                    int endClosingIndex = fullStructure.indexOf(Olloj.close,closingIndex + 1);

                    // This is the only exit point for this method without throwing an error
                    return new OllojStructure(fullStructure.substring(structureOpeningIndex,endClosingIndex+1));
                }
                depth--;
                searchIndex = closingIndex + 1; // Move search index past the closing index
            }
        }

        //We couldn't find a starting and ending index of a structure with that name
        throw new NullPointerException("Can't find the closing brace for a structure");
    }

    // This method assumes the person calling it will input a correct member name
    // Utilizes multiple calls to getMemberFromIndex in order to achieve it's goal
    public OllojStructure[] getMembers(String memberName)
    {
        // Start at the start of the structure
        int currentSearchIndex = 0;

        // Utilize an ArrayList then convert to array at end because we have no idea how many items we are going to find
        ArrayList<OllojStructure> members = new ArrayList<OllojStructure>();

        while(fullStructure.indexOf(Olloj.open+memberName+Olloj.close,currentSearchIndex) > 0)
        {
            int openingIndex = fullStructure.indexOf(Olloj.open+memberName+Olloj.close,currentSearchIndex);
            members.add(getMemberFromIndex(memberName,openingIndex));
            currentSearchIndex = openingIndex + members.get(0).getFullStructure().length(); // Move search index to after a structure we have already found
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

}
