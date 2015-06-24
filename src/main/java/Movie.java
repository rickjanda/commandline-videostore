public class Movie {
    private final int key;
    private final String name;
    private final String category;

    public Movie(int key, String name, String category) {

        this.key = key;
        this.name = name;
        this.category = category;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
