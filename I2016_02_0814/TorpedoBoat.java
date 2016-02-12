package I2016_02_0814;

/**
 * Created by Ilnyr on 12.02.2016.
 */
public interface TorpedoBoat extends Warship {
    void addTorpedo(Torpedo torpedo);

    void launchTorpedoAngle(int x);

    void launchTorpedoTarget(Warship warship);
}
