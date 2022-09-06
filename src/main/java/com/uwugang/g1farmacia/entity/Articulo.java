package com.uwugang.g1farmacia.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Articulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private int stock;
	
	private float precio;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_pedido", nullable = false)
	private Pedido pedido;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_carrito", nullable = false)
	private Carrito carrito;
	
	@OneToMany(mappedBy = "articulo")
	private List<Categoria> categorias;
	
	@OneToMany(mappedBy = "articulo")
	private List<Marca> marcas;
}
