public class Movie {
    private final String id;
    private final String name;
    private final String year;

    public Movie(String id, String name, String year) {

        this.id = id;
        this.name = name;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return year;
    }
}
