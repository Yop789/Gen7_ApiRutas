package com.lopez.app.rutas.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.lopez.app.rutas.models.Direccion;
import com.lopez.app.rutas.repositories.DireccionesRepository;
import com.lopez.app.rutas.repositories.IDirreccionesRepository;

public class DireccionesService implements IService<Direccion> {
    private IDirreccionesRepository dirreccionesRepository;

    public DireccionesService(Connection conn) {
        this.dirreccionesRepository = new DireccionesRepository(conn);
    }

    @Override
    public List<Direccion> lista() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lista'");
    }

    @Override
    public Optional<Direccion> getByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByID'");
    }

    @Override
    public Long guardar(Direccion t) {
        try {
            return dirreccionesRepository.guardarReturnId(t);
        } catch (SQLException e) {

            throw new RuntimeException(e.getMessage(), e.getCause());

        }
    }

    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
