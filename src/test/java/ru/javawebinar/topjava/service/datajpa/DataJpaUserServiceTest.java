package ru.javawebinar.topjava.service.datajpa;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserServiceTest;

import static ru.javawebinar.topjava.UserTestData.*;

@ActiveProfiles(Profiles.DATAJPA)
public class DataJpaUserServiceTest extends UserServiceTest {
    @Test
    public void getWithMeals() {
        User withMealsDb = service.getWithMeals(USER_ID);
        User withMeals = new User(user);
        withMeals.setMeals(MealTestData.meals);
        USER_WITH_MEALS_MATCHER.assertMatch(withMealsDb, withMeals);
    }
}