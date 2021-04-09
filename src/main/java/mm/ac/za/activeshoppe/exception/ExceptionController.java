package mm.ac.za.activeshoppe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
   @ExceptionHandler(value = CustomerNotFoundException.class)
   public ResponseEntity<Object> exception(CustomerNotFoundException exception) {
      return new ResponseEntity<>("No such customer", HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(value = NoSuchProductException.class)
   public ResponseEntity<Object> exception(NoSuchProductException exception) {
      return new ResponseEntity<>("No such product", HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(value = NoEnoughPointsException.class)
   public ResponseEntity<Object> exception(NoEnoughPointsException exception) {
      return new ResponseEntity<>("No enough points", HttpStatus.NOT_FOUND);
   }

   @ExceptionHandler(value = NoProductException.class)
   public ResponseEntity<Object> exception(NoProductException exception) {
      return new ResponseEntity<>("No such product", HttpStatus.NOT_FOUND);
   }
}