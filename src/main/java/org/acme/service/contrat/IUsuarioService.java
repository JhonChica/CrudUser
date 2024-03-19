package org.acme.service.contrat;

import org.acme.gen.type.UsuarioTypeInput;
import org.acme.gen.type.UsuarioTypeResponse;
import java.util.List;

public interface IUsuarioService {
    UsuarioTypeResponse crearUsuario(UsuarioTypeInput usuarioTypeInput);
    UsuarioTypeResponse editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput);
    UsuarioTypeResponse buscarUsuario(Integer idtblUser);
    void eliminarUsuario(Integer idtblUser);
    List<UsuarioTypeResponse> listarTodosLosUsuario();
}
