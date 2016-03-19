import main.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by softi on 19.03.2016.
 */
@Configuration
@ComponentScan(basePackages = "main")
public class JavaConfig {

    @Bean
    public BigGun bigGun() {
        return new BigGun(205, 1200, 1500);
    }

    @Bean
    public MidGun midGun() {
        return new MidGun(120, 600, 500);
    }

    @Bean
    public Plane plane() {
        return new Plane("Hawataka", 500, 10, 200);
    }

    @Bean
    public Torpedo torpedo() {
        return new Torpedo("chemical", 1000, 10);
    }

    @Bean
    public Mine mine() {
        return new Mine(5000, 60, 250);
    }

    @Bean
    public Destroyer destroyer() {
        List<Torpedo> torpedos = new ArrayList<>();
        torpedos.add(torpedo());
        torpedos.add(torpedo());
        torpedos.add(torpedo());
        return new Destroyer("Terminator", 10000, 40, torpedos);
    }

    @Bean
    @Qualifier("epic")
    public EpicMachine epic() {
        List<BigGun> bigGuns = new ArrayList<>();
        bigGuns.add(bigGun());
        bigGuns.add(bigGun());
        bigGuns.add(bigGun());
        bigGuns.add(bigGun());
        return new EpicMachine("King 40000", 10000, bigGuns);
    }

    @Bean
    public Helicarier helicarier() {
        List<Plane> planes = new ArrayList<>();
        planes.add(plane());
        planes.add(plane());
        planes.add(plane());
        planes.add(plane());
        return new Helicarier("Shield", 5000, planes);
    }

    @Bean
    public Jackdaw jackdaw() {
        List<MidGun> midGuns = new ArrayList<>();
        midGuns.add(midGun());
        midGuns.add(midGun());
        midGuns.add(midGun());
        return new Jackdaw("Assassin", 1500, midGuns);
    }

    @Bean
    public Nautilus nautilus() {
        List<Mine> mines = new ArrayList<>();
        mines.add(mine());
        mines.add(mine());
        mines.add(mine());
        mines.add(mine());
        return new Nautilus("Nemo", mines, 4000, 60);
    }

    @Bean
    @Qualifier("qav")
    public QueenAnnVengeance qav() {
        List<BigGun> bigGuns = new ArrayList<>();
        bigGuns.add(bigGun());
        bigGuns.add(bigGun());
        return new QueenAnnVengeance("Black", 6666, bigGuns);
    }

    @Bean
    public Fleet fleet() {
        return new Fleet("Warhammer", new ArrayList<>());
    }
}
