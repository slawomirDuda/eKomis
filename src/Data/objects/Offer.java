package Data.objects;


import java.util.Date;

public class Offer {

    public String username;
    public int price;
    public String brand;
    public String model;
    public String type;
    public int year;//todo make this Date class
    public float engine;
    public String fuelType;
    public int horsepower;

    public Offer(String csvDataLine) {
        String[] lines = csvDataLine.split(",");
        this.username = lines[0];
        this.price = Integer.parseInt(lines[1]);
        this.brand = lines[2];
        this.model = lines[3];
        this.type = lines[4];
        this.year = Integer.parseInt(lines[5]);
        this.engine = Float.parseFloat(lines[6]);
        this.fuelType = lines[7];
        this.horsepower = Integer.parseInt(lines[8]);
    }

    public String getObjectAsCSVLine(){//todo
//        return this....
        return "paceholder";
    }
}
