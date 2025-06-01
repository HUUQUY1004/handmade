package model.dao;

import model.bean.PreOrder;
import model.db.JDBIConnector;

import java.util.Date;
import java.util.Optional;

public class PreOrderDAO {
    public static PreOrder getPreOrderById(int id) {
        Optional<PreOrder> preOrder = JDBIConnector.me().withHandle(handle ->
                handle.createQuery("SELECT pror.id, prod.name, FROM pre_order pror WHERE id = id")
                        .bind("id", id)
                        .mapToBean(PreOrder.class)
                        .stream().findFirst());
        return preOrder.isEmpty() ? null : preOrder.get();
    }

    public static void addPreOrder(int id, int amount, Date dateEnd) {
        JDBIConnector.me().useHandle(handle ->
                handle.createUpdate("INSERT INTO pre_order (id, amount, date_end) VALUES (:id, :amount, :dateEnd)")
                        .bind("id", id)
                        .bind("amount", amount)
                        .bind("dateEnd", dateEnd)
                        .execute()
        );
    }
    public static void removePreOrderById(int id){
        JDBIConnector.me().useHandle(handle ->
                handle.createUpdate("DELETE * FROM pre_order WHERE id=:id")
                        .execute());
    }
}


