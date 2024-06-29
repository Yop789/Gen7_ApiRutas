package com.lopez.app.rutas.repositories;

import java.sql.SQLException;

import com.lopez.app.rutas.models.Direccion;

public interface IDirreccionesRepository extends IRepository<Direccion> {

    Long guardarReturnId(Direccion direccion) throws SQLException;

}
