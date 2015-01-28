import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {


    public List<Movie> getAllMovies() throws IOException {
        // read movies from file
        final InputStream movieStream = Main.class.getResourceAsStream("/movies.cvs");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(movieStream));
        final List<Movie> movies = new ArrayList<>();
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final Movie movie = Movie.parseFrom(line);
            movies.add(movie);
        }
        return movies;
    }
}
