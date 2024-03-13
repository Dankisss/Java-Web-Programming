package bg.uni.fmi.lab01.streams.entity;

import bg.uni.fmi.lab01.streams.vo.OrderStatus;
import bg.uni.fmi.lab01.streams.vo.PaymentMethod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private long id;
    private List<OrderLine> orderLines;
    private LocalDate orderDate;
    private double price;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;


    public Order(long id, OrderStatus orderStatus, List<OrderLine> orderLines) {
        this.id = id;
        this.orderLines = orderLines;
        orderDate = LocalDate.now();
        price = 0;
        this.orderStatus = orderStatus;
        paymentMethod = PaymentMethod.CASH_ON_DELIVERY;
    }


    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", price=" + price +
                ", orderStatus=" + orderStatus +
                ", paymentMethod=" + paymentMethod;
    }

    public boolean isActive() {
        return LocalDate.now().isBefore(orderDate);
    }

    public long getId() {
        return id;
    }
}
