public class Offer {

    public String username;
    public int price;
    public String brand;
    public String model;
    public String type;
    public int year;
    public float engine;
    public String fuelType;
    public int horsepower;
    public int offer_id;

    public Offer(String csvLine) {
        String[] splitted = csvLine.split(",");
        this.username = splitted[0];
        this.price = Integer.parseInt(splitted[1]);
        this.brand = splitted[2];
        this.model = splitted[3];
        this.type = splitted[4];
        this.year = Integer.parseInt(splitted[5]);
        this.engine = Float.parseFloat(splitted[6]);
        this.fuelType = splitted[7];
        this.horsepower = Integer.parseInt(splitted[8]);
        this.offer_id = Integer.parseInt(splitted[9]);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "username='" + username + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", engine=" + engine +
                ", fuelType='" + fuelType + '\'' +
                ", horsepower=" + horsepower +
                ", offer_id=" + offer_id +
                '}';
    }
}
