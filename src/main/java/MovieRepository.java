import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieRepository {

    private final List<Movie> movies = new ArrayList<>();

    public MovieRepository() throws IOException {
        // read movies from file
        final InputStream movieStream = Main.class.getResourceAsStream("/movies.cvs");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(movieStream));
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final String[] movieData = line.split(";");
            final Movie movie = new Movie(movieData[0], movieData[1], movieData[2]);
            movies.add(movie);
        }
    }

    Movie getById(int movieId) {
        return movies.get(movieId);
    }

    public List<Movie> getAll() {
        return Collections.unmodifiableList(movies);
    }
}
