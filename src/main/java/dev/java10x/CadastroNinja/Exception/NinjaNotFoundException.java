package dev.java10x.CadastroNinja.Exception;

public class NinjaNotFoundException extends RuntimeException {
    public NinjaNotFoundException(Long id) {
        super("Ninja com id " + id + " não encontrado");
    }
}
