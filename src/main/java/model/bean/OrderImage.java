package model.bean;

import java.util.Date;

public class OrderImage {

    private int id;

    private int userId;

    private String imagePath;

    private int productId;

    private Date orderDate;

    private String tel;

    private String note;

    private int status;

    public OrderImage() {
    }

    public OrderImage(int id, int userId, String imagePath, int productId, Date orderDate, String tel, String note, int status) {
        this.id = id;
        this.userId = userId;
        this.imagePath = imagePath;
        this.productId = productId;
        this.orderDate = orderDate;
        this.tel = tel;
        this.note = note;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isWaitConfirmOrder() {
        return this.getStatus() == 0;
    }

    public boolean isPreparing() {
        return this.getStatus() == 1;
    }

    public boolean isDeliveringOrder() {
        return this.getStatus() == 2;
    }

    public boolean isSucccessfulOrder() {
        return this.getStatus() == 3;
    }

    public boolean isCanceledOrder() {
        return this.getStatus() == 4;
    }

    public String getStatusAsName() {
        String re = null;
        if (this.isWaitConfirmOrder()) {
            re = "Cần xác nhận";
        } else if (this.isPreparing()) {
            re = "Đang đóng gói";
        } else if (this.isDeliveringOrder()) {
            re = "Đang giao";
        } else if (this.isCanceledOrder()) {
            re = "Đã hủy";
        } else if (this.isSucccessfulOrder()) {
            re = "Thành công";
        }
        return re;
    }
    public String getStatusAsColor(){
        String backgroundColor = null;
        if (this.isWaitConfirmOrder()) {
            backgroundColor = "#ffcc00";
        } else if (this.isPreparing()) {
            backgroundColor = "cadetblue";
        } else if (this.isDeliveringOrder()) {
            backgroundColor = "#0171d3";
        } else if (this.isCanceledOrder()) {
            backgroundColor = "#ff0000";
        } else if (this.isSucccessfulOrder()) {
            backgroundColor = "#4d8a54";
        }
        return backgroundColor;
    }

    @Override
    public String toString() {
        return "OrderImage{" +
                "id=" + id +
                ", imagePath='" + imagePath + '\'' +
                ", productId=" + productId +
                ", orderDate=" + orderDate +
                ", tel='" + tel + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
