# RESPONDER 
## ¿Por qué has tenido que cambiar de ubicación las vistas? 
Tuve que cambiarlos para que en el controlador, al poner la ruta con el GetMapping, los encontrase.
Específicamente moverlos a la carpeta templates.

## ¿Has tenido que cambiar el código HTML del menú de navegación? ¿Por qué? 
Sí, debido a que, al mover los .html, la ruta original ya no funcionaba, y al controlarlos con
un GetMapping, usé el th:href para enlazar los elementos en el menú.

## ¿Tienen que llamarse igual la ruta de un @GetMapping y la vista que devuelve? Justifícalo 
con tu proyecto.
Sí, dado que la ruta llega hasta (En mi caso, por ejemplo) /index, donde index es el nombre del
propio html.
