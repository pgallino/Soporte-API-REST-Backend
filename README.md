# memo1-Microservicio-Soporte
Memo1 - Backend API - Soporte

### url del backend
    https://soporte-psa-lor9.onrender.com/
Listado de endpoints

### Crear Ticket 
    POST
    /ticket
    request body: ticket 

### Actualizar Ticket
    PUT
    /ticket
    request body: ticket 
### Pedir todos los tickets
    GET
    /ticket

### Pedir Tickets para una version de un producto
    GET
    /ticket/{productId}/{versionId}

### Pedir un ticket segun su id
    GET
    /ticket/{ticketid}

### Pedir los tasks no asociados a un ticket
    GET
    /ticket/{ticketid}/notmytasks

### Pedir los tasks asociados a un ticket
    GET
    /ticket/{ticketid}/mytasks

### Crear asociacion ticket-task 
    POST
    /ticket/task
    request body: taskticketassociation

### Borrar Ticket y sus asociaciones
    DELETE
    /ticket/{ticketId}
    
### Borrar todas las asociaciones de tickets hacia una tarea
    DELETE
    /ticket/task/{taskId}

### Borrar la asociacion de un ticket y una tarea
    DELETE
    /ticket/{ticketId}/task/{taskId}

### Pedir asociaciones de un ticket
    GET
    /ticket/{ticketId}/task

### Pedir asociaciones a una task en concreto
    GET
    /ticket/task/{taskId}

### Pedir Recursos
    GET
    /Recursos

### Pedir un recurso
    GET
    /Recursos/{legajo}

### Pedir Clientes 
    GET
    /Clientes

### Pedir un cliente
    GET
    /Clientes/{id}

