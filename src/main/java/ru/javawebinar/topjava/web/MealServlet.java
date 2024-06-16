package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MemoryMealDao;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static final MealDao mealDao = new MemoryMealDao();
    private static final int CALORIES_PER_DAY = 2000;

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        log.debug("MealServlet->doGet | URL {} | Parameters {} ", request.getRequestURL(), request.getQueryString());

        String action = request.getParameter("action");

        switch (action == null ? "" : action) {
            case "delete":
                int id = getId(request);
                mealDao.delete(id);
                response.sendRedirect(request.getContextPath() + "/meals");
                log.debug("Deleted meal with id: {}", id);
                break;
            case "edit":
                id = getId(request);
                request.setAttribute("meal", mealDao.get(id));
                request.getRequestDispatcher("/meal.jsp").forward(request, response);
                log.debug("Go to edit meal with id: {}", id);
                break;
            case "create":
                Meal meal = new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 0);
                request.setAttribute("meal", meal);
                request.getRequestDispatcher("/meal.jsp").forward(request, response);
                log.debug("Go to create meal");
                break;
            default:
                request.setAttribute("meals", MealsUtil.getWithExcess(mealDao.getAll(), CALORIES_PER_DAY));
                request.getRequestDispatcher("/meals.jsp").forward(request, response);
                log.debug("List of meals returned");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        log.debug("MealServlet->doPost | URL {} | Parameters {} ", request.getRequestURL(), request.getQueryString());

        String id = request.getParameter("id");
        Meal meal = new Meal(id.isEmpty() ? null : Integer.parseInt(id),
                LocalDateTime.parse(request.getParameter("dateTime")), request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));
        if (id.isEmpty()) {
            meal = mealDao.create(meal);
            log.debug("Created meal with id:{}", meal.getId());
        } else {
            meal = mealDao.update(meal);
            if (meal != null) {
                log.debug("Updated meal with id:{}", meal.getId());
            } else {
                log.debug("Error updated meal with id: {}", id);
            }
        }
        response.sendRedirect(request.getContextPath() + "/meals");
    }

    private int getId(HttpServletRequest request) {
        return Integer.parseInt(request.getParameter("id"));
    }
}