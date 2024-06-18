package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepository;
import ru.javawebinar.topjava.web.meal.MealRestController;
import ru.javawebinar.topjava.web.user.AdminRestController;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 automatic resource management (ARM)
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            adminUserController.create(new User(null, "userName", "email@mail.ru", "password", Role.ADMIN));

            InMemoryUserRepository userRepository = appCtx.getBean(InMemoryUserRepository.class);
            userRepository.save(new User(null, "User1", "user1@mail.ru", "pwd1", Role.USER));
            userRepository.save(new User(null, "User2", "user2@mail.ru", "pwd2", Role.USER));
            System.out.println(userRepository.getAll());
            System.out.println(userRepository.getByEmail("user2@mail.ru"));
            System.out.println(userRepository.getByEmail("qqq@mail.ru"));

            MealRestController mealRestController = appCtx.getBean(MealRestController.class);
            System.out.println(mealRestController.getAll());
        }
    }
}
