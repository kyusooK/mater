package testforqfa.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testforqfa.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/inventories")
@Transactional
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    @RequestMapping(
        value = "/inventoriesmodifystock",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Inventory modifystock(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ModifystockCommand modifystockCommand
    ) throws Exception {
        System.out.println("##### /inventory/modifystock  called #####");
        Inventory inventory = new Inventory();
        inventory.modifystock(modifystockCommand);
        inventoryRepository.save(inventory);
        return inventory;
    }
}
//>>> Clean Arch / Inbound Adaptor
