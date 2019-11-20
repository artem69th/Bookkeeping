package model;

import exeption.ModelException;

import java.util.Objects;

public class Article extends Common {

    private String title;

    public Article() {

    }

    public Article(String title) throws ModelException {
        if (title.isEmpty()) {
            throw new ModelException(ModelException.TITLE_EMPTY);
        }
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getValueForComboBox() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return title.equals(article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
