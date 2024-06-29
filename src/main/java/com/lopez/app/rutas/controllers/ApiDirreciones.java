package com.lopez.app.rutas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.lopez.app.rutas.models.Direccion;
import com.lopez.app.rutas.services.DireccionesService;
import com.lopez.app.rutas.services.IService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/direcciones")
public class ApiDirreciones extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Direccion> service = new DireccionesService(conn);
        String calle = req.getParameter("calle");
        String numero = req.getParameter("numero");
        String colonia = req.getParameter("colonia");
        String cp = req.getParameter("cp");
        String ciudad = req.getParameter("ciudad");
        String estado = req.getParameter("estado");

        Direccion d = new Direccion();

        d.setCalle(calle);
        d.setNumero(numero);
        d.setColonia(colonia);
        d.setCp(cp);
        d.setCiudad(ciudad);
        d.setEstado(estado);

        try {

            Long id = service.guardar(d);
            Thread.sleep(6000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

        resp.setContentType("application/jason");
        Map<String, String> response = new HashMap<>();

        Long id = null;
        try (PrintWriter out = resp.getWriter()) {
            resp.setStatus(201);
            response.put("mensaje", id.toString());
            response.put("status", "success");
            String json = new Gson().toJson(response);

            out.print(json);
        }
    }

}
