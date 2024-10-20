Plataforma de Reservas de Espacios de Coworking:

Descripción: Diseñar una plataforma de reservas de espacios de coworking que permita a los usuarios buscar y reservar espacios de trabajo, salas de reuniones y eventos. La plataforma debe incluir un sistema de facturación y gestión de membresías.

Integrantes: User:

CHOQUE QUISPE, Gian Anthony Anthonymss
MUÑOZ NIFLA, Nilson Jhon njmn21
NUÑONCCA BLANCO, Gonzalo Pablo Proxyhead12


-El diseño de la arquitectura esta en la carpeta resources en pdf
-FUNCIONALIDADES DE LA APLICACIÓN
  -Permite logearse por con datos name, lastname, correo y contraseña
  -Permite registrarse con Oath con google
  -Las contraseñas estan encriptadas, estos anteriores usan el service de auth, que cuando te logeas te devuelve info del user y jwt para la sesión, para proximas implementaciones de roles con spring       
        security.
  -luego en la Header de la aplicación una vez logeado se pude ver tu perfil, el cual usa a management-user para cargar data.
  -tambien esta en uso a coworkingspaces que es un service, carga data de spaces, para la seccion del modulo de spaces.
  -El api gateway se usa para redirigir a los servicios, desde el front solo se usa al gateway.
  -Eureka se usa para el descubrimiento dinamico de servicios y no saber donde estan alojadas ni su puerto solo en base a su nombre en el cual esta registrado se puede usar,
    para ver el dashboard ir a http://localhost:8761/ , ademas ayuda con el balanceo de carga.
