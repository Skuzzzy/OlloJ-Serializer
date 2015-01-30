public class Main {

    public static void main(String[] args) {
        Dog chips = new Dog();
        //System.out.println(chips.toOlloj().generateOllojString());
        OllojStructure kek = new OllojStructure(chips.toOlloj().generateOllojString());

        //System.out.println(kek.getInternalStructure());
        System.out.println(kek.getMember("Age").getInternalStructure());

    }
}
