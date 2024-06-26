package tech.wetech.flexmodel.infrastructrue;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cjbi
 */
@Slf4j
@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {

  @Override
  public Response toResponse(Exception e) {
    log.error("Handle exception, message={}", e.getMessage(), e);
    return getDefaultResponse(e);
  }

  public static Response getDefaultResponse(Exception e) {
    Map<String, Object> body = new HashMap<>();
    body.put("code", -1);
    body.put("message", e.getMessage());
    body.put("success", false);
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(body).build();
  }

}
