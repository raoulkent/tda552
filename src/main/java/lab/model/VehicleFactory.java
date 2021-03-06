package lab.model;

import lab.model.vehicles.*;
import lab.model.vehicles.Vehicle;

import java.util.concurrent.ThreadLocalRandom;


public class VehicleFactory {

  public enum VehicleType {
    VOLVO {
      @Override
      public Vehicle create(int x, int y){
        return new Volvo240(x, y);
      }
    },
    SAAB{
      @Override
      public Vehicle create(int x, int y) {
        return new Saab95(x, y);
      }
    },
    SCANIA{
      @Override
      public Vehicle create(int x, int y) {
        return new Scania(x, y);
      }
    };
    public abstract Vehicle create(int x, int y);
  }

  public Vehicle makeVehicle(VehicleType type, int x, int y){
    return type.create(x, y);
  }

  public Vehicle makeVehicle(String type, int x, int y) {
    return makeVehicle(VehicleType.valueOf(type.toUpperCase()), x, y);
  }

  public Vehicle makeVehicle(String type) {
    int x = ThreadLocalRandom.current().nextInt(World.WIDTH);
    int y = ThreadLocalRandom.current().nextInt(World.HEIGHT);
    return makeVehicle(VehicleType.valueOf(type.toUpperCase()), x, y);
  }
}
