class Producto(
    val codigo: String,
    var nombre: String,
    var precio: Double,
    var cantidadStock: Int
) {


    fun venderProducto(cantidad: Int) {
        if (cantidadStock >= cantidad) {
            cantidadStock -= cantidad
            println("Se vendieron $cantidad unidades de $nombre.")
        } else {
            println("No hay stock de $nombre para vender $cantidad unidades.")
        }
    }


    fun reponerStock(cantidad: Int) {
        cantidadStock += cantidad
        println("Se repusieron $cantidad unidades de $nombre.")
    }


    fun aplicarDescuento(porcentaje: Double) {
        precio -= precio * (porcentaje / 100)
        println("Se aplicó un descuento del $porcentaje% a $nombre. Nuevo precio: $precio")
    }


    fun mostrarInformacion() {
        println("Código: $codigo, Nombre: $nombre, Precio: $precio, Stock: $cantidadStock")
    }


    fun aumentarPrecio(porcentaje: Double) {
        precio += precio * (porcentaje / 100)
        println("Aumentó del precio de $nombre en un $porcentaje%. Nuevo precio: $precio")
    }


    fun calcularValorTotalInventario(): Double {
        return cantidadStock * precio
    }

    companion object { // definir métodos y propiedades que no dependen de una instancia específica de la clase
        fun eliminarProductoPorCodigo(listaProductos: MutableList<Producto>, codigo: String) {
            val producto = listaProductos.find { it.codigo == codigo }
            if (producto != null) {
                listaProductos.remove(producto)
                println("Producto con código $codigo eliminado.")
            } else {
                println("Producto no encontrado por codigo $codigo.")
            }
        }
    }
}