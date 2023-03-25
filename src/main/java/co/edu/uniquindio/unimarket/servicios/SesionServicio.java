package co.edu.uniquindio.unimarket.servicios;

import co.edu.uniquindio.unimarket.dto.TokenDTO;

public interface SesionServicio {
    TokenDTO login(String email, String password) throws Exception;
    //logout();
}