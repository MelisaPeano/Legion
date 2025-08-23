Requisitos finales del Proyecto

 Modelado de tropas con clases e interfaces.
 Implementación de ordenamientos por atributos personalizables.
 Visualización del campo de batalla.
 Parámetros CLI para entrada del usuario.
 Cronometrar el tiempo de ejecución del ordenamiento.
 Código documentado + diagrama UML.
 Git con historial de cambios.


Se requiere incluir el diagrama de clases UML, documentación del código
y mostrar al usuario el tiempo total transcurrido para ordenar las tropas
según el algoritmo elegido.

Para este proyecto decidí utilizar la arquitectura Project Object Model (POM), me pareció la más
adecuada para este proyecto. 

---- MIDDLE CAPSTONE ----

Parámetros:
Ejemplo: a=i t=N o=w r=1,1,2,3,5 f=6

a(algoritmo), para esta instancia solo es válido a=i, ya que solo se debe presentar la implementación
de un algoritmo. Próximamente se implementarán el resto ubicado en "enums".
t=c/n este parámetro es válido para dos valores "c" o "n" y se refiere a la representación por 
números o caracteres.
u=[int array] este array de enteros permite colocar el tipo de tropas, su alterno es el parámetro
r con la misma función, ejemplo.
u[0] = comandante
u[1] = médicos
u[2] = tanques
u[3] = Snipers
u[4] = Infantry unit

Ejemplo de implementación "a=i t=c u=1,3,4,5,6"

"o"; Este parámetro otorga orientación al ordenamiento, se pueden seleccionar entre los siguientes:

SOUTH_TO_NORTH ("n"),
NORTH_TO_SOUTH("s"),
EAST_TO_WEST("w"),
WEST_TO_EAST("e");


