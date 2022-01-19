package LP.BusinessLogic;

import LP.DataAccess.InstrumentDataAccess;
import LP.Domain.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentBusinessLogic {
    private InstrumentDataAccess instrumentDataAccess;

    @Autowired
    public InstrumentBusinessLogic(InstrumentDataAccess instrumentDataAccess) {
        this.instrumentDataAccess = instrumentDataAccess;
    }
    public List<Instrument> RetrieveInstrument() {
        List<Instrument> temp=instrumentDataAccess.RetrieveInstrument();
        return temp;
    }

    public void CreateInstrument(int category_id,String colour,int price,String instrument_name) {
        instrumentDataAccess.CreateInstrument(category_id,colour,price,instrument_name);
    }

    public void UpdateInstrument(int instrument_id,int category_id,String colour,int price,String instrument_name) {
        instrumentDataAccess.UpdateInstrument(instrument_id,category_id,colour,price,instrument_name);
    }

    public void DeleteInstrument(int instrument_id) {
        instrumentDataAccess.DeleteInstrument(instrument_id);
    }

    public List<Integer> RetrieveCategoryIDs() {
        List<Integer> temp=instrumentDataAccess.RetrieveCategoryIDs();
        return temp;
    }
}
