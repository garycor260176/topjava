package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int NOT_FOUND = 999999;
    public static final Meal userMeal1 = new Meal(START_SEQ + 3, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "(User) Завтрак", 500);
    public static final Meal userMeal2 = new Meal(START_SEQ + 4, LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "(User) Обед", 1000);
    public static final Meal userMeal3 = new Meal(START_SEQ + 5, LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "(User) Ужин", 500);
    public static final Meal userMeal4 = new Meal(START_SEQ + 6, LocalDateTime.of(2020, Month.JANUARY, 31, 00, 0), "(User) Еда на граничное значение", 100);
    public static final Meal userMeal5 = new Meal(START_SEQ + 7, LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "(User) Завтрак", 1000);
    public static final Meal userMeal6 = new Meal(START_SEQ + 8, LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "(User) Обед", 500);
    public static final Meal userMeal7 = new Meal(START_SEQ + 9, LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "(User) Ужин", 410);
    public static final Meal adminMeal1 = new Meal(START_SEQ + 10, LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "(Admin) Завтрак", 500);
    public static final Meal adminMeal2 = new Meal(START_SEQ + 11, LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "(Admin) Обед", 1000);
    public static final Meal adminMeal3 = new Meal(START_SEQ + 12, LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "(Admin) Ужин", 500);
    public static final Meal adminMeal4 = new Meal(START_SEQ + 13, LocalDateTime.of(2020, Month.JANUARY, 31, 00, 0), "(Admin) Еда на граничное значение", 100);

    public static Meal getNew() {
        return new Meal(LocalDateTime.of(2022, Month.JUNE, 15, 13, 0), "New meal", 800);
    }

    public static Meal getUpdated() {
        Meal updated = new Meal(userMeal1);
        updated.setDateTime(LocalDateTime.of(2022, Month.JUNE, 15, 13, 0));
        updated.setDescription("updated new meal");
        updated.setCalories(900);
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}
