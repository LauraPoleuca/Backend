package LP.Controllers;

import LP.BusinessLogic.InstrumentCategoryBusinessLogic;
import LP.Domain.InstrumentCategory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/instrument_category")
public class InstrumentCategoryController {
    private InstrumentCategoryBusinessLogic instrumentCategoryBusinessLogic;

    @GetMapping
    public List<InstrumentCategory> RetrieveInstrumentCategory() {
        List<InstrumentCategory> temp=instrumentCategoryBusinessLogic.RetrieveInstrumentCategory();
        return temp;
    }

    public InstrumentCategoryController(InstrumentCategoryBusinessLogic instrumentCategoryBusinessLogic) {
        this.instrumentCategoryBusinessLogic = instrumentCategoryBusinessLogic;
    }

    @PostMapping
    public void CreateInstrumentCategory(@RequestParam String category_name) {
        instrumentCategoryBusinessLogic.CreateInstrumentCategory(category_name);
    }

    @PutMapping
    public void UpdateInstrumentCategory(@RequestParam int category_id, @RequestParam String category_name) {
        instrumentCategoryBusinessLogic.UpdateInstrumentCategory(category_id, category_name);
    }

    @DeleteMapping
    public void DeleteInstrumentCategory(@RequestParam int category_id) {
        instrumentCategoryBusinessLogic.DeleteInstrumentCategory(category_id);
    }


}
