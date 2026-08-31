package db;

public class DbException extends RuntimeException{
    public DbException(String message) {
        super(message);
    }
}

/* Basicamente criamos essa exception, para evitar de usarmos try o tempo todo, pois qualquer SQLException
    quebra o programa
    E para futuros upgrades na aplicação (migrar para spring, hibernate, etc) não termos de modificar as exeptions*/
