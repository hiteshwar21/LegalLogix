package exception;

public class BadRequestException extends RuntimeException{
    private static final long serialVersionUID = -2620920561248527226L;

    public BadRequestException(){ super ();}

    public BadRequestException(final String message){
        super(message);
    }
}
