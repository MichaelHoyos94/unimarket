package co.edu.uniquindio.unimarket.servicios.implementaciones;

import co.edu.uniquindio.unimarket.dto.SesionDTO;
import co.edu.uniquindio.unimarket.dto.TokenDTO;
import co.edu.uniquindio.unimarket.seguridad.modelo.UserDetailsImpl;
import co.edu.uniquindio.unimarket.seguridad.servicios.JwtService;
import co.edu.uniquindio.unimarket.seguridad.servicios.UserDetailsServiceImpl;
import co.edu.uniquindio.unimarket.servicios.interfaces.SesionServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SesionServicioImp implements SesionServicio {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private UserDetailsService userDetailsService;
    @Override
    public TokenDTO login(SesionDTO sesionDTO) throws Exception {
        UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(sesionDTO.getEmail(), sesionDTO.getPassword());
        Authentication authentication = authenticationManager.authenticate(upat);
        UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return new TokenDTO(jwtToken, refreshToken);
    }

    @Override
    public TokenDTO refreshToken(TokenDTO tokenDTO) throws Exception{

        String email = jwtService.extractUsername(tokenDTO.getRefreshToken());
        UserDetails user = (UserDetails) userDetailsService.loadUserByUsername(email);

        if(jwtService.isTokenValid(tokenDTO.getRefreshToken(), user)) {
            String token = jwtService.generateToken(user);
            return new TokenDTO(token, tokenDTO.getRefreshToken());
        }

        throw new Exception("Error construyendo el token");
    }

    @Override
    public void logout(Long idUsuario) {

    }
}