package com.adidyk.restful;

import com.adidyk.model.dto.OrderDTO;
import com.adidyk.model.dto.UserDTO;
import com.adidyk.transfer.OrderTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Class OrderAPI....,,,//----
 */
@RestController
public class OrderAPI {

    /**
     * @param orderService - order transfer.
     */
    private final OrderTransfer transfer;

    /**
     * OrderAPI - constructor.
     * @param transfer - service.
     */
    @Autowired
    public OrderAPI(OrderTransfer transfer) {
        this.transfer = transfer;
    }

    /**
     * addSmartPhone - adds smart phone.
     * @param order - smart phone.
     */
    @RequestMapping(value = "/save_order", method = RequestMethod.POST)
    public void saveOrder(@RequestBody OrderDTO order) {
        this.transfer.save(order);
    }

    /**
     *
     * @param order - order.
     * @return - return.
     */
    @RequestMapping(value = "find_order_by_id", method = RequestMethod.POST)
    public OrderDTO findOrderById(@RequestBody OrderDTO order) {
        return this.transfer.findById(order);
    }

    /**
     * findAllOrderByUser - find all order by user id.
     * @param user - user.
     * @return - return list.
     */
    @RequestMapping(value = "find_all_order_by_user", method = RequestMethod.POST)
    public List<OrderDTO> findAllOrderByUser(@RequestBody UserDTO user) {
        return this.transfer.findAllByUser(user);
    }

}