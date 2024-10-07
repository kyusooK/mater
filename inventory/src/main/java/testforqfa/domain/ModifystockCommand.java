package testforqfa.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ModifystockCommand {

    private String productId;
    private String productName;
}
