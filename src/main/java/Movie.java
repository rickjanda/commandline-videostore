public class Movie {
    private final String title;
    private final String type;
    private final int number;

    public Movie(String title, String type, int number) {

        this.title = title;
        this.type = type;
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }
}
