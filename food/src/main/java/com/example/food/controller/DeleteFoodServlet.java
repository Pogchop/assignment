package com.example.food.controller;

import com.example.food.entity.Food;
import com.example.food.repository.JpaRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFoodServlet extends HttpServlet {
    JpaRepository<Food> foodJpaRepository = new JpaRepository<>(Food.class);

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Food food = foodJpaRepository.findById(id);
            if (food == null){
                resp.getWriter().println("Food is not found!");
            } else {
                foodJpaRepository.delete(id);
                resp.getWriter().println("Okie");
            }
        } catch (Exception ex){
            ex.printStackTrace();
            resp.getWriter().println("Bad request");
        }
    }
}
