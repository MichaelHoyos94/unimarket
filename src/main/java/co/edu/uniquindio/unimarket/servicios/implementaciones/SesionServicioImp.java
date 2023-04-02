package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.TokenDTO;
import co.edu.uniquindio.unimarket.entidades.Usuario;
import co.edu.uniquindio.unimarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesionServicioImp implements SesionServicio {
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Override
    public TokenDTO login(String email, String password) throws Exception {
        Usuario usuarioLogin = usuarioRepo.findByEmailAndPassword(email, password);
        if (usuarioLogin == null)
            throw new Exception("El correo o la clave de acceso son incorrectos");
        //crear el token y retornarlo.
        return new TokenDTO("0000");
    }
}