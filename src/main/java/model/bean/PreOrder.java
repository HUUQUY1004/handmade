package model.bean;

import java.util.Date;

public class PreOrder {
    private int id;
    private int amount;
    private String productName;
    private Date dateEnd;

    public PreOrder() {
    }
    public PreOrder(int id, int amount, Date dateEnd) {
        this.id = id;
        this.amount = amount;
        this.dateEnd = dateEnd;
    }
    public PreOrder(int id, int amount, String productName, Date dateEnd) {
        this.id = id;
        this.amount = amount;
        this.productName = productName;
        this.dateEnd = dateEnd;
    }
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getAmount() {return amount;}
    public void setAmount(int amount) {this.amount = amount;}
    public Date getDateEnd() {return dateEnd;}
    public void setDateEnd(Date dateEnd) {this.dateEnd = dateEnd;}
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "PreOrder{" +
                "id=" + id +
                ", amount=" + amount +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
