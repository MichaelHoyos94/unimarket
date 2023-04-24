package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.servicios.interfaces.CloudinaryServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class CloudinaryServicioImp implements CloudinaryServicio {
    private Cloudinary cloudinary;
    private Map<String, String> config;
    public CloudinaryServicioImp() {
        config = new HashMap<>();
        config.put("cloud_name", "SU_CLOUD_NAME");
        config.put("api_key", "SU_API_KEY");
        config.put("api_secret", "SU_API_SECRET");
        cloudinary = new Cloudinary(config);
    }
    @Override
    public Map subirImagen(File file, String carpeta) throws Exception {
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", String.format("co/edu/uniquindio/proyecto/%s", carpeta)));
    }
    @Override
    public Map eliminarImagen(String idImagen) throws Exception {
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }
}