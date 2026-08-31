package db;

public class DbIntegrityException extends RuntimeException {
    public DbIntegrityException(String message) {
        super(message);
    } //feita para excetions onde o usuário tenta apagar uma coluna pai
}
