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
|   .gitignore
|   BackLog.md
|   herramientas.txt
|   README.md
|
+---compilados
|       GestorFicheros.class
|       Juego.class
|       Main.class
|       Meme.class
|       MemeTest.class
|       Puntuacion.class
|       Realidad.class
|       TestGestorFicheros.class
|       TestJuego.class
|       TestPuntuacion.class
|       TestRealidad.class
|
+---datos
|       memes.txt
|       realidades.json
|       soluciones.xml
|
+---documentacion
|   |   instalacion.md
|   |   manual_usuario.md
|   |   Memes-8M-Manual_Usuario.pdf
|   |
|   \---javadoc
|       |   allclasses-index.html
|       |   allpackages-index.html
|       |   element-list
|       |   GestorFicheros.html
|       |   help-doc.html
|       |   index-all.html
|       |   index.html
|       |   Juego.html
|       |   Main.html
|       |   member-search-index.js
|       |   Meme.html
|       |   module-search-index.js
|       |   overview-tree.html
|       |   package-search-index.js
|       |   package-summary.html
|       |   package-tree.html
|       |   Puntuacion.html
|       |   Realidad.html
|       |   search.html
|       |   tag-search-index.js
|       |   type-search-index.js
|       |
|       +---legal
|       |       COPYRIGHT
|       |       dejavufonts.md
|       |       jquery.md
|       |       jqueryUI.md
|       |       LICENSE
|       |
|       +---resource-files
|       |   |   copy.svg
|       |   |   glass.svg
|       |   |   jquery-ui.min.css
|       |   |   left.svg
|       |   |   link.svg
|       |   |   right.svg
|       |   |   stylesheet.css
|       |   |   x.svg
|       |   |
|       |   \---fonts
|       |           dejavu.css
|       |           DejaVuLGCSans-Bold.woff
|       |           DejaVuLGCSans-Bold.woff2
|       |           DejaVuLGCSans-BoldOblique.woff
|       |           DejaVuLGCSans-BoldOblique.woff2
|       |           DejaVuLGCSans-Oblique.woff
|       |           DejaVuLGCSans-Oblique.woff2
|       |           DejaVuLGCSans.woff
|       |           DejaVuLGCSans.woff2
|       |           DejaVuLGCSansMono-Bold.woff
|       |           DejaVuLGCSansMono-Bold.woff2
|       |           DejaVuLGCSansMono-BoldOblique.woff
|       |           DejaVuLGCSansMono-BoldOblique.woff2
|       |           DejaVuLGCSansMono-Oblique.woff
|       |           DejaVuLGCSansMono-Oblique.woff2
|       |           DejaVuLGCSansMono.woff
|       |           DejaVuLGCSansMono.woff2
|       |           DejaVuLGCSerif-Bold.woff
|       |           DejaVuLGCSerif-Bold.woff2
|       |           DejaVuLGCSerif-BoldItalic.woff
|       |           DejaVuLGCSerif-BoldItalic.woff2
|       |           DejaVuLGCSerif-Italic.woff
|       |           DejaVuLGCSerif-Italic.woff2
|       |           DejaVuLGCSerif.woff
|       |           DejaVuLGCSerif.woff2
|       |
|       \---script-files
|               jquery-3.7.1.min.js
|               jquery-ui.min.js
|               script.js
|               search-page.js
|               search.js
|
+---fuentes
|   |   GestorFicheros.java
|   |   Juego.java
|   |   Main.java
|   |   Meme.java
|   |   Puntuacion.java
|   |   Realidad.java
|   |
|   \---lib
|           json-20251224.jar
|
+---lib
|       json-20251224.jar
|       junit-jupiter-api-5.10.2.jar
|       junit-jupiter-engine-5.10.2.jar
|       junit-platform-console-standalone-1.10.2.jar
|
+---resultados
|       .gitkeep
|       mejores.txt
|
\---tests
    |   TestGestorFicheros.java
    |   TestJuego.java
    |   TestMeme.java
    |   TestPuntuacion.java
    |   TestRealidad.java
    |
    \---lib
            junit-jupiter-api-5.9.2.jar
            junit-jupiter-engine-5.9.2.jar
            junit-platform-console-standalone-1.9.2.jar
```
## ⚙️ Compilar y Ejecutar

```bash
# Compilar programa
javac -cp "lib/json-20251224.jar" -d compilados fuentes/com/iescastelar/*.java

# Ejecutar programa
java -cp "compilados;lib/json-20251224.jar" Main

# Compilar tests
javac -cp "compilados;lib/json-20251224.jar;tests/lib/junit-jupiter-api-5.9.2.jar" -d compilados tests/*.java fuentes/com/iescastelar/*.java

#Ejecutar tests
java -jar tests/lib/junit-platform-console-standalone-1.9.2.jar -cp "compilados;lib/json-20251224.jar;tests/lib/junit-jupiter-api-5.9.2.jar;tests/lib/junit-jupiter-engine-5.9.2.jar" --scan-classpath

> 📚 Consulta [`documentacion/instalacion.md`](documentacion/instalacion.md) para instrucciones detalladas.

---

## 📜 Licencia
Este proyecto tiene fines **exclusivamente educativos**.
