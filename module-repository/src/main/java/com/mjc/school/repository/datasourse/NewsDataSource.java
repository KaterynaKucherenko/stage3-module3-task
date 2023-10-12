package com.mjc.school.repository.datasourse;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.model.NewsModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewsDataSource {
    private AuthorDataSource authorDataSource;
    private List<NewsModel> newsModelList;
    private static Long newsIncr = 1L;

    @Autowired
    public NewsDataSource(AuthorDataSource authorDataSource) {
        this.authorDataSource = authorDataSource;
        fillNews();

    }

    private void fillNews() {
        try (BufferedReader bufferedReaderForContent = new BufferedReader(new FileReader("module-repository/src/main/resources/content")); BufferedReader bufferedReaderForTitle = new BufferedReader(new FileReader("module-repository/src/main/resources/news"))) {
            List<String> content = new ArrayList<>();
            String line0;
            newsModelList = new ArrayList<>();
            while ((line0 = bufferedReaderForContent.readLine()) != null) {
                content.add(line0);
            }
            List<String> title = new ArrayList<>();
            String line;
            while ((line = bufferedReaderForTitle.readLine()) != null) {
                title.add(line);
            }
            for (int x = 0; x < title.size(); x++) {
                this.newsModelList.add(new NewsModel(newsIncr++, title.get(x), content.get(x), LocalDateTime.now(), LocalDateTime.now(), authorDataSource.getAuthorModelList().get(x).getId()));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}