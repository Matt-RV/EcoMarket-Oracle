package com.gestionPedidos.GestionPedidos.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido; // ID del pedido

    @Column(nullable=false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Formato de la fecha, elimina la hora.
    private Date fechaCreacion; // Se coloca Date porque la base de datos funciona con este y no con LocalDate.
    // (YYYY-MM-DD)

    @Column(nullable=false)
    private String estado; // "Pendiente", "Entregado", "Cancelado".
    
    @Column(nullable=false)
    private double total; // No me interesa el decimal.

    
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "idCliente", nullable = false)
    private Cliente cliente; // ID del cliente que hace el pedido.



}
