package co.edu.uniquindio.unimarket.servicios.interfaces;

import java.io.File;
import java.util.Map;

public interface CloudinaryServicio {
    Map subirImagen(File file, String carpeta) throws Exception;
    Map eliminarImagen(String idImagen) throws Exception;
}
