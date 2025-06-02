package model.service;

import model.bean.PreOrder;
import model.dao.PreOrderDAO;

import java.util.Date;
import java.util.List;

public class PreOrderService {
    public static PreOrderService instance;
    public static PreOrderService getInstance(){
        if(instance==null) instance = new PreOrderService();
        return instance;
    }
    public static PreOrder getPreOrderById(int id){return PreOrderDAO.getPreOrderById(id);}
    public static void addPreOrder(int id, int amount, Date dateEnd){PreOrderDAO.addPreOrder(id, amount, dateEnd);}
    public static void removePreOrderById(int id){PreOrderDAO.removePreOrderById(id);}
    public static List<PreOrder> getAllPreOrder(){return PreOrderDAO.getAllPreOrder();}
}
