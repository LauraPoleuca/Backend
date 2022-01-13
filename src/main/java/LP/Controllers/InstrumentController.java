package LP.Controllers;

import LP.BusinessLogic.InstrumentBusinessLogic;
import LP.Domain.Instrument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/instrument")
public class InstrumentController {
    private InstrumentBusinessLogic instrumentBusinessLogic;
    @GetMapping
    public List<Instrument> RetrieveInstrument() {
        List<Instrument> temp=instrumentBusinessLogic.RetrieveInstrument();
        return temp;
    }

    public InstrumentController(InstrumentBusinessLogic instrumentBusinessLogic) {
        this.instrumentBusinessLogic = instrumentBusinessLogic;
    }

    @PostMapping
    public void CreateInstrument(@RequestParam int category_id,@RequestParam String colour,@RequestParam int price,@RequestParam String instrument_name){
        instrumentBusinessLogic.CreateInstrument(category_id,colour,price,instrument_name);
    }

    @PutMapping
    public void UpdateInstrument(@RequestParam int instrument_id, @RequestParam int category_id, @RequestParam String colour, @RequestParam int price,@RequestParam String instrument_name) {
        instrumentBusinessLogic.UpdateInstrument(instrument_id,category_id, colour, price,instrument_name);
    }

    @DeleteMapping
    public void DeleteInstrument(@RequestParam int instrument_id) {
        instrumentBusinessLogic.DeleteInstrument(instrument_id);
    }

    @GetMapping("/CategoryIDs")
    public List<Integer> RetrieveCategoryIds() {
        List<Integer> temp=instrumentBusinessLogic.RetrieveCategoryIDs();
        return temp;
    }
}

