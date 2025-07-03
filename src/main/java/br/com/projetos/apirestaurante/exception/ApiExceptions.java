package br.com.projetos.apirestaurante.exception;

public class ApiExceptions extends RuntimeException{

    private ErrorDetail errorDetail;

    public ApiExceptions(ErrorDetail errorDetail){
        super(errorDetail.getMessage());
        this.errorDetail = errorDetail;
    }

    public ErrorDetail getErrorDetail(){
        return errorDetail;
    }

    public int getStatusCode(){
        return errorDetail.getStatusCode();
    }

    public String getErrorCode(){
        return errorDetail.getErrorCode();
    }

}
