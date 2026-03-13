# Manual de Usuario — Proyecto Memes 8M

## ¿Qué es Memes 8M?

**Memes 8M** es un juego educativo en consola que te reta a desmentir bulos sobre igualdad de género con datos reales procedentes de fuentes oficiales (INE, Ministerio de Igualdad, Eurostat, etc.).

Cada partida consta de **5 rondas**. En cada ronda verás un meme (bulo) y deberás elegir el dato real que lo desmiente entre varias opciones.

---

## Inicio del Programa

Al ejecutar el programa, verás la pantalla de bienvenida:

```comando para compilar el `programa > javac -cp .;lib/json-20240303.jar -d out fuentes/com/iescastelar/*.java y ejecucion -> java -cp out;lib/json-20240303.jar com.iescastelar.Main
compilar tests javac -cp "out;lib/json-20240303.jar;lib/junit-platform-console-standalone-1.10.2.jar;lib/junit-jupiter-api-5.10.2.jar" -d out fuentes\com\iescastelar\tests\MemeTest.java
ejecutar tests: java -jar lib/junit-platform-console-standalone-1.10.2.jar -cp "out;lib/json-20240303.jar;lib/junit-jupiter-api-5.10.2.jar;lib/junit-jupiter-engine-5.10.2.jar" --select-class=com.iescastelar.tests.MemeTest

     BIENVENIDA AL JUEGO 8M       
 Desmiente los bulos con datos reales     

```

Si algún fichero de datos no existe, el programa mostrará un error y se detendrá:

```
No se encontró el fichero obligatorio: datos/memes.txt
   Asegúrate de que existe el directorio 'datos' con los ficheros:
   memes.txt, realidades.json y soluciones.xml
```

---

## Desarrollo de una Ronda

En cada ronda verás:

1. **El meme (bulo)** que debes desmentir:
```
──────────────────────────────────────────
🔹 Ronda 1 de 5
🤳 MEME #5: "La brecha salarial es un mito inventado por feministas"

¿Qué dato REAL desmiente este bulo?
```

2. **Lista numerada de realidades** entre las que elegir:
```
  1. Según la Encuesta de Estructura Salarial del INE (2022)...
     [Fuente: INE - Encuesta de Estructura Salarial 2022]

  2. El informe 'Women in Tech' de la UE (2022) señala...
     [Fuente: Comisión Europea - Women in Digital Scoreboard 2022]

  ...

Introduce el número de tu respuesta (1-8):
```

3. **Resultado de la ronda:**

Si aciertas:
```
 ¡Correcto! Has ganado un punto.

Marcador: 1 / 1
```

Si fallas:
```
 Incorrecto. La respuesta correcta era:
   Eurostat confirma que la brecha salarial de género en la UE es del 12,7%...
   [Fuente: Eurostat - Gender pay gap statistics 2022 / INE 2022]

 Marcador: 0 / 1
```

---

## Fin de la Partida

Al completar las 5 rondas, verás tu puntuación final:

```

🏁 FIN DE LA PARTIDA
   Puntuación final: 4 / 5

```

---

## Registro de Puntuación

Si tu puntuación está entre las 3 mejores, el juego te pedirá tu nombre:

```
 ¡Enhorabuena! Tu puntuación está entre las mejores.
Introduce tu nombre: María
```

---

## Tabla de Mejores Puntuaciones

Al final siempre se muestra el ranking:

```
 MEJORES PUNTUACIONES:
──────────────────────────────────────────
  1. María → 5 puntos
  2. Ana → 4 puntos
  3. Lucía → 3 puntos

 ¡Gracias por jugar! Feliz 8M 💜
```

---

## Consejos

- Lee con atención el texto de cada realidad y su fuente antes de responder.
- Aunque no aciertes, aprenderás datos reales sobre desigualdad de género.
- Las opciones se barajan cada vez, ¡no memorices el orden!
