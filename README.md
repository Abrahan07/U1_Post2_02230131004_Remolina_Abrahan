# E-Commerce con Patrones de Diseño

Sistema de e-commerce simplificado que implementa tres patrones de diseño del GoF: Observer, Factory Method y Strategy.



## Diagrama UML

### Patron Observer

    OrderObserver (interfaz)
        - update(orderId, oldStatus, newStatus)

    EmailNotifier  implementa  OrderObserver
    SMSNotifier    implementa  OrderObserver
    LogNotifier    implementa  OrderObserver

    OrderSubject (interfaz)
        - subscribe(observer)
        - unsubscribe(observer)
        - notifyObservers(orderId, oldStatus, newStatus)

    Order  implementa  OrderSubject
    Order tiene una lista de OrderObserver


### Patron Factory Method

    Product (clase abstracta)
        - name, basePrice, category
        - calculateShipping()
        - getDescription()

    Electronics  extiende  Product
    Clothing     extiende  Product
    Food         extiende  Product

    ProductFactory
        - createProduct(type, name, price)  crea y retorna un Product


### Patron Strategy

    PricingStrategy (interfaz)
        - calculateFinalPrice(originalPrice)
        - getDescription()

    RegularPricing      implementa  PricingStrategy  (sin descuento)
    MemberPricing       implementa  PricingStrategy  (10% descuento)
    BlackFridayPricing  implementa  PricingStrategy  (30% descuento)
    BulkPricing         implementa  PricingStrategy  (descuento por cantidad)

    OrderService usa una PricingStrategy


### Relacion general entre clases

    Main
      usa OrderService
        OrderService usa ProductFactory  ->  crea Products
        OrderService usa PricingStrategy ->  calcula precios
        OrderService usa Order           ->  gestiona el pedido
          Order notifica a EmailNotifier
          Order notifica a SMSNotifier
          Order notifica a LogNotifier


## Justificacion de Patrones

### Observer

Problema: cuando un pedido cambia de estado, varios sistemas necesitan ser notificados (email, SMS, log). Si conectamos Order directamente con cada notificador el codigo se vuelve rigido y dificil de mantener.

Solucion: con Observer, la clase Order no sabe quienes son sus observadores, solo los llama por la interfaz. Agregar un nuevo notificador no requiere modificar Order.

Beneficio: desacoplado y facil de extender.

### Factory Method

Problema: crear productos directamente con "new Electronics(...)" en el codigo cliente genera dependencias que dificultan agregar nuevos tipos de producto.

Solucion: ProductFactory centraliza la creacion. El cliente solo pasa el tipo como texto ("ELECTRONICS", "CLOTHING", "FOOD") y recibe un objeto Product listo.

Beneficio: el codigo cliente no depende de las clases concretas y agregar un nuevo tipo de producto es simple.

### Strategy

Problema: el precio final cambia segun la politica activa (normal, miembro, Black Friday, volumen). Usar if/else para cada caso mezcla la logica y complica agregar nuevas politicas.

Solucion: cada politica es una clase separada que implementa PricingStrategy. OrderService recibe la estrategia elegida y la aplica sin importar cual sea.

Beneficio: cada politica esta aislada, es facil de probar y se puede cambiar en tiempo de ejecucion.



## Estructura del Proyecto

    ecommerce-patterns/
      src/
        model/       -> Product, Electronics, Clothing, Food, Order
        factory/     -> ProductFactory
        observer/    -> OrderObserver, OrderSubject, EmailNotifier, SMSNotifier, LogNotifier
        strategy/    -> PricingStrategy, RegularPricing, MemberPricing, BlackFridayPricing, BulkPricing
        service/     -> OrderService
        Main/        -> Main.java
      README.md



## Instrucciones de Ejecucion

Requisitos:
- Java JDK 17 o superior
- NetBeans IDE

Pasos:

1. Abrir NetBeans y seleccionar File, luego Open Project.
2. Navegar hasta la carpeta ecommerce-patterns y abrir el proyecto.
3. Verificar que todos los paquetes aparezcan en Source Packages.
4. Para compilar: clic derecho en el proyecto y seleccionar Clean and Build.
5. Para ejecutar: clic derecho en el proyecto y seleccionar Run.

Salida esperada al ejecutar:
se abjunta en el documento Capturas.pdf
