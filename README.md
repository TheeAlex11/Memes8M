# 🎮 PROYECTO Memes 8M

> 🎓 Proyecto educativo desarrollado en Java para la asignatura de **DAW**

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Estado-En%20Desarrollo-yellow?style=for-the-badge)

---

## 👥 Integrantes

| 👤 Nombre | 
|---|
| Izan Cano |
| Vicente Ayuso |
| Alejandro Bautista |

---

## 📖 Introducción

Proyecto educativo que consiste en un **juego de consola** que muestra bulos *(memes)* sobre igualdad de género y reta al jugador a desmentirlos eligiendo el dato real correcto, siempre respaldado con fuente oficial.

---

## 🕹️ Descripción

El juego presenta **5 rondas aleatorias**. En cada ronda:

1. 🃏 Se muestra un **meme con un bulo**
2. 📋 Se presenta una **lista de realidades** entre las que elegir
3. ✅ El jugador selecciona la respuesta correcta
4. 🏆 Al finalizar, la **puntuación se guarda** si está entre las 3 mejores

---

## 📁 Estructura del Proyecto

Memes8M
│   README.md
│   BackLog.md
│
├── compilados/        # Clases .class compiladas
├── datos/             # Ficheros de datos del juego
│   ├── memes.txt
│   ├── realidades.json
│   └── soluciones.xml
│
├── documentacion/     # Manuales y javadoc
│   ├── instalacion.md
│   ├── manual_usuario.md
│   ├── Memes-8M-Manual_Usuario.pdf
│   └── javadoc/
│
├── fuentes/           # Código fuente del programa
│   ├── GestorFicheros.java
│   ├── Juego.java
│   ├── Main.java
│   ├── Meme.java
│   ├── Puntuacion.java
│   └── Realidad.java
│
├── tests/             # Tests JUnit
│
├── resultados/        # Resultados generados por el juego
│   └── mejores.txt
│
└── lib/               # Librerías externas (JUnit, JSON)

## ⚙️ Compilar y Ejecutar

```bash
# Compilar programa
javac -cp "lib/json-20251224.jar" -d compilados fuentes/*.java

# Ejecutar programa
java -cp "compilados;lib/json-20251224.jar" Main

# Compilar tests
javac -cp "compilados;lib/json-20251224.jar;tests/lib/junit-jupiter-api-5.9.2.jar" -d compilados tests/*.java fuentes/*.java

#Ejecutar tests
java -jar tests/lib/junit-platform-console-standalone-1.9.2.jar -cp "compilados;lib/json-20251224.jar;tests/lib/junit-jupiter-api-5.9.2.jar;tests/lib/junit-jupiter-engine-5.9.2.jar" --scan-classpath

> 📚 Consulta [`documentacion/instalacion.md`](documentacion/instalacion.md) para instrucciones detalladas.

---

## 📜 Licencia
Este proyecto tiene fines **exclusivamente educativos**.
