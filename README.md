# Proyecto DAM con Spoonacular

Proyecto para Programación Multimedia y Dispositivos Móviles 2020-2021 por Carlos Víllora Tercero.

## Motivación

Quería hacer algún proyecto con APIs y buscando por internet me tope con este. Luego concretando intentaré hacer una aplicación que maneje datos de comida y nutrición.

## Instalación

Clona el proyecto en android studio y copia o crea el fichero Secrets.java en este directorio "app/src/main/java/com/cavitedet/proyectodam_spoonacular/". Este fichero no lo subiré a github porque contiene mi clave privada, esta clase tiene una variable privada final statica llama `apiKey` y si getter.

## Idioma

Estoy muy acostumbrado al inglés y empecé haciendo las cosas en inglés, pero lo que planeo al final es tener el código principalmente en español sin cambiar el idioma a todo lo que ya tenía hecho y la interfaz en español menos los elementos de la api que estarán en inglés.

## Dependencias

La aplicación se ha hecho con un nivel mínimo de API 21 (lollipop) y con Java. Se utilizarán algunas dependencias del  [SDK](https://spoonacular.com/food-api/sdk) y puede que otras más con el tiempo, eso se puede ver en el [gradle](./app/build.gradle).

## Pantallas

### 1) Main Activity, la búsqueda

En la pantalla principal se mostrará un `EditText` pidiendo el nombre (en inglés) del ingrediente que busca, se comprobará que el dispositivo está conectadoa internet y se pasará a la siguiente actividad pasando en el `intent` un string con el ingrediente a buscar.

### 2) Lista de ingredientes

Se intentará cargar los primeros ingredientes de la [API](https://spoonacular.com/food-api/docs#Ingredient-Search), en esta pantalla se mostrarán los errores e información relevante para poner en marcha el sistema. Una vez cargados, se mostrarán mediante un `RecylerView` la lista de ingredientes. Además contará menús en el `actionbar` que te dejará opciones de cambiar la dirección de los elementos mostrados (ascendente descendente), otra para ir a la pantalla de [filtrado](#4-filtraje-de-ingredientes), otra para ir una pantalla de [ordenado](#5-ordenado-de-ingredientes) para cambiar la petición de la [API](https://spoonacular.com/food-api/docs#Ingredient-Search) al volver y por último una opción para cambiar la resolución en los `SharedPreferences` en el [dialogo de resolución](#dialogo-de-resolucion). Además cada ingrediente se debe poder pulsar y entrar en una ventana con [información adicional del ingrediente](#3-detalles-del-ingrediente).

Así se está viendo

![Lista imagen](/resources/captura_lista.jpg)

### 3) Detalles del ingrediente

Se cargará lo que encuentre en está llamada a la [API](https://spoonacular.com/food-api/docs#Get-Ingredient-Information) y recibirá el id del producto a través del `Intent`, de aquí solo se podrá volver a la actividad [lista de ingredientes](#2-lista-de-ingredientes).

### 4) Filtraje de ingredientes

En esta ventana emergente habrán varios `RangeSlider` para filtrar por el mínimo y máximo de proteínas, grasas y carbohidratos, de aquí solo se podrá volver a la [lista de ingredientes](#2-lista-de-ingredientes) .

### 5) Ordenado de ingredientes

Se mostrará algunos `RadioButton` con las opciones de ordenador que aparecen en esta [página](https://spoonacular.com/food-api/docs#Recipe-Sorting-Options) de aquí solo se podrá volver a la [lista de ingredientes](#2-lista-de-ingredientes).

### 6) Dialogo de resolución

En esta venta, se guardará la resolución que querrá el usuario siendo la pequeña 100x100, la mediana 250x250 y la grande 500x500 en los `SharedPreferences` mediante la clase [ConversorImagen](./app/src/main/java/com/cavitedet/proyectodam_spoonacular/domain/spoonacular/utilidades/ConversorImagen.java) que administrá las peticiones de imagenes para que se devuelvan con la resolución establecida, además de poder establecer nuevas resoluciones.

## Estructura

La aplicación se dividirá en 4 capas que serán las siguientes:

### 1) Dominio

Aquí estarán todas las [clases de datos](./app/src/main/java/com/cavitedet/proyectodam_spoonacular/domain/spoonacular/modelos) con las que se trabajará y las que devolverá el api, también otras [utilidades](./app/src/main/java/com/cavitedet/proyectodam_spoonacular/domain/spoonacular/utilidades) no ligadas a la presentación y una [clase por cada llamada a la api](./app/src/main/java/com/cavitedet/proyectodam_spoonacular/domain/spoonacular/usecases) para manejar los datos necesarios para su llamada y la adaptación de estos

### 2) Infraestructura

Aquí están varias clases modificadas a partir del [SDK](https://spoonacular.com/food-api/sdk) de la aplicación para android, desde aquí se podrán hacer las peticiones a la API

### 3) Aplicación

Todas las clases que gestionan la UI, activities, etc. desde Java

### 4) Presentación

Los ficheros en res son la parte de la interfaz gráfica

## Plantilla Requisitos

### 1) Tiene que constar de varias actívities, aunque también puede contener otros elementos 

Eso está explicado en la parte de [pantallas](#pantallas), los 3 primeros son los activities [busqueda](#1-main-activity-la-búsqueda), [listado](#2lista-de-ingredientes) y [detalles](#3-detalles-del-ingrediente).

### 2) Debe haber al menos dos o más activities que se comuniquen información con intents

La actividad [busqueda](#1-main-activity-la-búsqueda) pasá un string a la petición de la actividad [listado](#2lista-de-ingredientes) y la actividad [listado](#2lista-de-ingredientes) pasa el id del producto a la actividad [detalles](#3-detalles-del-ingrediente).

### 3) Debe contener al menos un ListView donde al pulsar en los elementos ocurra algo.

La actividad [listado](#2lista-de-ingredientes) contiene un `RecyclerView` con cada ingrediente y al pulsarlo se va a la actividad [detalles](#3-detalles-del-ingrediente), está a su vez tiene otro `RecyclerView` para mostrar sus nutrientes, pero no lleva a ningún sitio al pulsarlo.

### 4) Debe usar Preferences y preferiblemente SharedPreferences

En el [dialogo de resolución](#dialogo-de-resolucion) se ajustan en las preferencias la resolución a la cual se quieren mostrar las imágenes para disminuir el consumo de datos de internet.

### 5) Debe contener Actionbars o pestañas o menús.

Contiene 4 menus, 3 con dialogos: [dialogo de filtrado](#4-filtraje-de-ingredientes), [dialogo de ordenado](#5-ordenado-de-ingredientes) y [dialogo de resolución](#dialogo-de-resolucion). El último es el de cambiar el orden de mostrar los productos, aunque estoy pensando en mejorar el [dialogo de ordenado](#5-ordenado-de-ingredientes) para que se pueda elegir el orden allí, no sé si llegaré a implementar eso.
Los iconos son estándares de android para mostrar filtrado y ordenado, aquí una imagen.

![Lista imagen](/resources/menu.jpg)

### 6) Todos los recursos deben estar correctamente organizados (por ejemplo las cadenas y mensajes deben declararse en string.xml y no en los layouts, las imágenes deben ir en su carpeta correspondiente.. etc)

No hay muchas imágenes porque las descargo de Internet, pero tengo todos los strings importantes están en [string.xml](./app/src/main/res/values/strings.xml), pensaba en dividir los strings para poder implementar varios idiomas en la aplicación, pero supongo que lo probarás con el emulador en inglés y no quiero que te asustes al leer todos los textos en inglés.

### 7) Presentación gráfica y el uso de elementos no vistos en clase (menús, pestañas, controles personalizados, etc)

No me he molestado mucho en los elementos usados, simplemente me he basado en `LinearLayout`, `AlertDialog` y por ejemplo, he utilizado el `RangeSlider` de *Material* personalizado para mostrar el mínimo y máximo del [filtrado](#4-filtraje-de-ingredientes).

![Lista imagen](/resources/range_slider.jpg)

### 8) Se valora el uso de otros elementos vistos en clase… 

Diría que ya he mencionado la mayor parte de cosas y las preguntas anteriores preguntan acerca de cada tema que hemos estudiado, se puede ir comprobando como he utilizado elementos básicos como `Button` en la búsqueda habilitándolo y deshabilitandolo según haya texto en el `EditText`, es un ejemplo de algo que hemos dado en clase aunque puedes ir viendo como está hecha cada pantalla.

### 9) Otros comentarios o elementos incluidos.

#### API

He utilizado una [API](https://spoonacular.com) de comida que aumenta el nivel de complejidad de la aplicación junto código asíncrono hecho en java porque `AsyncTask` se quedo obsoleto en la api 30 de Android, es mejorable ya que no muestra ningún indicador de carga, pero personalmente en código asíncrono Java se queda detrás de lenguajes más modernos como Kotlin y hacen más dificil su implementación.

#### Tests

También he añadido unos pocos [tests unitarios](./app/src/test/java/com/cavitedet/proyectodam_spoonacular) para ir desarrollando cosas específicas como guardar imágenes en `SharedPreferences` o para aplicar cierta lógica al cambiar el mínimo y máximo del filtrado o para comprobar que deserializa correctamente los jsons.
También tengo [tests instrumentados](./app/src/androidTest/java/com/cavitedet/proyectodam_spoonacular) para comprobar el funcionamiento real de la [API](https://spoonacular.com) y del manejo de la aplicación navegando por ella con la librería de Espresso.
Estos tests no se esperán que estén completos para todas las partes de la aplicación, simplemente he hecho allí dónde consideraba que hiciera más falta.

#### Control de Versiones

He utilizado git con github para el control de versiones, llegando a introducir un kanban con el proyecto para ir haciendo algunas tareas actividades y dejando la oportunidad a otros de ver y modificar mi código, también he participado en dos proyectos de mis compañeros [SimpleAndroidRPG](https://github.com/JoseLu-Dev/SimpleAndroidRPG) y [proyectobd](https://github.com/INDOMINUS-ALFA/proyectobd)
