package priv.lushiwu.takeout.sys;

import priv.lushiwu.takeout.admin.User;
import priv.lushiwu.takeout.dao.Dao;

import java.util.*;

/**
 * @Author: lushiwu
 * @Date 2021/12/6 18:12
 * 客户id，客户名，性别，密码，送餐地址，手机号，创建时间
 */
public class UserSys implements Dao<User> {
    static Map<String, User> userMap = new HashMap<>();
    List<User> list = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    //添加客户
    @Override
    public void insert(User user) {
        userMap.put(user.getuID(), user);
    }

    //通过ID查找客户
    @Override
    public User findById(String id) {
        if (userMap.get(id) == null) {
            return null;
        } else {
            return userMap.get(id);
        }
    }

    //查看客户列表
    @Override
    public List<User> findAll() {
        Set<String> keys = userMap.keySet(); //获取所有用户的key值
        for (String key : keys) {
            list.add(userMap.get(key)); //把用户遍历添加到列表中
        }
        return list;
    }

    //删除指定id的客户
    @Override
    public void delete(String id) {
        if (userMap.get(id) == null) {
            System.out.println("没有此用户");
        } else{
            User remove = userMap.remove(id);
            System.out.println(remove.getuName() + "用户已删除");
        }
    }

    //修改密码（当前登陆用户的密码）
    public void changePwd(String id) {
        User user = findById(id);
        System.out.println("请输入新密码:");
        String newPwd = in.next();
        User t = new User(user.getuID(), user.getuName(), user.getuSex(), newPwd, user.getuAddress(), user.getuTel(), user.getuTime());
        userMap.put(user.getuID(), t);
    }
}
