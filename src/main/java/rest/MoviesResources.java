package rest;

import domain.Comment;
import domain.Movie;
import domain.Rating;
import domain.services.MovieService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class MoviesResources {

    private MovieService db = new MovieService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Movie> getAll()
    {
        return db.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(Movie movie){
        db.add(movie);
        return Response.ok(movie.getId()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Movie result = db.get(id);
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Movie f){
        Movie result = db.get(id);
        if(result==null)
            return Response.status(404).build();
        f.setId(id);
        db.update(f);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id){
        Movie result = db.get(id);
        if(result==null)
            return Response.status(404).build();
        db.delete(result);
        return Response.ok().build();
    }

    @GET
    @Path("/{movieId}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getComments(@PathParam("movieId") int movieId){
        Movie result = db.get(movieId);
        if(result==null)
            return null;
        if(result.getComments()==null)
            result.setComments(new ArrayList<Comment>());
        return result.getComments();
    }

    @POST
    @Path("/{id}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(@PathParam("id") int movieId, Comment comment){
        Movie result = db.get(movieId);
        if(result==null)
            return Response.status(404).build();
        if (result.getComments()==null)
            result.setComments(new ArrayList<Comment>());
        result.getComments().add(comment);
        return Response.ok().build();
    }

    @GET
    @Path("/{movieId}/ratings")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rating> getRatings(@PathParam("movieId") int movieId){
        Movie result = db.get(movieId);
        if(result==null)
            return null;
        if(result.getRatings()==null)
            result.setRatings(new ArrayList<Rating>());
        return result.getRatings();
    }

    @POST
    @Path("/{id}/ratings")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRating(@PathParam("id") int movieId, Rating rating){
        Movie result = db.get(movieId);
        if(result==null)
            return Response.status(404).build();
        if (result.getRatings()==null)
            result.setRatings(new ArrayList<Rating>());
        result.getRatings().add(rating);
        return Response.ok().build();
    }
}
