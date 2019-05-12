package domain;

import java.util.Date;
import java.util.List;

public class Movie {

    private int id;
    private String title;
    private List<Comment> comments;
    private List<Rating> ratings;
    private int ratingsAverage;
    private int productionYear;
    private String productionCountry;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public int getRatingsAverage() {
        return ratingsAverage;
    }

    public void setRatingsAverage(int ratingsAverage) {
        this.ratingsAverage = ratingsAverage;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public void setProductionCountry(String productionCountry) {
        this.productionCountry = productionCountry;
    }
}
