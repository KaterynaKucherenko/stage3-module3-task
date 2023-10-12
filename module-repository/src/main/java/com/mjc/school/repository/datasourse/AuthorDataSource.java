package com.mjc.school.repository.datasourse;

import com.mjc.school.repository.model.AuthorModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorDataSource {
    private List<AuthorModel> authorModelList;
    private static Long increment = 1L;

    @Autowired
    public AuthorDataSource() {
        fillAuthors();
    }

    private void fillAuthors() {
        try (BufferedReader bufferedReaderForAuthor = new BufferedReader(new FileReader("module-repository/src/main/resources/authors"))) {
            String line;
            this.authorModelList = new ArrayList<>();
            while ((line = bufferedReaderForAuthor.readLine()) != null) {
                this.authorModelList.add(new AuthorModel(increment++, line, LocalDateTime.now(), LocalDateTime.now()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<AuthorModel> getAuthorModelList() {
        return authorModelList;
    }

    public AuthorModel getAuthorId(Long id) {
        if (id > 0 && id <= authorModelList.size()) {
            int tmp = (id.intValue());
            return authorModelList.get(tmp - 1);
        }
        return null;
    }

    public Long getLastAuthorId() {
        Long id = this.authorModelList.size() + 1L;
        return id;
    }
}