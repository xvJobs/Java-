package priv.lushiwu.takeout.sys;

import priv.lushiwu.takeout.dao.Dao;
import priv.lushiwu.takeout.domain.Dishes;

import java.util.*;

/**
 * @Author: lushiwu
 * @Date 2021/12/6 18:12
 */
public class DishesSys implements Dao<Dishes> {
    // 建立一个菜品的map集合，其中菜品的id为map的键，整个菜品对象为map的值
    static Map<String, Dishes> dishesMap = new HashMap<>();
    Set<String> keys = dishesMap.keySet();

    //添加菜品
    @Override
    public void insert(Dishes dishes) {
        dishesMap.put(dishes.getdId(), dishes);
    }

    //通过id查询菜品
    @Override
    public Dishes findById(String id) {
        if (dishesMap.get(id) == null) {
            return null;
        } else {
            return dishesMap.get(id);
        }
    }

    //根据菜品类型查找菜品
    public List<Dishes> findByType(String type) {
        List<Dishes> list = new ArrayList<Dishes>();
        keys.forEach(key -> {
            if (Objects.equals(type, dishesMap.get(key).getdType())) {
                list.add(dishesMap.get(key));
            }
        });
        return list;
    }

    //查询所有菜品
    @Override
    public List<Dishes> findAll() {
        List<Dishes> list = new ArrayList<Dishes>();
        for (String key : keys) {
            list.add(dishesMap.get(key));
        }
        return list;
    }

    //查询菜品类型
    public void selectByType(String type) {
        int count = 0;
        for (String key : keys) {
            if (Objects.equals(type, dishesMap.get(key).getdType())) {
                System.out.println(dishesMap.get(key));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("没有当前类型的菜品！");
        }
    }

    //删除指定id商品
    @Override
    public void delete(String id) {
        if (dishesMap.get(id) == null) {
            System.out.println("id输入错误");
        } else{
            dishesMap.remove(id);
            System.out.println("删除成功！");
        }
    }

}
