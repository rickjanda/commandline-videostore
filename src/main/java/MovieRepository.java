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
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final Movie movie = Movie.parseFrom(line);
            movies.add(movie);
        }
    }

    public List<Movie> getAllMovies() {
        // read movies from file
        return movies;
    }
}
