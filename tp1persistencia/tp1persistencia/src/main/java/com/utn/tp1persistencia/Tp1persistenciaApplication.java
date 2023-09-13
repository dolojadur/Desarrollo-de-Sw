package com.utn.tp1persistencia;

import com.utn.tp1persistencia.repositorios.*;
import com.utn.tp1persistencia.entidades.*;
import com.utn.tp1persistencia.enumeracion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

import static com.utn.tp1persistencia.enumeracion.tipoProducto.Insumo;
import static com.utn.tp1persistencia.enumeracion.tipoProducto.Manufacturado;

@SpringBootApplication
public class Tp1persistenciaApplication {

	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String[] args) {

		SpringApplication.run(Tp1persistenciaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(RubroRepository rubrorepo, ClienteRepository clienterepo){
		return args -> {
			System.out.println("---------funciono---------");

			Rubro rubro1 = Rubro.builder()
					.denominacion("deno1")
					.build();

			Producto prod1 = Producto.builder()
					.tipo(Insumo)
					.tiempoEstimadoCocina(30)
					.denominacion("deno1")
					.precioVenta(500)
					.precioCompra(400)
					.stockActual(6)
					.stockMinimo(3)
					.unidadMedida("gramos")
					.receta("lorem ipsum...")
					.build();


			Producto prod2 = Producto.builder()
					.tipo(Manufacturado)
					.tiempoEstimadoCocina(45)
					.denominacion("deno1")
					.precioVenta(550)
					.precioCompra(400)
					.stockActual(18)
					.stockMinimo(3)
					.unidadMedida("kilos")
					.receta("lorem ipsum...")
					.build();

			//Agrego los productos a rubro1
			rubro1.agregarProducto(prod1);
			rubro1.agregarProducto(prod2);

			Cliente cli1= Cliente.builder()
					.nombre("Juan")
					.apellido("Perez")
					.telefono("123456789")
					.email("12@12.34")
					.build();

			Cliente cli2= Cliente.builder()
					.nombre("Maria")
					.apellido("Alvarez")
					.telefono("123456789")
					.email("12@12.34")
					.build();

			Domicilio dom1 = Domicilio.builder()
					.calle("Paso")
					.numero("300")
					.localidad("Lujan de Cuyo")
					.build();

			Domicilio dom2 = Domicilio.builder()
					.calle("Boedo")
					.numero("250")
					.localidad("Maipu")
					.build();

			Domicilio dom3 = Domicilio.builder()
					.calle("Rodriguez")
					.numero("450")
					.localidad("Ciudad")
					.build();

			//Agregar domicilios a cliente
			cli1.agregarDomicilio(dom1);
			cli1.agregarDomicilio(dom3);
			cli2.agregarDomicilio(dom2);


			//creo fechas porque sino no me deja ingresarlas y despues se las voy a agregrar
			LocalDate fecha1= LocalDate.of (2023, 11, 24);
			LocalDate fecha2= LocalDate.of (2023, 9, 17);
			LocalDate fecha3= LocalDate.of (2023, 5, 4);

			Pedido pedi1 =Pedido.builder()
					.estado(estadoPedido.Iniciado)
					.tipoEnvio(tipoEnvioPedido.Delivery)
					.total(600.00)
					.build();

			Pedido pedi2 =Pedido.builder()
					.estado(estadoPedido.Entregado)
					.tipoEnvio(tipoEnvioPedido.Retira)
					.total(600.00)
					.build();

			Pedido pedi3 =Pedido.builder()
					.estado(estadoPedido.Preparacion)
					.tipoEnvio(tipoEnvioPedido.Retira)
					.total(600.00)
					.build();

			//Agregar pedidos a cliente
			cli1.agregarPedido(pedi1);
			cli2.agregarPedido(pedi2);
			cli2.agregarPedido(pedi3);

			DetallePedido detp1 =DetallePedido.builder()
					.cantidad(6)
					.subtotal(1000.00)
					.build();

			DetallePedido detp2 =DetallePedido.builder()
					.cantidad(2)
					.subtotal(700.50)
					.build();

			DetallePedido detp3 =DetallePedido.builder()
					.cantidad(1)
					.subtotal(700.50)
					.build();

			//Agrergo productos a detalle pedido
			detp1.setProd(prod1);
			detp2.setProd(prod2);
			detp3.setProd(prod1);
			detp2.setProd(prod1);

			//Agrego detalles a pedido
			pedi1.agregarDetallePedido(detp1);
			pedi2.agregarDetallePedido(detp2);
			pedi2.agregarDetallePedido(detp3);

			Factura fact1 = Factura.builder()
					.numero(12)
					.descuento(10)
					.formaPago(formaPagoFactura.Efectivo)
					.total(5500)
					.build();

			//Agrego el atributo fecha a pedido y factura
			pedi1.setFecha(fecha1);
			pedi2.setFecha(fecha2);
			pedi3.setFecha(fecha3);
			fact1.setFecha(fecha3);

			//Agrego factura y detalle a pedido (solo al 1)
			pedi1.agregarDetallePedido(detp1);
			pedi2.agregarDetallePedido(detp2);
			pedi1.setFactura(fact1);

			//puedo poner todos los saves al final
			//Guardo rubro1 en la base de datos
			rubroRepository.save(rubro1);

			//Guardar Cliente
			clienteRepository.save(cli1);
			clienteRepository.save(cli2);

			//recuperar rubro desde la base de datos
			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null){
				System.out.println("----------------------------------------");
				System.out.println("Denominacion: " + rubroRecuperado.getDenominacion());
				rubroRecuperado.mostrarProductos();
				System.out.println("----------------------------------------");
			}
			//recuperar Cliente desde la base de datos
			Cliente clienteRecuperado = clienteRepository.findById(cli1.getId()).orElse(null);
			if (clienteRecuperado != null){
				System.out.println("----------------------------------------");
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Mail: " + clienteRecuperado.getEmail());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("----------------------------------------");
				clienteRecuperado.mostrarDomicilios();
				clienteRecuperado.mostrarPedidos();

			}

		};
	}
}
