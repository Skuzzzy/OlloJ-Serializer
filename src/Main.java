public class Main {

    public static void main(String[] args) {
        Dog chips = new Dog();
        //System.out.println(chips.toOlloj().generateOllojString());
        //OllojStructure kek = new OllojStructure(chips.toOlloj().generateOllojString());

        //System.out.println(kek.getInternalStructure());
        //System.out.println(kek.getMember("Age").getInternalStructure());
        //OllojStructure[] wohoo  = kek.getMembers("Toy");
        //for(OllojStructure q : wohoo)
        //{
        //    System.out.println(q.getInternalStructure());
        //}

        OllojStructure asd = new OllojStructure(chips.toOlloj().generateOllojString());
        Dog max = new Dog(asd);

        System.out.println(max.toOlloj().generateOllojString());
    }
}
