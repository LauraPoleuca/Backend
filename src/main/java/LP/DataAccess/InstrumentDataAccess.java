package LP.DataAccess;

import LP.Domain.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InstrumentDataAccess {
    private BaseDataAccess baseDataAccess;

    @Autowired
    public InstrumentDataAccess(BaseDataAccess baseDataAccess) {
        this.baseDataAccess = baseDataAccess;
    }

    public List<Instrument> RetrieveInstrument() {
        List<Instrument> resultSelectList =new ArrayList<>();
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("select * from instrument");
        try {
            while (resultSelect.next()) {
                int instrument_id=resultSelect.getInt(1);
                int category_id=resultSelect.getInt(2);
                String colour=resultSelect.getNString(3);
                int price=resultSelect.getInt(4);
                String instrument_name=resultSelect.getNString(5);
                Instrument instrument=new Instrument(instrument_id,category_id,colour,price,instrument_name);
                resultSelectList.add(instrument);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSelectList;
    }

    public void CreateInstrument(int category_id,String colour,int price,String instrument_name)
    {
        String query=String.format("INSERT INTO instrument(category_id,colour,price,instrument_name) VALUES ('%d','%s','%d','%s')",category_id,colour,price,instrument_name);
        baseDataAccess.ExecuteCUD(query);
    }

    public void UpdateInstrument(int instrument_id,int category_id,String colour,int price,String instrument_name) {
        String query = String.format("UPDATE instrument SET category_id= '%d', colour='%s',price='%d',instrument_name='%s' WHERE instrument_id = '%d'",
                category_id,colour,price,instrument_name,instrument_id);
        baseDataAccess.ExecuteCUD(query);
    }

    public void DeleteInstrument(int instrument_id) {
        String query = String.format("DELETE FROM instrument WHERE instrument_id = %d", instrument_id);
        baseDataAccess.ExecuteCUD(query);
    }
    public List<Integer> RetrieveCategoryIDs()
    {
        List<Integer> resultSelectList =new ArrayList<>();
        ResultSet resultSelect = baseDataAccess.ExecuteSelect("select category_id from instrument_category");
        try {
            while (resultSelect.next()) {
                resultSelectList.add(resultSelect.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSelectList;
    }


}
