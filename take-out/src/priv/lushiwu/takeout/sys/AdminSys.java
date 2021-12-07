package priv.lushiwu.takeout.sys;

import priv.lushiwu.takeout.admin.Admin;
import priv.lushiwu.takeout.admin.User;
import priv.lushiwu.takeout.dao.Dao;
import priv.lushiwu.takeout.domain.Dishes;
import priv.lushiwu.takeout.domain.Order;

import java.time.LocalDate;
import java.util.*;

/**
 * @Author: lushiwu
 * @Date 2021/12/6 18:05
 */
public class AdminSys implements Dao<Admin> {
    static Map<String, Admin> map = new HashMap<>();
    UserSys u = new UserSys();
    OrderSys o = new OrderSys();
    DishesSys d = new DishesSys();
    Scanner in = new Scanner(System.in);

    //添加菜品
    public void addDishes() {
        System.out.println("请输入您需要添加的菜品：(按照；菜品ID/菜品名/菜品类型/单价/月销量/总数量）");
        String str = in.next();
        String[] info = str.split("/");
        if (info.length < 6) {
            System.out.println("天啦噜，输入失败啦，请重新输入！");
            addDishes();
        } else {
            LocalDate dTime = LocalDate.now();
            Dishes t = new Dishes(info[0], info[1], info[2], dTime,
                    Double.parseDouble(info[3]), Integer.parseInt(info[4]),
                    Integer.parseInt(info[5]));
            d.insert(t);
            System.out.println("添加成功");
        }
    }

    //查看所有菜品信息
    public void showAllDishes(int pageSize) {
        List<Dishes> list = d.findAll();
        int start = 0;
        //先写一个死循环，进入else后break
        while (true) {
            if (list.size() > pageSize + start) {
                System.out.println(list.subList(start, pageSize + start));
            } else {
                System.out.println(list.subList(start, list.size()));
                break;
            }
            start += pageSize;
        }
    }

    //查看指定类别的菜品信息
    public void selectByTypeOfAdmin() {
        System.out.println("请输入需要查询的菜品类型：");
        String type = in.next();
        d.selectByType(type);
    }

    //根据菜品id修改菜品价格
    public void selectByDishesId() {
        System.out.println("请输入需要修改的菜名id:");
        String id = in.next();
        Dishes dish = d.findById(id);
        if (dish == null) {
            System.out.println("没有此菜");
        } else {
            System.out.println("当前菜品为" + dish);
            System.out.println("请输入新的菜品单价");
            double new_price = in.nextDouble();
            dish.setPrice(new_price);
            d.insert(dish);
            System.out.println("修改成功" + d.findById(dish.getdId()));
        }
    }

    //删除指定id的商品
    public void deleteDishes() {
        System.out.println("请输入需要删除菜品的id");
        String id = in.next();
        d.delete(id);
    }

    //添加客户
    public void addUser(){
        System.out.println("请输入需要添加的用户：按照(id/姓名/性别/密码/送餐地址/手机号");
        String str = in.next();
        String[] info = str.split("/");
        if (info.length < 6) {
            System.out.println("天啦噜，输入错误，请重新输入！");
        } else {
            LocalDate dTime = LocalDate.now();
            u.insert(new User(info[0], info[1], info[2], info[3], info[4], info[5], dTime));
            System.out.println("添加成功");
        }
    }



    //查看客户列表
    public void findUser() {
        List<User> userList = u.findAll();
        userList.forEach(list -> System.out.println(userList));
    }

    //根据id查找指定用户
    public User findUserById(String id) {
        return u.findById(id);
    }

    //删除指定id的客户
    public void deleteUserByAdmin() {
        System.out.println("请输入要删除的id：");

    }

    //订单列表显示
    public void showAllOrders() {
        List<Order> allOrder = o.findAll();
        allOrder.forEach(order -> System.out.println(order));
    }

    //根据订单id修改订单状态
    public void changeOrderValue() {
        System.out.println("请输入需要修改状态的订单id");
        String id = in.next();
        Order order = o.findById(id);
        if (order == null) {
            System.out.println("没有当前id订单，请检查输入");
        } else {
            System.out.println("已找到当前id订单" + order);
            System.out.println("请输入你需要修改的状态：0：未支付 1：已支付 2：配送中 3：已完成");
            int value = in.nextInt();
            order.setOrderValue(value);
            o.insert(order);
            System.out.println("修改成功！");
        }
    }

