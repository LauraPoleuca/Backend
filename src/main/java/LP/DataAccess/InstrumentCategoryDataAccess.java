package LP.DataAccess;

import LP.Domain.InstrumentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InstrumentCategoryDataAccess {
    private BaseDataAccess baseDataAccess;

    @Autowired
    public InstrumentCategoryDataAccess(BaseDataAccess baseDataAccess) {
        this.baseDataAccess = baseDataAccess;
    }

    public List<InstrumentCategory> RetrieveInstrumentCategory() {
        List<InstrumentCategory> resultSelectList = new ArrayList<>();
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("select * from instrument_category");
        try {
            while (resultSelect.next()) {
                int category_id = resultSelect.getInt(1);
                String category_name = resultSelect.getNString(2);
                InstrumentCategory instrumentCategory = new InstrumentCategory(category_id, category_name);
                resultSelectList.add(instrumentCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSelectList;
    }

    public void CreateInstrumentCategory(String category_name) {
        String query = String.format("INSERT INTO instrument_category (category_name) VALUES ('%s')", category_name);
        baseDataAccess.ExecuteCUD(query);
    }

    public void UpdateInstrumentCategory(int category_id,String category_name) {
        String query = String.format("UPDATE instrument_category SET category_name= '%s' WHERE category_id = '%s'",
                category_name,category_id);
        baseDataAccess.ExecuteCUD(query);
    }

    public void DeleteInstrumentCategory(int category_id) {
        String query = String.format("DELETE FROM instrument_category WHERE category_id = %d", category_id);
        baseDataAccess.ExecuteCUD(query);
    }


    public InstrumentCategory RetrieveLastInstrumentCategory() {
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("SELECT * FROM instrument_category ORDER BY category_id DESC LIMIT 1;");
        try {
            resultSelect.next();
            int category_id = resultSelect.getInt(1);
            String category_name = resultSelect.getNString(2);
            InstrumentCategory instrumentCategory = new InstrumentCategory(category_id, category_name);
            return instrumentCategory;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

