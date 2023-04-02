package co.edu.uniquindio.unimarket.servicios.interfaces;

public interface EmailServicio {
    boolean enviarEmail(String asunto, String contenido, String destino) throws Exception;
}