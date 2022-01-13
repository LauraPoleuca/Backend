package LP.BusinessLogic;

import LP.DataAccess.InstrumentCategoryDataAccess;
import LP.Domain.InstrumentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstrumentCategoryBusinessLogic {
    private InstrumentCategoryDataAccess instrumentCategoryDataAccess;

    @Autowired
    public InstrumentCategoryBusinessLogic(InstrumentCategoryDataAccess instrumentCategoryDataAccess) {
        this.instrumentCategoryDataAccess = instrumentCategoryDataAccess;
    }

    public List<InstrumentCategory> RetrieveInstrumentCategory() {
        List<InstrumentCategory> temp=instrumentCategoryDataAccess.RetrieveInstrumentCategory();
        return temp;
    }

    public void CreateInstrumentCategory(String category_name) {
        instrumentCategoryDataAccess.CreateInstrumentCategory(category_name);
    }

    public void UpdateInstrumentCategory(int category_id,String category_name) {
        instrumentCategoryDataAccess.UpdateInstrumentCategory(category_id,category_name);
    }

    public void DeleteInstrumentCategory(int category_id) {
        instrumentCategoryDataAccess.DeleteInstrumentCategory(category_id);
    }


}
