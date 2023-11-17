package com.mjc.school.controller.commands;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.BaseNewsController;
import com.mjc.school.controller.annotation.CommandHandler;
import com.mjc.school.controller.impl.AuthorController;
import com.mjc.school.controller.impl.NewsController;
import com.mjc.school.controller.impl.TagsController;
import com.mjc.school.service.dto.*;
import com.mjc.school.service.implementation.AuthorServiceImpl;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class ControllerHandler {
    private BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;
    private BaseNewsController newsController;
    private BaseController<TagDtoRequest, TagDtoResponse, Long> tagsController;


    public ControllerHandler(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController, BaseNewsController newsController, BaseController<TagDtoRequest, TagDtoResponse, Long> tagsController) {
        this.authorController = authorController;
        this.newsController = newsController;
        this.tagsController = tagsController;
    }

    @CommandHandler("1")
    public void readAll() {
        newsController.readAll().forEach(System.out::println);
    }

    @CommandHandler(value = "2")
    public void readById() {
        System.out.println("Write the news ID");
        Scanner scanner = new Scanner(System.in);
        System.out.println(newsController.readById(Long.parseLong(scanner.nextLine())));
    }

    @CommandHandler(value = "3")
    public void createNews() {
        boolean isValid = false;
        if (!isValid) {
            try {
                Scanner scanner = new Scanner(System.in);
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

    @CommandHandler(value = "4")
    public void updateNews() {
        boolean isValid = false;
        if (!isValid) {
            try {
                Scanner scanner = new Scanner(System.in);
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

    @CommandHandler(value = "5")
    public void deleteNews() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the news ID for delete");
        if (newsController.deleteById(Long.parseLong(scanner.nextLine()))) {
            System.out.println("News was deleted");
        } else {
            System.out.println("News wasn't deleted");
        }
    }

    @CommandHandler(value = "6")
    public void getNewsByParams() {
        boolean isValid = false;
        List<NewsDtoRequest> result = new ArrayList<>();
        if (!isValid) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Write the tags name for search news (press Enter to skip parameter)");
                String tagName = scanner.nextLine();
                System.out.println("Write the tags ID for search news (press Enter to skip parameter)");
                Long tagId = Long.parseLong(scanner.nextLine());
                System.out.println("Write the author`s name for search news (press Enter to skip parameter)");
                String authorName = scanner.nextLine();
                System.out.println("Write the title for search news (press Enter to skip parameter)");
                String title = scanner.nextLine();
                System.out.println("Write the content for search news (press Enter to skip parameter)");
                String content = scanner.nextLine();
                newsController.getNewsByParams(tagName, tagId, authorName, title, content).stream().forEach(System.out::println);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    @CommandHandler(value = "7")
    public void readAllAuthors() {
        authorController.readAll().forEach(System.out::println);
    }

    @CommandHandler(value = "8")
    public void readAuthorById() {
        System.out.println("Write the author ID");
        Scanner scanner = new Scanner(System.in);
        System.out.println(authorController.readById(Long.parseLong(scanner.nextLine())));
    }

    @CommandHandler(value = "9")
    public void createAuthor() {
        boolean isValid = false;
        if (!isValid) {
            try {
                System.out.println("Write the author name");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.nextLine();
                AuthorDtoRequest authorDtoRequest = new AuthorDtoRequest(null, name, null);
                System.out.println(authorController.create(authorDtoRequest));
            } catch (Exception e) {
                e.getMessage();
            }


        }
    }

    @CommandHandler(value = "10")
    public void updateAuthor() {
        boolean isValid = false;
        if (!isValid) {
            try {
                Scanner scanner = new Scanner(System.in);
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

    @CommandHandler(value = "11")
    public void deleteAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the author ID for delete");
        if (authorController.deleteById(Long.parseLong(scanner.nextLine()))) {
            System.out.println("Author was deleted");
        } else {
            System.out.println("Author wasn't deleted");
        }
    }

    @CommandHandler(value = "12")
    public void getAllTags() {
        tagsController.readAll().forEach(System.out::println);
    }

    @CommandHandler(value = "13")
    public void readTagsById() {
        System.out.println("Write the tags ID");
        Scanner scanner = new Scanner(System.in);
        System.out.println(tagsController.readById(Long.parseLong(scanner.nextLine())));
    }

    @CommandHandler(value = "14")
    public void createTags() {
        boolean isValid = false;
        if (!isValid) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Write the tag name");
                String name = scanner.nextLine();
                TagDtoRequest tagDtoRequest = new TagDtoRequest(null, name);
                System.out.println(tagsController.create(tagDtoRequest));
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }

    @CommandHandler(value = "15")
    public void updateTags() {
        boolean isValid = false;
        if (!isValid) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Write the tag's ID for updating");
                Long id = Long.parseLong(scanner.nextLine());
                System.out.println("Write the new tag name");
                String name = scanner.nextLine();
                TagDtoRequest tagDtoRequest = new TagDtoRequest(id, name);
                System.out.println(tagsController.update(tagDtoRequest));
            } catch (Exception e) {
                e.getMessage();
            }
        }

    }

    @CommandHandler(value = "16")
    public void deleteTags() {
        System.out.println("Write the tag ID for delete");
        Scanner scanner = new Scanner(System.in);
        if (tagsController.deleteById(Long.parseLong(scanner.nextLine()))) {
            System.out.println("Tag was deleted");
        } else {
            System.out.println("Tag wasn't deleted");
        }
    }
}


