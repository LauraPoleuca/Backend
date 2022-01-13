package LP.Domain;

public class Instrument {
    public int instrument_id;
    public int category_id;
    public String colour;
    public int price;
    public String instrument_name;

    public Instrument(int instrument_id, int category_id, String colour, int price, String instrument_name) {

        this.instrument_id = instrument_id;
        this.category_id = category_id;
        this.colour = colour;
        this.price = price;
        this.instrument_name = instrument_name;
    }

    public int getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(int instrument_id) {
        this.instrument_id = instrument_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInstrument_name() {
        return instrument_name;
    }

    public void setInstrument_name(String instrument_name) {
        this.instrument_name = instrument_name;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "instrument_id=" + instrument_id +
                ", category_id=" + category_id +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                ", instrument_name='" + instrument_name + '\'' +
                '}';
    }
}



