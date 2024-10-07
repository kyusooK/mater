package testforqfa.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import testforqfa.OrderApplication;
import testforqfa.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private String productName;

    private Integer qty;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void getOrder(GetOrderCommand getOrderCommand) {
        testforqfa.external.GetOrderQuery getOrderQuery = new testforqfa.external.GetOrderQuery();
        OrderApplication.applicationContext
            .getBean(testforqfa.external.InventoryService.class)
            .getOrder(getOrderQuery.getId(), getOrderQuery);
    }
}
//>>> DDD / Aggregate Root
