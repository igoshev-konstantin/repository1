package Spring.annotations;

public interface CarsInterface {
    default CarsType getCarType() {
        return CarsType.UNKNOWN;
    }
}
