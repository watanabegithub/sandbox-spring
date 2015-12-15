package sample.springbootweb.app.product;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy  =  TelNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public  @interface  TelNumber {
    String  message()  default "TEL number is invalid";
    Class<?>[]  groups()  default {};
    Class<? extends Payload>[]  payload()  default {};
}