    //显示所有菜平（按菜品销量从高到低排序输出）
    public void showAllDishesUser() {
        List<Dishes> list = d.findAll();
        Collections.sort(list, (p1, p2) -> p1.getdSales() - p2.getdSales());
        System.out.println(list);
    }

    //点餐（输入菜品id和购买数量）
    public void shoDishes(User user) {
        showAllDishesUser();
        System.out.println("请输入需要狗改的id和数量：按照（id/数量）");
        String str = in.next();
        String[] info = str.split("/");
        if (info.length < 2) {
            System.out.println("输入有误，请重新输入：");
            shoDishes(user);
        } else {
            LocalDate dTime = LocalDate.now();
            Order order = new Order(info[0], dTime, d.findById(info[0]), Integer.parseInt(info[1]),
                    user.getuID(), o.findById(info[0]).getOrderPrice(),
                    o.findById(info[0]).getOrderValue());
            o.insert(order);
            System.out.println("订单已生产" + o.findById(info[0]));
        }
    }

    //根据菜品类别显示所有菜品
    public void ShowOfTypeByUser() {
        System.out.println("请输入您要查找的类别：");
        String str = in.next();
        System.out.println(d.findByType(str));
    }

    //查看所有订单(当前登录用户的)
    public void showAllOrderByUser(User user) {
        List<Order> list = o.findByIdAll(user.getuID());
        list.forEach(order -> System.out.println(order));
    }


    // 修改密码（当前登录用户的）
    public void changePwdByUser(User user) {
        u.changePwd(user.getuPwd());
        System.out.println("修改成功");
    }

    //个人信息显示
    public void showByUser(User user) {
        User findById = u.findById(user.getuID());
        System.out.println(findById);
    }


    @Override
    public void insert(Admin admin) {

    }
    //通过id查找管理员
    @Override
    public Admin findById(String id) {
        return map.get(id);
    }

    //添加管理员
    @Override
    public List<Admin> findAll() {
        return null;
    }

    //删除管理员
    @Override
    public void delete(String id) {
    }

    //先设置系统默认数据
    public void addMessage() {
        map.put("lushiwu", new Admin("10086", "lushiwu", "123"));
        LocalDate time = LocalDate.now();
        Dishes d1 = new Dishes("1", "红烧猪蹄", "肉类", time, 12.5, 20, 30);
        d.insert(d1);
        Dishes d2 = new Dishes("2", "鸡公煲", "肉类", time, 21.5, 30, 20);
        d.insert(d2);
        Dishes d3 = new Dishes("3", "麻辣香锅", "火锅类", time, 30, 5, 10);
        d.insert(d3);
        Dishes d4 = new Dishes("4", "水煮肉片", "肉类", time, 15, 12, 15);
        d.insert(d4);
        Dishes d5 = new Dishes("5", "水果沙拉", "水果类", time, 6, 70, 60);
        d.insert(d5);
        LocalDate localdate = LocalDate.now();
        Order o1 = new Order("1", localdate, d1, 10, "1001", 60.0, 1);
        o.insert(o1);
        Order o2 = new Order("2", localdate, d2, 5, "1002", 50.0, 10);
        o.insert(o2);
        Order o3 = new Order("3", localdate, d3, 5, "1003", 40.0, 5);
        o.insert(o3);
        Order o4 = new Order("4", localdate, d4, 5, "1004", 30.0, 6);
        o.insert(o4);
        Order o5 = new Order("5", localdate, d5, 5, "1005", 20.0, 8);
        o.insert(o5);
        User u1 = new User("1001", "张三", "男", "123456", "湖北", "13545286487", localdate);
        u.insert(u1);
        User u2 = new User("1002", "李四", "男", "234567", "湖南", "15927948976", localdate);
        u.insert(u2);
        User u3 = new User("1003", "王五", "男", "345678", "江苏", "15927986854", localdate);
        u.insert(u3);
        User u4 = new User("1004", "刘柳", "女", "456789", "浙江", "18771580860", localdate);
        u.insert(u4);
        User u5 = new User("1005", "赵琦", "女", "567890", "新疆", "18771580750", localdate);
        u.insert(u5);
    }
}

