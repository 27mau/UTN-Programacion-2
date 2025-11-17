/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.entities;
import java.time.LocalDate;

/**
 *
 * @author Mauro
 */

public class CodigoDeBarras {
    private Long id;
    private boolean eliminado = false;
    private TipoCodigo tipo;
    private String valor;
    private LocalDate fechaAsignacion;
    private String observaciones;

    public CodigoDeBarras() {}

    // Permite construir un objeto completo al recuperar datos desde el DAO.
    public CodigoDeBarras(Long id, boolean eliminado, TipoCodigo tipo,
                          String valor, LocalDate fechaAsignacion, String observaciones) {
        this.id = id;
        this.eliminado = eliminado;
        this.tipo = tipo;
        this.valor = valor;
        this.fechaAsignacion = fechaAsignacion;
        this.observaciones = observaciones;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }

    public TipoCodigo getTipo() { return tipo; }
    public void setTipo(TipoCodigo tipo) { this.tipo = tipo; }

    public String getValor() { return valor; }
    public void setValor(String valor) { this.valor = valor; }

    public LocalDate getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDate fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    @Override
    public String toString() {
        return String.format("CodigoDeBarras[id=%d, tipo=%s, valor=%s, fecha=%s]",
                id, tipo, valor, fechaAsignacion);
    }
}
