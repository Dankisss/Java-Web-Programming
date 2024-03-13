package bg.uni.fmi.lab01.streams.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<Order> orders;

    public User() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        if (order == null) {
            throw new NullPointerException();
        }

        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
