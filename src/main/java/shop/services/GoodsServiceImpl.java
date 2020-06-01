package shop.services;

import shop.DAO.GoodsDAO;
import shop.DAO.GoodsDAOImpl;
import shop.model.Goods;
import shop.model.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    private GoodsDAO goodsDAO;

    @Autowired
    public void setGoodsDao(GoodsDAOImpl goodsDAO) {
        this.goodsDAO = goodsDAO;
    }

    public GoodsServiceImpl() {
    }

    @Override
    @Transactional
    public List<Goods> allGoods() {
        return goodsDAO.allGoods();
    }

    @Transactional
    public void save(Goods goods) throws MyException {
        goodsDAO.save(goods);
    }

    @Transactional
    public void delete(Goods goods) throws MyException {
        goodsDAO.delete(goods);
    }

    @Transactional
    public void update(Goods goods) throws MyException {
        goodsDAO.update(goods);
    }

    @Transactional
    public Goods find(int id) throws MyException {
        return goodsDAO.findById(id);
    }

    public boolean check(Goods goods, List<Goods> basketGoods) {
        for (Goods g: basketGoods) {
            if (g.getName().equals(goods.getName()))
                return true;
        }
        return false;
    }

    public List<Goods> basketDelete(Goods goods, List<Goods> basketGoods){
        List<Goods> tmp = new ArrayList<Goods>();
        for (Goods g: basketGoods) {
            if (!g.getName().equals(goods.getName()))
                tmp.add(g);
        }
        return tmp;
    }
}
