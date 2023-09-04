
public class Car {
    private float speed;
    private float gasolineLevel;
    private float tank = 100;
    private float topSpeed = 120.0f;
    private String typeName;

    public Car(String typeName, float topSpeed, float tank) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;
        this.topSpeed = topSpeed;
        this.tank = tank;
    }

    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 10;
            if (speed >= topSpeed) speed = topSpeed;
        } else {
            speed = 0;
        }
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else {
            speed = 0;
        }
    }

    float getSpeed() {
        return speed;
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = tank;
    }

    public void setTankLimit(int num) {
        this.tank = num;
    }

    public void setTopSpeed(int num) {
        this.topSpeed = num;
    }

    float getGasolineLevel() {
        return this.gasolineLevel;
    }

    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Lada", 120, 100);
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
    }
}
