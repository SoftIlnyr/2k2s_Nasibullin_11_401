/**
 * Created by Ilnyr on 12.02.2016.
 */
public interface Scout extends Warship{
    void scoutPoint(int x, int y);

    void boarding(Warship warship);

    void smoke();
}
