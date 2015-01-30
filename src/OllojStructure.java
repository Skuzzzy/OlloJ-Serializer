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

    // This method just assumes the person calling it will be reasonable and input a correct member name
    // Right now it just gets the first member with that name
    public OllojStructure getMember(String memberName)
    {
        int openingIndex = fullStructure.indexOf(Olloj.open+memberName+Olloj.close);

        int endOpeningIndex = fullStructure.indexOf(Olloj.secondopen+memberName+Olloj.close);
        int endClosingIndex = fullStructure.indexOf(Olloj.close,endOpeningIndex);

        return new OllojStructure(fullStructure.substring(openingIndex,endClosingIndex+1));
    }

    public OllojStructure[] getMembers(String memberName)
    {
        int currentSearchIndex = 0;
        ArrayList<OllojStructure> members = new ArrayList<OllojStructure>();

        while(fullStructure.indexOf(Olloj.open+memberName+Olloj.close,currentSearchIndex) >= 0)
        {
            int openingIndex = fullStructure.indexOf(Olloj.open+memberName+Olloj.close,currentSearchIndex);

            int endOpeningIndex = fullStructure.indexOf(Olloj.secondopen+memberName+Olloj.close,currentSearchIndex);
            int endClosingIndex = fullStructure.indexOf(Olloj.close,endOpeningIndex);
            members.add(new OllojStructure(fullStructure.substring(openingIndex,endClosingIndex+1)));

            currentSearchIndex = endClosingIndex+1;
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
