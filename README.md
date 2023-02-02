# Se creo la base de datos en MONGO DB llamada : nttdata
# La coleccion creada esta agregada en la carpeta colleccionMongodb llamada order.json

Se crearon los siguientes servicios(Se pueden importar a su postman desde la carpeta postmanCollection):

- Ruta: http://localhost:8080/api/orders
    Method: GET
    Query: ?page=10&size=20 ( en caso se requiera), si quiere los 10 primeros no ponga querys

- Ruta: http://localhost:8080/api/orders
    Method: POST
    Body: {
            "orderNumber":1,
            "date":"2023-02-01",
            "customer":"hector bazalar",
            "orderItems":[
                {
                    "product":"producto",
                    "price": 100,
                    "quantity":1 
                } 
            ]
        }

-Ruta: http://localhost:8080/api/orders/{orderNumber}
    Method: PUT
    QueryInRoute: /{orderNumber}
    Body: {
        "status":"Rejected"
    } 
        ó
    {
        "status":"Completed"
    } 
