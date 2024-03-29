package co.edu.uniquindio.unimarket.servicios.interfaces;

import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;

public interface SesionServicio {
    TokenDTO login(SesionDTO sesionDTO) throws Exception;
    TokenDTO refreshToken(TokenDTO tokenDTO)  throws Exception;
    void logout(Long idUsuario);
}