package racing;

public class Car {
    public String carName;
    public int carPosition;

    public Car(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarPosition(int carPosition) {
        this.carPosition = carPosition;
    }
}
