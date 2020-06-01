package shop.services;

import shop.model.Goods;
import shop.model.MyException;

import java.util.List;

public interface GoodsService {
    List<Goods> allGoods();
    void save(Goods goods) throws MyException;
    void delete(Goods goods) throws MyException;
    void update(Goods goods) throws MyException;
    Goods find(int id) throws MyException;
    boolean check(Goods goods, List<Goods> basketGoods);
    List<Goods> basketDelete(Goods goods, List<Goods> basketGoods);
}
