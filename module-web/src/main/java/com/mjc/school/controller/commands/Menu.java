//package com.mjc.school.controller.commands;
//
//import com.mjc.school.controller.commands.commandImpl.*;
//import com.mjc.school.controller.impl.AuthorController;
//import com.mjc.school.controller.impl.NewsController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Scanner;
//
//@Component
//public class Menu {
//    private final NewsController newsController;
//    private final AuthorController authorController;
   // private final Invoker invoker;

//    @Autowired
//    public Menu(NewsController newsController, AuthorController authorController, Invoker invoker) {
//        this.newsController = newsController;
//        this.authorController = authorController;
//        this.invoker = invoker;
//
//    }
//
//
//    public void start() {
//        while (true) {
//            System.out.println("OPERATIONS WITH NEWS: " + "\n" +
//                    "1 - read all news" + "\n" +
//                    "2 - read news by ID" + "\n" +
//                    "3 - create news" + "\n" +
//                    "4 - update news" + "\n" +
//                    "5 - delete news by ID" + "\n" +
//                    "OPERATIONS WITH AUTHORS: " + "\n" +
//                    "6 - read all authors" + "\n" +
//                    "7 - read author by ID" + "\n" +
//                    "8 - create author" + "\n" +
//                    "9 - update author" + "\n" +
//                    "10 - delete author by ID" + "\n" +
//                    "0 - exit");
//            Scanner scanner = new Scanner(System.in);
//            int button = scanner.nextInt();
//            switch (button) {
//                case 1 -> invoker.setCommand(new GetAllNews(newsController));
//                case 2 -> invoker.setCommand(new ReadNewsById(newsController));
//                case 3 -> invoker.setCommand(new CreateNews(newsController));
//                case 4 -> invoker.setCommand(new UpdateNews(newsController));
//                case 5 -> invoker.setCommand(new DeleteNews(newsController));
//                case 6 -> invoker.setCommand(new GetAllAuthors(authorController));
//                case 7 -> invoker.setCommand(new ReadAuthorById(authorController));
//                case 8 -> invoker.setCommand(new CreateAuthor(authorController));
//                case 9 -> invoker.setCommand(new UpdateAuthor(authorController));
//                case 10 -> invoker.setCommand(new DeleteAuthor(authorController, newsController));
//                case 0 -> System.exit(0);
//
//            }
//        }
//    }
//}