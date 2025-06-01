package controller.admin;

import model.service.OrderService;
import model.bean.OrderImage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/order-custom")
public class OrderCustomAdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String orderIdStr = request.getParameter("orderId");

        try {
            int orderId = Integer.parseInt(orderIdStr);

            if ("confirm".equals(action)) {
                OrderService.getInstance().updateOrderStatus(orderId, 1);
                response.getWriter().write("success");
            } else if ("cancel".equals(action)) {
                OrderService.getInstance().updateOrderStatus(orderId, 4);
                response.getWriter().write("success");
            } else {
                response.getWriter().write("invalid_action");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("error");
        }
    }
}
