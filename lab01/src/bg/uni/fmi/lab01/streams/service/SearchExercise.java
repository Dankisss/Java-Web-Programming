package bg.uni.fmi.lab01.streams.service;

import bg.uni.fmi.lab01.streams.entity.Order;
import bg.uni.fmi.lab01.streams.entity.OrderLine;
import bg.uni.fmi.lab01.streams.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchExercise {
    /**
     * extract all active orders
     * @param user
     * @return List<Order>
     */
    public List<Order> getActiveOrders(User user) {
        return user.getOrders().stream().filter(Order::isActive).toList();
    }

    public List<Order> getActiveOrdersByIteration(User user) {
        List<Order> res = new ArrayList<>();

        for (var cur : user.getOrders()) {
            if (cur.isActive()) {
                res.add(cur);
            }
        }

        return res;
    }

    /**
     * Return order by a specific id
     * @param orders
     * @param orderId
     * @return Order
     */
    public Order getOrderById(List<Order> orders, long orderId) {
        return orders.stream().filter(k -> k.getId() == orderId).findFirst().get() ;
    }

    public Order getOrderByIdIteration(List<Order> orders, long orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }

        return null;
    }

    /**
     * Return orders that have specific description for item
     * @param user
     * @param description
     * @return List<Order>
     */
    public List<Order> getOrdersThatHaveItemDescription(User user, String description) {
        return user.getOrders().stream().filter(ol -> ol.getOrderLines().stream().anyMatch(o -> o.item().description().equals(description))).toList();
    }

    /**
     * @return true if customer has at least one order with status ACTIVE
     */
    public boolean hasActiveOrders(User user) {

        return user.getOrders().stream().anyMatch(Order::isActive);
    }

    /**
     * Return true if inside the Order we don't have OrderLine with special offer
     */
    public boolean canBeReturned(Order order) {
        return order.getOrderLines().stream().anyMatch(ol -> !ol.specialOffer());
    }

    /**
     * Return the order with maximum total price
     * @param user
     * @return
     */
    public Optional<Order> getMaxPriceOrder(User user) {
        return user.getOrders().stream().max( (ol1, ol2) -> Double.compare(ol1.getPrice(), ol2.getPrice()));
    }
}
