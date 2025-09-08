# 🛡️ Legion - Ordenamiento de Tropas

Este proyecto implementa un **sistema de modelado y ordenamiento de tropas** con visualización en un "campo de batalla".  
Fue desarrollado aplicando **buenas prácticas de Clean Code** y **patrones de diseño**, con el objetivo de ser **modular, extensible y reutilizable**.

---

## 🚀 Requisitos Finales del Proyecto

- ✔️ Modelado de tropas con **clases e interfaces**
- ✔️ Implementación de **ordenamientos por atributos personalizables**
- ✔️ **Visualización del campo de batalla**
- ✔️ Parámetros **CLI** para entrada del usuario
- ✔️ **Cronometrar el tiempo** de ejecución del ordenamiento
- ✔️ Código documentado + **Diagrama UML**
- ✔️ Proyecto en **Git con historial de cambios** 👉 [Repositorio GitLab](https://gitlab.com/MelisaPeano/legion)

---

## 🏗️ Arquitectura

Se utilizó la arquitectura **Project Object Model (POM)**.  
Esta decisión permite:
- Reutilizar código fácilmente.
- Mantener un diseño modular y desacoplado.
- Facilitar la incorporación de nuevas funcionalidades sin romper la estructura base.

---

## ⚙️ Parámetros CLI

El programa recibe parámetros por línea de comandos en el siguiente formato:

```bash
a=i t=N o=w r=1,1,2,3,5 f=6 s=1000

📌 Parámetros soportados

a (algoritmo de ordenamiento):

i / I → Insertion Sort

b / B → Bubble Sort

q / Q → QuickSort

⚠️ Si el valor es inválido, se marca como inválido junto al resto de parámetros.

t (tipo de parámetro):

c → Representación con caracteres

n → Representación numérica

u / r (tipos de tropas):
Se pasa un array de enteros representando cada tropa:

0 = Comandante  
1 = Médicos  
2 = Tanques  
3 = Snipers  
4 = Infantería  


Ejemplo:

u=1,3,4,5,6


o (orientación del campo de batalla):

n → SOUTH_TO_NORTH

s → NORTH_TO_SOUTH

w → EAST_TO_WEST

e → WEST_TO_EAST

s (speed):
Tiempo de delay en milisegundos entre cada paso de ordenamiento.

Al final se muestra el tiempo real de ejecución (sin contar el delay).

🧑‍💻 Ejemplo de ejecución
java -jar legion.jar a=q t=n o=e u=0,2,4,1,3 s=500


👉 Ordena las tropas con QuickSort, representación numérica, orientación EAST_TO_WEST, tropas [0,2,4,1,3] y velocidad de animación de 500ms.

🏛️ Patrones de Diseño Implementados

Factory Method

En el package player, para la creación de tropas.

Permite agregar nuevos tipos de tropas en el futuro sin modificar la lógica central.

Strategy

Para los algoritmos de ordenamiento.

La interfaz SortStrategy define los métodos, y cada algoritmo se implementa en TroopsOrdering.

Facade

Se expone únicamente el método troopManager.play(), ocultando la complejidad interna al cliente.

🧹 Buenas Prácticas Aplicadas

✅ Reemplazo de "Magic Strings" con Enum.

✅ Uso de nombres significativos (principio Use Meaningful Names de Clean Code).

✅ Código modular y documentado.

✅ Diagrama UML para visualizar la arquitectura.

📊 Visualización

Durante la ejecución, el campo de batalla se muestra paso a paso.
Cada intercambio de posiciones genera un snapshot que se convierte en matriz (toMatrixCopy) y se imprime en consola con printManager.

Además, el parámetro s controla la velocidad de animación, y timeManager permite pausar/detener el proceso.

⏱️ Cronometrado del Tiempo

Cada algoritmo mide su tiempo de ejecución real.

El delay (s) no se incluye en el conteo final.

🖥️ Tecnologías Utilizadas
Java 17
Maven (POM Architecture)
IntelliJ IDEA

📌 Diagrama UML

Puedes verlo en legion/Troops.uml

📂 Estructura del Proyecto
src/
 ├── main/
 │   ├── java/
 │   │   ├── player/          # Factory Method para tropas
 │   │   ├── strategy/        # Estrategia de ordenamientos
 │   │   ├── manager/         # Facade (TroopManager)
 │   │   └── utils/           # TimeManager, PrintManager, etc.
 │   └── resources/
 └── test/                    # Tests unitarios

👩‍💻 Autora
Melisa Peano
📌 Proyecto académico desarrollado en IntelliJ IDEA