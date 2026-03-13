# Manual de Instalación — Proyecto Memes 8M

## 1. Requisitos del Sistema

| Componente | Versión mínima |
|---|---|
| JDK (Java Development Kit) | 17 o superior |
| Sistema Operativo | Windows 10 / Ubuntu 20.04 / macOS 12 |
| Git | 2.x o superior |

Para comprobar tu versión de Java:
```bash
java -version
javac -version
```

---

## 2. Descargar el Proyecto

Clona el repositorio desde el aula virtual o GitHub:

```bash
git clone <https://github.com/TheeAlex11/Memes8M.git>
cd memes8m
```

O descarga el ZIP y descomprímelo en una carpeta local.

---

## 3. Dependencias Externas

El proyecto usa la librería **org.json** para parsear ficheros JSON.

Descarga el JAR desde:  
https://mvnrepository.com/artifact/org.json/json

Coloca el fichero `json-20240303.jar` (o la versión disponible) en una carpeta `lib/` dentro del proyecto:

```
memes8m/
├── datos/
├── resultados/
├── fuentes/
├── lib/
│   └── json-20240303.jar
└── documentacion/
```

---

## 4. Compilar el Proyecto

Desde la raíz del proyecto, ejecuta:

**Linux / macOS:**
```bash
javac -cp .:lib/json-20240303.jar -d out fuentes/com/iescastelar/*.java
```

**Windows:**
```cmd
javac -cp "lib/json-20251224.jar" -d compilados fuentes/*.java
```

Esto generará los `.class` en la carpeta.

---

## 5. Ejecutar el Programa

**Linux / macOS:**
```bash
java -cp out:lib/json-20240303.jar com.iescastelar.Main
```

**Windows:**
```cmd
java -cp out;lib\json-20240303.jar com.iescastelar.Main
```

> ⚠️ El programa debe ejecutarse desde la raíz del proyecto para que las rutas relativas a `datos/` y `resultados/` funcionen correctamente.

---

## 6. Generar el Manual del Programador (Javadoc)

```Windows en caso de que no este en el Path
"C:\Program Files\Java\jdk-21.x.x\bin\javadoc" -d documentacion/javadoc -cp fuentes/lib/json-20251224.jar fuentes/*.java -encoding UTF-8 -charset UTF-8 -docencoding UTF-8```

La documentación HTML se generará en `documentacion/javadoc/`.

---

## 7. Desinstalar

Para eliminar el proyecto, borra la carpeta raíz:

```bash
rm -rf memes8m/
```

No se instala nada en el sistema operativo, por lo que no son necesarios pasos adicionales.
