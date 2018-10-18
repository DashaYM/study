package transactions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KLEUREN")
public class Colour {

    @Id
    @Column(name = "KLEUR", nullable = false, length = 50)
    private String colourCode;

    @Column(name = "OMSCHRIJVING", length = 50)
    private String description;

    @Column(name = "RGB_WAARDE", length = 8)
    private String rgbValue;

    public Colour() {
        //required by hibernate
    }

    public String getColourCode() {
        return colourCode;
    }

    public Colour setColourCode(String colourCode) {
        this.colourCode = colourCode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Colour setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getRgbValue() {
        return rgbValue;
    }

    public Colour setRgbValue(String rgbValue) {
        this.rgbValue = rgbValue;
        return this;
    }
}
