import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static java.util.Map.entry;

public class Offer implements ObjectToCSV {

    public static final String FILEPATH = "src\\Data\\Offers.csv";
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

    public final int id;
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
    @Override
    public String getObjectAsCSVLine() {
        String[] splitted = new String[10];
        splitted[0] = this.username;
        splitted[1] = String.valueOf(this.price);
        splitted[2] = this.brand;
        splitted[3] = this.model;
        splitted[4] = this.type;
        splitted[5] = String.valueOf(this.year);
        splitted[6] = String.valueOf(this.engine);
        splitted[7] = this.fuelType;
        splitted[8] = String.valueOf(this.horsepower);
        splitted[9] = String.valueOf(this.id);

        String line = Arrays.toString(splitted);
        line = line.replaceAll(" ", "");
        line = line.replace("[", "");
        return line;
    }
}
