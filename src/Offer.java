import java.util.Map;

import static java.util.Map.entry;

public class Offer {
    private static final Map<String, Integer> OFFER_CSV_MAPPINGS = Map.ofEntries(
            entry("id", 0),
            entry("username", 1),
            entry("price", 2),
            entry("brand", 3),
            entry("model", 4),
            entry("type", 5),
            entry("year", 6),
            entry("engine", 7),
            entry("fuelType", 8),
            entry("horsepower", 9)
    );

    public int id;
    public String username;
    public int price;
    public String brand;
    public String model;
    public String type;
    public int year;
    public float engine;
    public String fuelType;
    public int horsepower;

    public Offer(String csvLine) {
        String[] splitted = csvLine.split(",");
        this.id = Integer.parseInt(splitted[OFFER_CSV_MAPPINGS.get("id")]);
        this.username = splitted[OFFER_CSV_MAPPINGS.get("username")];
        this.price = Integer.parseInt(splitted[OFFER_CSV_MAPPINGS.get("price")]);
        this.brand = splitted[OFFER_CSV_MAPPINGS.get("brand")];
        this.model = splitted[OFFER_CSV_MAPPINGS.get("model")];
        this.type = splitted[OFFER_CSV_MAPPINGS.get("type")];
        this.year = Integer.parseInt(splitted[OFFER_CSV_MAPPINGS.get("year")]);
        this.engine = Float.parseFloat(splitted[OFFER_CSV_MAPPINGS.get("engine")]);
        this.fuelType = splitted[OFFER_CSV_MAPPINGS.get("fuelType")];
        this.horsepower = Integer.parseInt(splitted[OFFER_CSV_MAPPINGS.get("horsepower")]);
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
                ", offer_id=" + id +
                '}';
    }
}
