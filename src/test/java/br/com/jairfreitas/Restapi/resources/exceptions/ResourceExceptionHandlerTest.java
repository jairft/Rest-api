package br.com.jairfreitas.Restapi.resources.exceptions;

import br.com.jairfreitas.Restapi.services.exceptons.DataIntegrityViolationException;
import br.com.jairfreitas.Restapi.services.exceptons.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResourceExceptionHandlerTest {

    @InjectMocks
    private ResourceExceptionHandler exceptionHandler;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void resourceNotFound() {
        ResponseEntity<StandardErro> response = exceptionHandler
                .resourceNotFound(
                        new ResourceNotFoundException("Recurso não encontardo"),
                        new MockHttpServletRequest());


        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardErro.class, response.getBody().getClass());
        assertEquals("Recurso não encontardo", response.getBody().getError());
        assertEquals(404, response.getBody().getStatus());
        assertNotEquals("/user/2", response.getBody().getPath());
        assertNotEquals(Instant.now(), response.getBody().getTimestamp());
    }

    @Test
    void dataIntegrityViolationException() {
        ResponseEntity<StandardErro> response = exceptionHandler
                .dataIntegrityViolationException(
                        new DataIntegrityViolationException("E-mail já cadastrado"),
                        new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardErro.class, response.getBody().getClass());
        assertEquals("E-mail já cadastrado", response.getBody().getError());
        assertEquals(400, response.getBody().getStatus());
    }
}