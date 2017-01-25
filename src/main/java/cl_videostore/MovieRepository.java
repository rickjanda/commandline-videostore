package cl_videostore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MovieRepository {

    private Map<Integer, Movie> movies;

    public MovieRepository() throws IOException {
        // read movies from file
        final InputStream movieStream = Main.class.getResourceAsStream("/movies.cvs");
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(movieStream));
        movies = new HashMap<>();
        while (bufferedReader.ready()) {
            final String line = bufferedReader.readLine();
            final String[] movieData = line.split(";");
            Movie movie = new Movie(Integer.parseInt(movieData[0]), movieData[1], movieData[2]);
            movies.put(movie.getKey(), movie);
        }
    }

    public Collection<Movie> getAllMovies() {
        return movies.values();
    }

    public Movie getByKey(int key) {
        return movies.get(key);
    }
}
