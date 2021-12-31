package com.example.food.controller;

import com.example.food.entity.Food;
import com.example.food.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateFoodServlet extends HttpServlet {

    private JpaRepository<Food> foodJpaRepository = new JpaRepository<>(Food.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/food/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String name = String.valueOf(req.getParameter("name"));
            String idname = String.valueOf(req.getParameter("idname"));
            String description = String.valueOf(req.getParameter("description"));
            String thumbnail = String.valueOf(req.getParameter("thumbnail"));
            int price = Integer.parseInt(req.getParameter("price"));
            String selldate = String.valueOf(req.getParameter("selldate"));
            String editdate = String.valueOf(req.getParameter("editdate"));
            int status = Integer.parseInt(req.getParameter("status"));
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            Food food = new Food(name, idname, description, thumbnail, price, selldate, editdate, status, categoryid);
            System.out.println(food.toString());
            if (food.isValid()){
                foodJpaRepository.save(food);
                resp.sendRedirect("/admin/food/list");
            } else {
                req.setAttribute("thongtinloi", "");
                req.getRequestDispatcher("/admin/food/form.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            resp.getWriter().println();ex.printStackTrace();
        }
    }
}
