package priv.lushiwu.takeout.sys;

import priv.lushiwu.takeout.dao.Dao;
import priv.lushiwu.takeout.domain.Order;

import java.util.*;

/**
 * @Author: lushiwu
 * @Date 2021/12/6 18:12
 */
public class OrderSys implements Dao<Order> {
    static Map<String, Order> orderMap = new HashMap<String, Order>();
    static List<Order> orderList = new ArrayList<Order>();

    //新增订单
    @Override
    public void insert(Order order) {
        orderMap.put(order.getOrderId(), order);
    }

    //通过id查询订单
    @Override
    public Order findById(String id) {
        if (orderMap.get(id) == null) {
            return null;
        } else {
            return orderMap.get(id);
        }
    }

    //通过用户id查询用户的所有订单，并返回一个list集合
    public List<Order> findByIdAll(String id) {
        List<Order> list = new ArrayList<>();
        Set<String> keys = orderMap.keySet();
        for (String key : keys) {
            if (Objects.equals(id, orderMap.get(key).getOrderId())) {
                list.add(orderMap.get(key));
            }
        }
        return list;
    }

    @Override
    public List<Order> findAll() {
        Set<String> keys = orderMap.keySet();
        for (String key : keys) {
            orderList.add(orderMap.get(key));
        }
        return orderList;
    }

    @Override
    public void delete(String id) {
        if (orderMap.get(id) == null) {
            System.out.println("订单不存在");
        } else {
            orderMap.remove(id);
            System.out.println("订单成功删除");
        }
    }
}
