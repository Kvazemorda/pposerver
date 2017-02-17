package com.pposerver.entity;

import com.google.gson.Gson;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ppo1_content")
public class Content {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic @Column private String title;
    @Basic @Column private String introtext;
    @Basic @Column private String fulltext;
    @Basic @Column private String images;
    @Temporal(TemporalType.DATE) @Column private Date created;
    @Basic @Column private int state;

    public Content() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntrotext() {
        return introtext;
    }

    public void setIntrotext(String introtext) {

        this.introtext = introtext;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        Gson gson = new Gson();
        ImageJson imageJson = gson.fromJson(images, ImageJson.class);
        this.images = imageJson.getImage_intro();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Content content = (Content) o;

        if (id != content.id) return false;
        if (title != null ? !title.equals(content.title) : content.title != null) return false;
        if (introtext != null ? !introtext.equals(content.introtext) : content.introtext != null) return false;
        if (fulltext != null ? !fulltext.equals(content.fulltext) : content.fulltext != null) return false;
        if (images != null ? !images.equals(content.images) : content.images != null) return false;
        return created != null ? created.equals(content.created) : content.created == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (introtext != null ? introtext.hashCode() : 0);
        result = 31 * result + (fulltext != null ? fulltext.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", introtext='" + introtext + '\'' +
                ", fulltext='" + fulltext + '\'' +
                ", images='" + images + '\'' +
                ", createdBy='" + created + '\'' +
                '}';
    }

}
