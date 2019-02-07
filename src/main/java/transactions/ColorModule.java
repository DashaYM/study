package transactions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.xml.rpc.ServiceException;

@Stateless
public class ColorModule {

    @EJB
    private ColorDAO dao;

    public void persistEntities0() {//persisted together

        Colour colour = new Colour();
        colour.setColourCode("23").setDescription("descr1").setRgbValue("rgb");
        dao.simpleMerge_required(colour);

        Colour colour2 = new Colour();
        colour2.setColourCode("55").setDescription("descr2").setRgbValue("rgb");
        dao.simpleMerge_required(colour2);

    }

    public void persistEntities1() {//persisted separately

        Colour colour = new Colour();
        colour.setColourCode("24").setDescription("descr3").setRgbValue("rgb");
        dao.simpleMerge_requiresNew(colour);

        Colour colour2 = new Colour();
        colour2.setColourCode("56").setDescription("descr4").setRgbValue("rgb");
        dao.simpleMerge_requiresNew(colour2);

    }

    public void persistEntities2() { //not persisted because of the same transaction

        Colour colour = new Colour();
        colour.setColourCode("25").setDescription("descr5").setRgbValue("rgb");
        dao.simpleMerge_required(colour);

        try {
            dao.throwsException_required();
        } catch (Exception e) {

        }

        Colour colour2 = new Colour();
        colour2.setColourCode("26").setDescription("descr5").setRgbValue("rgb");
        dao.simpleMerge_required(colour2);

    }

    public void persistEntities3() { //persisted because of new trx in simple merge

        Colour colour = new Colour();
        colour.setColourCode("26").setDescription("descr6").setRgbValue("rgb");
        dao.simpleMerge_requiresNew(colour);

        dao.throwsException_required();

    }

    public void persistEntities4() throws ServiceException { //persisted because of no trx during ex

        Colour colour = new Colour();
        colour.setColourCode("27").setDescription("descr7").setRgbValue("rgb");
        dao.simpleMerge_required(colour);

        try {

            dao.throwsException_notSupported();
        } catch (Exception e){

        }

        Colour colour2 = new Colour();
        colour2.setColourCode("28").setDescription("descr7").setRgbValue("rgb");
        dao.simpleMerge_required(colour2);

    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void persistEntities5() {//persisted separately

        Colour colour2 = new Colour();
        colour2.setColourCode("56").setDescription("descr4").setRgbValue("rgb");
        dao.simpleMerge_never(colour2);

        Colour colour = new Colour();
        colour.setColourCode("24").setDescription("descr3").setRgbValue("rgb");
        dao.simpleMerge_mandatory(colour);



    }
}
