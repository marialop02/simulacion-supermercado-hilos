# Simulación de Cobro en un Supermercado - Concurrencia y Hilos

Este proyecto responde al caso de estudio propuesto por el **Departamento de Tecnología en Desarrollo de Software de la IUDigital de Antioquia**. El objetivo es diseñar y desarrollar una aplicación en Java que simule el proceso de cobro en las cajas registradoras de un supermercado utilizando conceptos avanzados de programación multihilo (concurrencia).

## 📋 Desafío del Caso de Estudio
El software debe gestionar el proceso de cobro cliente a cliente de forma secuencial dentro de cada caja (primero al cliente 1, luego al cliente 2, etc.), simulando la atención simultánea a través de múltiples cajeras. Además, debe calcular de manera precisa el tiempo total que toma procesar todas las compras de la tienda.

## 🏗️ Arquitectura del Software
El sistema está diseñado bajo el paradigma de Programación Orientada a Objetos (POO) y se compone de las siguientes clases:

1. **`Producto`**: Representa los artículos con su nombre, costo unitario y el tiempo estimado de escaneo en segundos.
2. **`Cliente`**: Modela al consumidor, poseyendo un nombre y un carrito de compras (`List<Producto>`).
3. **`Cajera`**: Clase principal de concurrencia que hereda de `Thread`. Se encarga de procesar la cola de clientes asignada de forma independiente y paralela.
4. **`Main`**: Clase orquestadora encargada de inicializar los objetos de prueba, lanzar los hilos en paralelo y medir los tiempos globales de ejecución.

## 🚀 Cómo Ejecutar el Proyecto

1. Asegúrate de tener instalado el Java Development Kit (JDK 17 o superior).
2. Abre la terminal en la raíz del proyecto y compila todas las clases:
   ```bash
   javac *.java