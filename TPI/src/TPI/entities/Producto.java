/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TPI.entities;

import java.math.BigDecimal;

public class Producto {
    
    private Long id;
    private boolean eliminado = false;
    private String nombre;
    private String marca;
    private String categoria;
    private BigDecimal precio;
    private BigDecimal peso;
    private CodigoDeBarras codigoBarras; // Relación 1→1

    public Producto() {}

    public Producto(Long id, boolean eliminado, String nombre, String marca,
                    String categoria, BigDecimal precio, BigDecimal peso, CodigoDeBarras codigoBarras) {
        this.id = id;
        this.eliminado = eliminado;
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.peso = peso;
        this.codigoBarras = codigoBarras;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public BigDecimal getPeso() { return peso; }
    public void setPeso(BigDecimal peso) { this.peso = peso; }

    public CodigoDeBarras getCodigoBarras() { return codigoBarras; }
    public void setCodigoBarras(CodigoDeBarras codigoBarras) { this.codigoBarras = codigoBarras; }

    @Override
    public String toString() {
        return String.format("Producto[id=%d, nombre=%s, marca=%s, cat=%s, precio=%s, codigo=%s]",
                id, nombre, marca, categoria, precio,
                codigoBarras != null ? codigoBarras.getValor() : "N/A");
    }
}
