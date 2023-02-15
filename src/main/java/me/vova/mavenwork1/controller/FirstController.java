package me.vova.mavenwork1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping
    public String runProject() {
        return "Приложение запущено!";
    }

    @GetMapping("/info")
    public String info() {
        String nameProject = "Мавен";
        String projectDescription = "Функции проекта: Обработка GET-запросов. " +
                "Технологии: спринг, мавен. Язык: java.";
        return "Имя ученика - Владимир.</br> " +
                " Имя проекта - " + nameProject +
                " Дата создания - " + "07.02.2023" +
                " Описание проекта - " + projectDescription;
    }
}
