package testforqfa.external;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    public Inventory getOrder(GetOrderQuery id) {
        Inventory inventory = new Inventory();

        return inventory;
    }
}
