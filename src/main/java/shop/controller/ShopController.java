package shop.controller;

import org.springframework.web.bind.annotation.*;
import shop.model.Buyer;
import shop.model.Goods;
import shop.model.MyException;
import shop.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {

    GoodsService goodsService;
    Buyer buyer;
    List<Goods> basketGoods = new ArrayList<Goods>();

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/")
    public ModelAndView loadStartPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("buyer", buyer);
        return modelAndView;
    }

    @GetMapping("/goods/get")
    public ModelAndView loadGoods() throws MyException {
        List<Goods> goods = goodsService.allGoods();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("goods");
        modelAndView.addObject("goodsList", goods);
        modelAndView.addObject("buyer", buyer);
        return modelAndView;
    }

    //add
    @GetMapping("/goods/new")
    public ModelAndView createGood() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addGoods");
        return modelAndView;
    }

    @PostMapping("/goods/add")
    public ModelAndView addGoods(@ModelAttribute("goods") Goods goods) throws MyException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/goods");
        goodsService.save(goods);
        return modelAndView;
    }

    @DeleteMapping(value="/goods/delete/{id}")
    public ModelAndView deleteGoods(@PathVariable("id") int id) throws MyException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/goods");
        Goods goods = goodsService.find(id);
        goodsService.delete(goods);
        return modelAndView;
    }

    @GetMapping("/profile/new")
    public ModelAndView loadProfile() throws MyException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addProfile");
        modelAndView.addObject("buyer", buyer);
        return modelAndView;
    }

    @PostMapping("/profile/add")
    public ModelAndView addProfile(@ModelAttribute("newBuyer") Buyer newBuyer) throws MyException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        buyer = newBuyer;
        modelAndView.addObject("buyer", buyer);
        return modelAndView;
    }

    @GetMapping("/profile/get")
    public ModelAndView buyerProfile() throws MyException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        modelAndView.addObject("buyer", buyer);
        return modelAndView;
    }

    @GetMapping("/goods/addBasket/{id}")
    public ModelAndView addBasket(@PathVariable("id") int id) throws MyException {
        Goods goods = goodsService.find(id);
        if (!goodsService.check(goods, basketGoods))
            basketGoods.add(goods);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/goods");
        return modelAndView;
    }

    @GetMapping("/basket/get")
    public ModelAndView loadBasket() throws MyException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("basket");
        modelAndView.addObject("buyer", buyer);
        modelAndView.addObject("basketGoods", basketGoods);
        return modelAndView;
    }

    @DeleteMapping("/basket/delete/{id}")
    public ModelAndView deleteBasket(@PathVariable("id") int id) throws MyException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/basket");
        Goods goods = goodsService.find(id);
        basketGoods = goodsService.basketDelete(goods, basketGoods);
        return modelAndView;
    }
}
