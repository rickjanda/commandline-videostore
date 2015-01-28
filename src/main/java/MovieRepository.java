import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private final List<Movie> movies;

    public MovieRepository() throws IOException {
        movies = new ArrayList<>();
        final InputStream movieStream = Main.class.getResourceAsStream("/movies.cvs");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(movieStream));
        int number = 0;
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final String[] movie1 = line.split(";");
            final String title = movie1[0];
            final String type = movie1[1];
            final Movie movie = new Movie(title, type, number);
            movies.add(movie);
            number ++;
        }
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie getMovieBy(int movieNumber) {
        return movies.get(movieNumber);
    }

}
