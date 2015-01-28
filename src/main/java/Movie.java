public class Movie {
    private final String title;
    private final String type;

    public Movie(String title, String type) {

        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    static Movie parseFrom(String line) {
        final String[] movie = line.split(";");
        return new Movie(movie[0], movie[1]);
    }
}
