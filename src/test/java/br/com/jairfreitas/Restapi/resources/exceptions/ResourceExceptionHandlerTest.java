package br.com.jairfreitas.Restapi.resources.exceptions;

import br.com.jairfreitas.Restapi.services.exceptons.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

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
    }

    @Test
    void dataIntegrityViolationException() {
    }
}