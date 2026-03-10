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

```

```

---

## ⚙️ Compilar y Ejecutar

```bash
# Compilar programa
javac -cp .;lib/json-20240303.jar -d out fuentes/com/iescastelar/*.java y
ejecucion -> java -cp out;lib/json-20240303.jar com.iescastelar.Main

# Compilar tests
ompilar tests javac -cp "out;lib/json-20240303.jar;lib/junit-platform-console-standalone-1.10.2.jar;lib/junit-jupiter-api-5.10.2.jar" -d out fuentes\com\iescastelar\tests\MemeTest.java
Ejecutar tests: java -jar lib/junit-platform-console-standalone-1.10.2.jar -cp "out;lib/json-20240303.jar;lib/junit-jupiter-api-5.10.2.jar;lib/junit-jupiter-engine-5.10.2.jar" --select-class=com.iescastelar.tests.MemeTest
```

> 📚 Consulta [`documentacion/instalacion.md`](documentacion/instalacion.md) para instrucciones detalladas.

---

## 📜 Licencia

Este proyecto tiene fines **exclusivamente educativos**.
