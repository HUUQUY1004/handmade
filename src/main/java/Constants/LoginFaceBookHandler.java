//package Constants;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import model.bean.User;
//import model.bean.UserFace;
//import model.dao.UserDAO;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.fluent.Form;
//import org.apache.http.client.fluent.Request;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet(value ="/LoginFaceBookHandler")
//public class LoginFaceBookHandler extends HttpServlet {
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String code = request.getParameter("code");
//        String accessToken = getToken(code);
//        UserFace user = getUserInfo(accessToken);
//        request.setAttribute("userFace",user);
//        System.out.println(user);
//        doPost(request,response);
//    }
//    public static UserFace getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
//        String link = Constants.FACEBOOK_LINK_GET_USER_INFO + accessToken;
//        String response = Request.Get(link).execute().returnContent().asString();
//        UserFace fbAccount= new Gson().fromJson(response, UserFace .class);
//        return fbAccount;
//    }
//    public static String getToken(String code) throws ClientProtocolException, IOException {
//        String response = Request.Post(Constants.FACEBOOK_LINK_GET_TOKEN)
//                .bodyForm(
//                        Form.form()
//                                .add("client_id", Constants.FACEBOOK_CLIENT_ID)
//                                .add("client_secret", Constants.FACEBOOK_CLIENT_SECRET)
//                                .add("redirect_uri", Constants.FACEBOOK_REDIRECT_URI)
//                                .add("code", code)
//                                .build()
//                )
//                .execute().returnContent().asString();
//        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
//        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
//        return accessToken;
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the +
//    // sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     * @param req servlet request
//     * @param resp servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        UserFace user = (UserFace) req.getAttribute("userFace");
//        User checkUser= UserDAO.getUserByEmail(user.getEmail());
//        int role = 1;
//        String status = "Bình Thường";
//        String name = user.getName();
//        String phoneNumber = " ";
//        String email = user.getEmail();
//        String password = "null";
//        if(checkUser == null){
//            UserDAO.inserUserGG(name,phoneNumber,email,password,status,role);
//            User user2= UserDAO.getUserByEmail(user.getEmail());
//            HttpSession session = req.getSession();
//            session.setAttribute("auth", user2);
//            resp.sendRedirect(req.getContextPath() + "/views/MainPage/view_mainpage/mainpage.jsp");
//        }else{
//            User getuser = UserDAO.getUserByEmail(user.getEmail());
//            if(getuser.isLock()){
//                req.setAttribute("result", "Tài khoản đã bị vô hiệu hóa!");
//                req.getRequestDispatcher("./views/Login/view_login/login.jsp").forward(req, resp);
//            }else{
//                HttpSession session = req.getSession();
//                session.setAttribute("auth", getuser);
//                if (getuser.isOwn() || getuser.isAdmin()) {
//                    req.getSession().setAttribute("isAdmin", true);
//                    resp.sendRedirect(req.getContextPath() + "/views/Admin/admin.jsp");
//                } else {
//                    req.getSession().setAttribute("isAdmin", false);
//                    resp.sendRedirect(req.getContextPath() + "/views/MainPage/view_mainpage/mainpage.jsp");
//                }
//            }
//        }
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
