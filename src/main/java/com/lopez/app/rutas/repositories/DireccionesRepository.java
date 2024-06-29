package com.lopez.app.rutas.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.lopez.app.rutas.models.Direccion;

public class DireccionesRepository implements IDirreccionesRepository {
    private Connection conn;

    public DireccionesRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Direccion> lista() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lista'");
    }

    @Override
    public Direccion get(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void guardar(Direccion t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public Long guardarReturnId(Direccion direccion) throws SQLException {
        String sqlInsert = "INSERT INTO DIRECCIONES (ID_DIRECCION, CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, CP) " +
                "VALUES (SEQUENCE_3.NEXTVAL, ?, ?, ?, ?, ?, ?)";

        String sqlSelect = "SELECT ID_DIRECCION FROM DIRECCIONES WHERE " +
                "CALLE = ? AND " +
                "NUMERO = ? AND " +
                "COLONIA = ? AND " +
                "CIUDAD = ? AND " +
                "ESTADO = ? AND " +
                "CP = ?";

        Long resultado = -1L;

        // Verificar si ya existe una dirección con los mismos detalles
        try (PreparedStatement selectStm = conn.prepareStatement(sqlSelect)) {
            selectStm.setString(1, direccion.getCalle());
            selectStm.setString(2, direccion.getNumero());
            selectStm.setString(3, direccion.getColonia());
            selectStm.setString(4, direccion.getCiudad());
            selectStm.setString(5, direccion.getEstado());
            selectStm.setString(6, direccion.getCp());

            ResultSet rs = selectStm.executeQuery();

            // Si existe una dirección con los mismos detalles, retornar su ID
            if (rs.next()) {
                resultado = rs.getLong("ID_DIRECCION");
            } else {
                // Si no existe, proceder con la inserción
                try (PreparedStatement insertStm = conn.prepareStatement(sqlInsert, new String[] { "ID_DIRECCION" })) {
                    insertStm.setString(1, direccion.getCalle());
                    insertStm.setString(2, direccion.getNumero());
                    insertStm.setString(3, direccion.getColonia());
                    insertStm.setString(4, direccion.getCiudad());
                    insertStm.setString(5, direccion.getEstado());
                    insertStm.setString(6, direccion.getCp());

                    int executeUpdate = insertStm.executeUpdate();

                    if (executeUpdate > 0) {
                        ResultSet generatedKeys = insertStm.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            resultado = generatedKeys.getLong(1);
                        }
                    }
                }
            }
        }

        return resultado;
    }

}
