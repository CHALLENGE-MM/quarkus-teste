package challenge.fiap.mappers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import challenge.fiap.dtos.ExceptionDto;
import jakarta.ws.rs.core.MediaType;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ExceptionDto(exception.toString(), exception.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
