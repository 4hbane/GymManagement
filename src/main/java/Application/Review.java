package Application;

public class Review {
    String userEmail;
    String coachEmail;
    String reviewText;

    public Review() {
        userEmail = "";
        coachEmail = "";
        reviewText = "";
    }


    public Review(String userEmail, String coachEmail, String reviewText) {
        this.userEmail = userEmail;
        this.coachEmail = coachEmail;
        this.reviewText = reviewText;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCoachEmail() {
        return coachEmail;
    }

    public void setCoachEmail(String coachEmail) {
        this.coachEmail = coachEmail;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }


    @Override
    public String toString() {
        return "Review{" +
                "from ='" + userEmail + '\'' +
                ", Review Text='" + reviewText + '\'' +
                '}';
    }
}
