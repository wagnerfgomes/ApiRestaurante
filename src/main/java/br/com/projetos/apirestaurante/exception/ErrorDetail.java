package br.com.projetos.apirestaurante.exception;

public enum ErrorDetail {
    ;

    private final String message;
    private final int statusCode;
    private final String errorCode;

    ErrorDetail(String message, int statusCode, String errorCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
