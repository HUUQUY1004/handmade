package controller;

import model.bean.*;
import model.dao.OrderDAO;
import model.dao.ProductDAO;
import model.service.CategoryService;
import model.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@WebServlet("/order-custom")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class OrderCustomController extends HttpServlet {
    private static final String SAVE_DIR = "images/custom";

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
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("auth");

        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String note = req.getParameter("note");
        String tel = req.getParameter("tel");


        int productId = Integer.parseInt(req.getParameter("productId"));

        String realPath = getServletContext().getRealPath("") + File.separator + SAVE_DIR;
        File uploadDir = new File(realPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        String projectPath = System.getProperty("user.dir") + File.separator +
                "src" + File.separator +
                "main" + File.separator +
                "webapp" + File.separator +
                SAVE_DIR;
        File projectDir = new File(projectPath);
        if (!projectDir.exists()) projectDir.mkdirs();
        Collection<Part> parts = req.getParts();
        List<String> savedImagePaths = new ArrayList<>();

        int count = 1;

        for (Part part : parts) {
            if (part.getName().equals("path") && part.getSize() > 0) {

                String originalFileName = part.getSubmittedFileName();
                if (originalFileName == null) {
                    originalFileName = "image.jpg";
                }

                String fileNameWithoutExt = originalFileName.contains(".")
                        ? originalFileName.substring(0, originalFileName.lastIndexOf('.'))
                        : originalFileName;
                String extension = originalFileName.contains(".")
                        ? originalFileName.substring(originalFileName.lastIndexOf('.'))
                        : ".jpg";

                String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

                String filename = user.getName() + "_" + productId + "_" + date + "_" + count + extension;

                String savePath = realPath + File.separator + filename;
                part.write(savePath);
                savedImagePaths.add(SAVE_DIR + "/" + filename);

                File uploadedFile = new File(realPath, filename);
                File destinationFile = new File(projectPath, filename);

                try {
                    Files.copy(uploadedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                count++;
            }
        }

        Order order = new Order();
        order.setUserId(user.getId());
        order.setNote(note);
        order.setConsigneePhoneNumber(tel);
        order.setStatus(4);


        req.setAttribute("success", true);
        req.getRequestDispatcher("/views/order-custom/custom_response.jsp").forward(req, resp);
    }
}
