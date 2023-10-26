# r1-Espinosa

API Rest
Esta API es una aplicación construida con Spring Boot 3.1.5  que permite a los usuarios crear, leer, actualizar y eliminar cuentas, utilizando InlliJ IDEA para crear los códigos.
siguientes Funcionalidades El API proporciona las funcionalidades para manejar cuentas:
Crear una nueva cuenta. Leer todas las cuentas. Leer una cuenta por su ID. Actualizar una cuenta existente. Eliminar una cuenta. Cada cuenta tiene los siguientes atributos:
•	Nombre del cliente.
•	Número de cuenta.
•	Saldo de la cuenta.
•	Estado de la cuenta.
Uso:
La API se puede usar a través de las siguientes URL:
•	GET http://localhost:8080/api/v1/accounts : devuelve una lista de todas las cuentas.
•	GET http://localhost:8080/api/v1/accounts/{id} : devuelve una cuenta específica según su ID.
•	POST http://localhost:8080/api/v1/accounts : crea una nueva cuenta.
•	PUT http://localhost:8080/api/v1/accounts/{id} : actualiza una cuenta existente según su ID.
•	DELETE http://localhost:8080/api/v1/accounts/{id} : elimina una cuenta según su ID.
Mostraré algunos de los código que coloque para las API:
POST:
//crea un nuevo usuario en la base de datos
public ResponseEntity<Cliente> guardarCliente(@RequestBody Cliente cliente){
    Cliente nuevo_cliente = clienteservicio.crear(cliente);
    return new ResponseEntity<>(nuevo_cliente, HttpStatus.CREATED);
}
DELETE:
//se elimina el cliente que se desea eliminar
public ResponseEntity<HashMap<String,Boolean>> eliminarCliente(@PathVariable long id){
    this.clienteservicio.eliminar(id);
    
    HashMap<String, Boolean> estadoClienteEliminado = new HashMap<>();
    estadoClienteEliminado.put("eliminado", true);
    return ResponseEntity.ok(estadoClienteEliminado);
}

Para crear una cuenta, se deben proporcionar los siguientes parámetros en formato JSON:
{
"client_Name": "Maria",
"balance": "300",
"estado": "Activo"
}
