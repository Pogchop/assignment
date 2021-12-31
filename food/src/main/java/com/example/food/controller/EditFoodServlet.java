package com.example.food.controller;

import com.example.food.entity.Food;
import com.example.food.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class EditFoodServlet extends HttpServlet {
    JpaRepository<Food> foodJpaRepository = new JpaRepository<>(Food.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = parseInt(req.getParameter("id"));
            Food food = foodJpaRepository.findById(id);
            if (food == null){
                resp.getWriter().println("Food is not found!");
            } else {
                req.setAttribute("food", food);
                req.getRequestDispatcher("/admin/food/edit.jsp").forward(req, resp);
            }
        } catch (Exception ex){
            ex.printStackTrace();
            resp.getWriter().println("Bad request");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            int id = parseInt(req.getParameter("id"));
            Food food = foodJpaRepository.findById(id);
            if (food == null) {
                resp.getWriter().println("Product is not found or has been deleted");
            } else {
                String name = req.getParameter("name");
                String idname = req.getParameter("idname");
                String description = req.getParameter("description");
                String thumbnail = req.getParameter("thumbnail");
                int price = parseInt(req.getParameter("price"));
                String selldate = req.getParameter("selldate");
                String editdate = req.getParameter("editdate");
                int status = Integer.parseInt(req.getParameter("status"));
                food.setName(name);
                food.setIdname(idname);
                food.setDescription(description);
                food.setThumbnail(thumbnail);
                food.setPrice(price);
                food.setSelldate(selldate);
                food.setEditdate(editdate);
                food.setStatus(status);
                foodJpaRepository.update(food);
                resp.sendRedirect("/admin/food/list");
            }
        } catch (Exception ex){
            resp.getWriter().println("Bad request");
        }
    }
}
