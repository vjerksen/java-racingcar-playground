package racing;

import java.util.Random;

public class RandomMaker {

    public Random random;

    public RandomMaker() {
        this.random = new Random(System.currentTimeMillis());
    }

    public boolean moveOrNot() {
        if (random.nextInt() % 2 == 0) {
            return true;
        }
        return false;
    }
}
