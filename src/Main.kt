//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
        val productos = mutableListOf<Producto>()
        var opcion: Int

        do {
            println("\n Tienda")
            println("1 Crear producto")
            println("2 Vender producto")
            println("3 Reponer stock")
            println("4 Aplicar descuento")
            println("5 Aumentar precio")
            println("6 Mostrar información de productos")
            println("7 Calcular valor total en inventario")
            println("8 Eliminar producto por código")
            println("9 Salir")
            print("Seleccione una opción: ")
            opcion = readLine()?.toIntOrNull() ?: 9

            when (opcion) {
                1 -> crearProducto(productos)
                2 -> venderProducto(productos)
                3 -> reponerStock(productos)
                4 -> aplicarDescuento(productos)
                5 -> aumentarPrecio(productos)
                6 -> mostrarInformacionProductos(productos)
                7 -> calcularValorTotalInventario(productos)
                8 -> eliminarProductoPorCodigo(productos)
                9 -> println("Salio")
                else -> println("Opción no válida. Intente de nuevo.")
            }
        } while (opcion != 9)
    }


    fun crearProducto(productos: MutableList<Producto>) {
        print("Ingrese el código:  ")
        val codigo = readLine() ?: ""
        print("Ingrese el nombre del producto: ")
        val nombre = readLine() ?: ""
        print("Ingrese el precio del producto: ")
        val precio = readLine()?.toDoubleOrNull() ?: 0.0
        print("Ingrese la cantidad en stock: ")
        val cantidadStock = readLine()?.toIntOrNull() ?: 0

        val producto = Producto(codigo, nombre, precio, cantidadStock)
        productos.add(producto)
        println("Producto creado exitosamente.")
    }


    fun venderProducto(productos: MutableList<Producto>) {
        print("Ingrese el código del producto a vender: ")
        val codigo = readLine() ?: ""
        val producto = productos.find { it.codigo == codigo }

        if (producto != null) {
            print("Ingrese la cantidad a vender: ")
            val cantidad = readLine()?.toIntOrNull() ?: 0
            producto.venderProducto(cantidad)
        } else {
            println("No se encontró ningún producto con el código $codigo.")
        }
    }


    fun reponerStock(productos: MutableList<Producto>) {
        print("Ingrese el código del producto a reponer: ")
        val codigo = readLine() ?: ""
        val producto = productos.find { it.codigo == codigo }

        if (producto != null) {
            print("Ingrese la cantidad a reponer: ")
            val cantidad = readLine()?.toIntOrNull() ?: 0
            producto.reponerStock(cantidad)
        } else {
            println("No se encontró ningún producto con el código $codigo.")
        }
    }


    fun aplicarDescuento(productos: MutableList<Producto>) {
        print("Ingrese el código del producto a aplicar descuento: ")
        val codigo = readLine() ?: ""
        val producto = productos.find { it.codigo == codigo }

        if (producto != null) {
            print("Ingrese el porcentaje de descuento: ")
            val porcentaje = readLine()?.toDoubleOrNull() ?: 0.0
            producto.aplicarDescuento(porcentaje)
        } else {
            println("No se encontró ningún producto con el código $codigo.")
        }
    }


    fun aumentarPrecio(productos: MutableList<Producto>) {
        print("Ingrese el código del producto a aumentar precio: ")
        val codigo = readLine() ?: ""
        val producto = productos.find { it.codigo == codigo }

        if (producto != null) {
            print("Ingrese el porcentaje de aumento: ")
            val porcentaje = readLine()?.toDoubleOrNull() ?: 0.0
            producto.aumentarPrecio(porcentaje)
        } else {
            println("No se encontró ningún producto con el código $codigo.")
        }
    }


    fun mostrarInformacionProductos(productos: MutableList<Producto>) {
        if (productos.isEmpty()) {
            println("No hay productos registrados.")
        } else {
            println("\nInformación de los productos:")
            productos.forEach { it.mostrarInformacion() }
        }
    }


    fun calcularValorTotalInventario(productos: MutableList<Producto>) {
        if (productos.isEmpty()) {
            println("No hay productos registrados.")
        } else {
            val valorTotal = productos.sumOf { it.calcularValorTotalInventario() }
            println("El valor total en inventario es: $valorTotal")
        }
    }


    fun eliminarProductoPorCodigo(productos: MutableList<Producto>) {
        print("Ingrese el código del producto a eliminar: ")
        val codigo = readLine() ?: ""
        Producto.eliminarProductoPorCodigo(productos, codigo)
    }

