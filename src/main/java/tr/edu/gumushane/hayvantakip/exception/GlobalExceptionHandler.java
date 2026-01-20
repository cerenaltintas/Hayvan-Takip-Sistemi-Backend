package tr.edu.gumushane.hayvantakip.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

<<<<<<< HEAD
@ControllerAdvice 
public class GlobalExceptionHandler {

=======
@ControllerAdvice // Rubric Item: Global Hata Yakalayıcı
public class GlobalExceptionHandler {

    // Animal için hata işleyici
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @ExceptionHandler 
    public ResponseEntity<AnimalErrorResponse> handleException(AnimalNotFoundException exc) {

        AnimalErrorResponse error = new AnimalErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exc.getMessage(),
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

<<<<<<< HEAD
=======
    // Veteriner için hata işleyici
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @ExceptionHandler 
    public ResponseEntity<AnimalErrorResponse> handleException(VeterinerNotFoundException exc) {

        AnimalErrorResponse error = new AnimalErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exc.getMessage(),
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

<<<<<<< HEAD
=======
    // --- YENİ EKLENEN METOT (MAMA) ---
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @ExceptionHandler 
    public ResponseEntity<AnimalErrorResponse> handleException(MamaNotFoundException exc) {

        AnimalErrorResponse error = new AnimalErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exc.getMessage(),
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

<<<<<<< HEAD
=======
    // --- YENİ EKLENEN METOT (ASI) ---
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @ExceptionHandler 
    public ResponseEntity<AnimalErrorResponse> handleException(AsiNotFoundException exc) {

        AnimalErrorResponse error = new AnimalErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exc.getMessage(),
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

<<<<<<< HEAD
=======
    // --- YENİ EKLENEN METOT (ILAC) ---
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @ExceptionHandler 
    public ResponseEntity<AnimalErrorResponse> handleException(IlacNotFoundException exc) {

        AnimalErrorResponse error = new AnimalErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            exc.getMessage(),
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

<<<<<<< HEAD
=======
    // Diğer tüm genel hatalar (örn: bozuk JSON gönderme, 500 hataları vb.)
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @ExceptionHandler
    public ResponseEntity<AnimalErrorResponse> handleGenericException(Exception exc) {

        AnimalErrorResponse error = new AnimalErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
<<<<<<< HEAD
            exc.getMessage(), 
=======
            exc.getMessage(), // Gerçek hata mesajını göster
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
            System.currentTimeMillis()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}