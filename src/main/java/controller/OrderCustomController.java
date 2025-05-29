package controller;

import model.bean.Category;
import model.bean.Image;
import model.bean.Product;
import model.dao.ProductDAO;
import model.service.CategoryService;
import model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/order-custom")
public class OrderCustomController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = ProductService.getInstance().getProductById(id);
        Image mainImage = ProductDAO.getImagesForProduct(id).get(0);
        Category category = CategoryService.getInstance().getCategoryById(product.getCategoryId());

        req.setAttribute("productById", product);
        req.setAttribute("mainImage",mainImage );
        req.setAttribute("categoryByProduct", category);


        req.getRequestDispatcher("views/order-custom/order-custom.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
