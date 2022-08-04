package controller;

import dao.DepartmentDao;
import dao.StaffDao;
import model.NhanVien;
import model.PhongBan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(urlPatterns = "/staff")
public class StaffServlet extends HttpServlet {

        StaffDao staffDao = new StaffDao();
        DepartmentDao departmentDao = new DepartmentDao();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String action = req.getParameter("action");
            if (action == null) {
                action = "";
            }
            RequestDispatcher dispatcher = null;
            switch (action) {
                case "create":
                    req.setAttribute("phongban", departmentDao.getAll());
                    dispatcher = req.getRequestDispatcher("/create.jsp");
                    dispatcher.forward(req, resp);
                    break;
                case "search":
                    String search = req.getParameter("search");
                    req.setAttribute("nhanviens", staffDao.getAllByName(search));
                    dispatcher = req.getRequestDispatcher("/home.jsp");
                    dispatcher.forward(req, resp);
                    break;
                case "delete":
                    List<NhanVien> nhanViens = staffDao.getAll();
                    int id = Integer.parseInt(req.getParameter("id"));
                    staffDao.delete(id);
                    req.setAttribute("classStudent", nhanViens);
                    resp.sendRedirect("/staff");
                default:
                    req.setAttribute("nhanviens", staffDao.getAll());
                    dispatcher = req.getRequestDispatcher("/home.jsp");
                    dispatcher.forward(req, resp);
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            RequestDispatcher dispatcher = null;
            switch (action) {
                case "create":
                    int id = staffDao.getAll().size() + 1;
                    String name = request.getParameter("name");
                    LocalDate birth = LocalDate.parse(request.getParameter("birth"));
                    String address = request.getParameter("address");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    int idPB = Integer.parseInt(request.getParameter("phongban"));

                    NhanVien nhanVien = new NhanVien(id,name, birth, address,  email,phone, departmentDao.findById(idPB));
                    staffDao.create(nhanVien);
                    resp.sendRedirect("/staff");
                    break;
            }
        }
    }

