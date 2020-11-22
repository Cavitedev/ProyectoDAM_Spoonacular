# Proyecto DAM con Spoonacular

Proyecto para Programación Multimedia y Dispositivos Móviles 2020-2021 por Carlos Víllora Tercero

## Motivación

Quería hacer algún proyecto con APIs y buscando por internet me tope con este. Luego concretando intentaré hacer una aplicación que maneje datos de comida y nutrición

## Idioma

Estoy muy acostumbrado al inglés, he empezado haciendo *commits* en español, pero lo que planeo al final es tener el código enteramente en inglés, solo está documentación y los *commits* estarán en español

## Dependencias

La aplicación se ha hecho con un nivel mínimo de API 21 (lollipop) y con Java. Se utilizarán algunas dependencias del  [SDK](https://spoonacular.com/food-api/sdk) y puede que otras más con el tiempo, eso se puede ver en el [gradle](./app/build.gradle)

## Activities

### 1) Main Activity, la carga

En la pantalla principal se mostrará un `EditText` pidiendo el nombre (en inglés) del ingrediente que busca y se intentará cargar los primeros ingredientes de la [API](https://spoonacular.com/food-api/docs#Ingredient-Search), en esta pantalla se mostrarán los errores e información relevante para poner en marcha el sistema, una vez cargue se entrará en la aplicación con esos datos enviados a través del `intent`

### 2) Lista de ingredientes

Una vez cargado mediante un `RecylerView` la lista de ingredientes que con un menú en el `actionbar` que te dará opciones de cambiar la dirección de los elementos mostrados (ascendente descendente), otra para ir a la pantalla de [filtrado](#4-filtraje-de-ingredientes), y la última para ir una pantalla de [ordenado](#5-ordenado-de-ingredientes) con los `SharedPreferences` actualizados en estos casos para cambiar la petición de la [API](https://spoonacular.com/food-api/docs#Ingredient-Search) al volver. Además cada ingrediente se debe poder pulsar y entrar en una ventana con [información adicional del ingrediente](#3-detalles-del-ingrediente)

Así se está viendo
![Lista imagen](/resources/captura_lista.png)

### 3) Detalles del ingrediente

Se cargará lo que encuentre en está llamada a la [API](https://spoonacular.com/food-api/docs#Get-Ingredient-Information) y recibirá el id del producto a través del `Intent`, de aquí solo se podrá volver a la [lista de ingredientes](#2-lista-de-ingredientes) con los `SharedPreferences` actualizados

### 4) Filtraje de ingredientes

En esta ventana habrá varios `SeekBar` para filtrar por el mínimo y máximo de proteína, grasa y carbohidratos, de aquí solo se podrá volver a la [lista de ingredientes](#2-lista-de-ingredientes) con los `SharedPreferences` actualizados

### 5) Ordenado de ingredientes

Se mostrará muchos `RadioButton` con las opciones de ordenador que aparecen en esta [página](https://spoonacular.com/food-api/docs#Recipe-Sorting-Options) de aquí solo se podrá volver a la [lista de ingredientes](#2-lista-de-ingredientes) 

## Estructura

La aplicación se dividirá en 4 capas que serán las siguientes:

### 1) Dominio

Aquí estarán todas las clases de datos con las que se trabajará y las que devolverá el api

### 2) infraestructura

Aquí están varias clases modificadas a partir del [SDK](https://spoonacular.com/food-api/sdk) de la aplicación para android, desde aquí se podrán hacer las peticiones a la API

### 3) Aplicación

Todas las clases que gestionan la UI, activities, etc. desde Java

### 4) Presentación

Los ficheros en res son la parte de la interfaz gráfica

## Idioma

La aplicación estará en español aunque seguiré utilizando los términos propios de Android, para poder trabajar con la API, tendré que trabajar con una API de traducción para poder visualizar los elementos correctamente aunque sea muy complicado
