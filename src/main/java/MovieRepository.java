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
            final String[] movie1 = line.split(";");
            final Movie movie = new Movie(movie1[0], movie1[1]);
            movies.add(movie);
        }
    }

    public List<Movie> getAllMovies() {
        // read movies from file
        return movies;
    }

    public Movie getMovieBy(int movieNumber) {
        return movies.get(movieNumber);
    }

    public int count() {
        return movies.size();
    }
}
