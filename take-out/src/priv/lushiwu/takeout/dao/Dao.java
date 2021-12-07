package priv.lushiwu.takeout.dao;

import java.util.List;

/**
 * @Author: lushiwu
 * @Date 2021/12/6 17:44
 */
public interface Dao<T> {
    void insert(T t);
    T findById(String id);
    List<T> findAll();
    void delete(String id);
}
