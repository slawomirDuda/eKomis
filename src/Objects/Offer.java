package Objects;

import java.util.Arrays;
import java.util.Map;

import static java.util.Map.entry;

public class Offer implements ObjectToCSV {

    public static final String ID_COLUMN_NAME = "id";
    public static final String USERNAME_ID_COLUMN_NAME = "username_id";
    public static final String PRICE_COLUMN_NAME = "price";
    public static final String BRAND_COLUMN_NAME = "brand";
    public static final String MODEL_COLUMN_NAME = "model";
    public static final String TYPE_COLUMN_NAME = "type";
    public static final String YEAR_COLUMN_NAME = "year";
    public static final String ENGINE_COLUMN_NAME = "engine";
    public static final String FUELTYPE_COLUMN_NAME = "fueltype";
    public static final String HORSEPOWER_COLUMN_NAME = "horsepower";
    public static final String FILEPATH = "src\\Data\\Offers.csv";
    public static final Map<String, Integer> OFFER_CSV_MAPPINGS = Map.ofEntries(
            entry(ID_COLUMN_NAME, 0),
            entry(USERNAME_ID_COLUMN_NAME, 1),
            entry(PRICE_COLUMN_NAME, 2),
            entry(BRAND_COLUMN_NAME, 3),
            entry(MODEL_COLUMN_NAME, 4),
            entry(TYPE_COLUMN_NAME, 5),
            entry(YEAR_COLUMN_NAME, 6),
            entry(ENGINE_COLUMN_NAME, 7),
            entry(FUELTYPE_COLUMN_NAME, 8),
            entry(HORSEPOWER_COLUMN_NAME, 9)
    );

    public final int id;
    public int username_id;
    public int price;
    public String brand;
    public String model;
    public String type;
    public int year;
    public float engine;
    public String fuelType;
    public int horsepower;

    public Offer (String csvLine) {

        String[] splitted = csvLine.split(",");
        this.id = Integer.parseInt(splitted[OFFER_CSV_MAPPINGS.get(ID_COLUMN_NAME)]);
        this.username_id = Integer.parseInt(splitted[OFFER_CSV_MAPPINGS.get(USERNAME_ID_COLUMN_NAME)]);
        this.price = Integer.parseInt(splitted[OFFER_CSV_MAPPINGS.get(PRICE_COLUMN_NAME)]);
        this.brand = splitted[OFFER_CSV_MAPPINGS.get(BRAND_COLUMN_NAME)];
        this.model = splitted[OFFER_CSV_MAPPINGS.get(MODEL_COLUMN_NAME)];
        this.type = splitted[OFFER_CSV_MAPPINGS.get(TYPE_COLUMN_NAME)];
        this.year = Integer.parseInt(splitted[OFFER_CSV_MAPPINGS.get(YEAR_COLUMN_NAME)]);
        this.engine = Float.parseFloat(splitted[OFFER_CSV_MAPPINGS.get(ENGINE_COLUMN_NAME)]);
        this.fuelType = splitted[OFFER_CSV_MAPPINGS.get(FUELTYPE_COLUMN_NAME)];
        this.horsepower = Integer.parseInt(splitted[OFFER_CSV_MAPPINGS.get(HORSEPOWER_COLUMN_NAME)]);
    }

    @Override
    public String toString() {
        return "Objects.Offer{" +
//                "offer_id=" + id +
//                ", username_id='" + username_id + '\'' +
                "price=" + price +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", engine=" + engine +
                ", fuelType='" + fuelType + '\'' +
                ", horsepower=" + horsepower +
                '}';
    }
    @Override
    public String getObjectAsCSVLine() {

        String[] splitted = new String[10];
        splitted[0] = String.valueOf(this.username_id);
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
