import java.util.Arrays;
import java.util.List;

public class NewException extends Exception {

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return "Пожалуйста, заполните все значения.";
    }
}



