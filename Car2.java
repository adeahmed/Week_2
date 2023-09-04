public class Car2 {
    private float speed;
    private float gasolineLevel;
    private float tank = 100;
    private float topSpeed = 120.0f;
    private String typeName;
    private boolean cruiseControlOn;
    private float targetSpeed;

    public Car2(String typeName, float topSpeed, float tank) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;
        this.topSpeed = topSpeed;
        this.tank = tank;
        cruiseControlOn = false;
        targetSpeed = 0;
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

    public void setCruiseControlSpeed(float speed) {
        if (speed >= 20 && speed <= topSpeed) {
            targetSpeed = speed;
            cruiseControlOn = true;
        } else {
            cruiseControlOn = false;
            targetSpeed = 0;
        }
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void turnOffCruiseControl() {
        cruiseControlOn = false;
        targetSpeed = 0;
    }

    public void activateCruiseControl() {
        cruiseControlOn = true;
    }

    public void manageCruiseControl() {
        if (cruiseControlOn) {
            if (speed < targetSpeed) {
                accelerate();
            } else if (speed > targetSpeed) {
                decelerate(10);
            }
        }
    }

    public static void main(String[] args) {
        Car2 myCar;

        myCar = new Car2("Toyota Corolla", 120, 100);
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        myCar.setCruiseControlSpeed(80);
        myCar.activateCruiseControl();

        while (myCar.isCruiseControlOn()) {
            myCar.manageCruiseControl();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
    }
}
