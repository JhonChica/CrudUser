package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.acme.gen.contract.V1UsuarioApi;
import org.acme.gen.type.UsuarioTypeInput;
import org.acme.gen.type.UsuarioTypeResponse;
import org.acme.service.implemt.UsuarioServiceImpl;
import org.acme.utils.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class UsuarioController implements V1UsuarioApi {
    private  static  final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    @Inject
    UsuarioServiceImpl usuarioServiceImpl;

    @Override
    public Response crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia el metodo crearUsuario Controller");
        UsuarioTypeResponse response = null;
        try{
            response = usuarioServiceImpl.crearUsuario(usuarioTypeInput);
        }catch (ApplicationException e){
            LOG.error("Se presento un error en el metodo crearUsuario controller"+ e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
        }
        LOG.info("Finaliza el metodo crearUsuario Controller");
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @Override
    public Response editarUsuario(Integer idtblUser, UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicia el metodo editarUsuario Controller");
        UsuarioTypeResponse response = null;
        try{
            response = usuarioServiceImpl.editarUsuario(idtblUser, usuarioTypeInput);
        }catch (ApplicationException e){
            LOG.error("Se presento un error en el metodo buscarUsuario controller"+ e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza el metodo editarUsuario Controller");
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @Override
    public Response buscarUsuario(Integer idtblUser){
        LOG.info("Inicia el metodo buscarUsuario Controller");
        UsuarioTypeResponse response = null;
        try{
            LOG.info("Inicia listarUsuarioImpl");
            response = usuarioServiceImpl.buscarUsuario(idtblUser);
        }catch (ApplicationException e){
            LOG.error("Se presento un error en el metodo buscarUsuario controller"+ e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza el metodo buscarUsuario Controller");
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @Override
    public Response eliminarUsuario(Integer idtblUser) {
        LOG.info("Inicia el metodo eliminarUsuario Controller");
        UsuarioTypeResponse response = null;
        try{
            usuarioServiceImpl.eliminarUsuario(idtblUser);
        }catch (ApplicationException e){
            LOG.error("Se presento un error en el metodo eliminarUsuario Controller"+ e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza el metodo eliminarUsuario Controller");
        return Response.status(Response.Status.NO_CONTENT).entity(response).build();
    }

    @Override
    public Response listarTodosLosUsuario() {
        LOG.info("Inicia el metodo listarTodosLosUsuario Controller");
        List<UsuarioTypeResponse> response = null;
        try{
            response = usuarioServiceImpl.listarTodosLosUsuario();
        }catch (ApplicationException e){
            LOG.error("Se presento un error en el metodo listarTodosLosUsuario controller"+ e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        LOG.info("Finaliza el metodo listarTodosLosUsuario Controller");
        return Response.status(Response.Status.OK).entity(response).build();
    }
}