package com.mjc.school.controller.commands;

import com.mjc.school.controller.annotation.CommandHandler;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.controller.impl.TagsController;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.TagDtoRequest;
import com.mjc.school.service.dto.TagDtoResponse;
import com.mjc.school.service.implementation.AuthorServiceImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class ControllerHandler {
    private AuthorController authorController;
    private NewsController newsController;
    private TagsController tagsController;
    private Scanner scanner = new Scanner(System.in);


    public ControllerHandler(AuthorController authorController, NewsController newsController, TagsController tagsController) {
        this.authorController = authorController;
        this.newsController = newsController;
    }

    @CommandHandler("1")
    public void readAll() {
        newsController.readAll().forEach(System.out::println);
    }

    @CommandHandler("2")
    public void readById() {
        System.out.println("Write the news ID");
        System.out.println(newsController.readById(Long.parseLong(scanner.nextLine())));
    }

    @CommandHandler("3")
    public void createNews() {
        boolean isValid = false;
        if (!isValid) {
            try {
                System.out.println("Write the news title");
                String title = scanner.nextLine();
                System.out.println("Write the news content");
                String content = scanner.nextLine();
                System.out.println("Write the author ID");
                Long authId = Long.parseLong(scanner.nextLine());
                System.out.println("Write tags ID");
                List<Long> tags = List.of(Long.parseLong(Arrays.toString(scanner.nextLine().split(" "))));
                NewsDtoRequest newsDtoRequest = new NewsDtoRequest(null, title, content, authId, tags);
                System.out.println(newsController.create(newsDtoRequest));
            } catch (Exception e) {
                e.getMessage();
            }

        }
    }

    @CommandHandler("4")
    public void updateNews() {
        boolean isValid = false;
        if (!isValid) {
            try {
                System.out.println("Write the news ID for updating");
                Long newsId = Long.parseLong(scanner.nextLine());
                System.out.println("Write the new news title");
                String title = scanner.nextLine();
                System.out.println("Write the new news content");
                String content = scanner.nextLine();
                System.out.println("Write the new author ID");
                Long authId = Long.parseLong(scanner.nextLine());
                System.out.println("Write new tags ID");
                List<Long> tags = List.of(Long.parseLong(Arrays.toString(scanner.nextLine().split(" "))));
                NewsDtoRequest newsDtoRequest = new NewsDtoRequest(newsId, title, content, authId, tags);
                System.out.println(newsController.update(newsDtoRequest));
            } catch (Exception e) {
                e.getMessage();
            }

        }
    }

    @CommandHandler("5")
    public void deleteNews() {
        System.out.println("Write the news ID for delete");
        if (newsController.deleteById(Long.parseLong(scanner.nextLine()))) {
            System.out.println("News was deleted");
        } else {
            System.out.println("News wasn't deleted");
        }
    }

    @CommandHandler("6")
    public void readAllAuthors() {
        authorController.readAll().forEach(System.out::println);
    }

    @CommandHandler("7")
    public void readAuthorById() {
        System.out.println("Write the author ID");
        System.out.println(authorController.readById(Long.parseLong(scanner.nextLine())));
    }

    @CommandHandler("8")
    public void createAuthor() {
        boolean isValid = false;
        if (!isValid) {
            try {
                System.out.println("Write the author name");
                String name = scanner.nextLine();
                AuthorDtoRequest authorDtoRequest = new AuthorDtoRequest(null, name, null);
                System.out.println(authorController.create(authorDtoRequest));
            } catch (Exception e) {
                e.getMessage();
            }


        }
    }

    @CommandHandler("9")
    public void updateAuthor() {
        boolean isValid = false;
        if (!isValid) {
            try {
                System.out.println("Write the author ID for updating");
                Long authId = Long.parseLong(scanner.nextLine());
                System.out.println("Write the new author name");
                String name = scanner.nextLine();
                authorController.update(new AuthorDtoRequest(authId, name, null));
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    @CommandHandler("10")
    public void deleteAuthor() {
        System.out.println("Write the author ID for delete");
        if (authorController.deleteById(Long.parseLong(scanner.nextLine()))) {
            System.out.println("Author was deleted");
        } else {
            System.out.println("Author wasn't deleted");
        }
    }

}



