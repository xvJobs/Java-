package priv.lushiwu.takeout.domain;

import java.time.LocalDate;

/**
 * @Author: lushiwu
 * @Date 2021/12/6 17:55
 */

public class Order {
    private String orderId;
    private LocalDate uTime;
    private Dishes dishes;
    private int orderNum;
    private String uid;
    private Double orderPrice;
    private int OrderValue;

    public Order() {
    }

    public Order(String orderId, LocalDate uTime, Dishes dishes, int orderNum, String uid, Double orderPrice, int orderValue) {
        this.orderId = orderId;
        this.uTime = uTime;
        this.dishes = dishes;
        this.orderNum = orderNum;
        this.uid = uid;
        this.orderPrice = orderPrice;
        OrderValue = orderValue;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getuTime() {
        return uTime;
    }

    public void setuTime(LocalDate uTime) {
        this.uTime = uTime;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderValue() {
        return OrderValue;
    }

    public void setOrderValue(int orderValue) {
        OrderValue = orderValue;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", uTime=" + uTime +
                ", dishes=" + dishes +
                ", orderNum=" + orderNum +
                ", uid='" + uid + '\'' +
                ", orderPrice=" + orderPrice +
                ", OrderValue=" + OrderValue +
                '}';
    }
}
