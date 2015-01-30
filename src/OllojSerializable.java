/**
 * Created by dan on 1/28/15.
 */
public interface OllojSerializable
{
    // return new Olloj(this.getClass().getName(),members);
    // where members is an array of OllojPair objects
    public Olloj toOlloj();
}
