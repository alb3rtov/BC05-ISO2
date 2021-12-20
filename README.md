# Práctica de Ingeniería del Software II

### Configuración de proyecto Java y Maven con Eclipse
Para configurar el proyecto utilizando Eclipse estos son los pasos a seguir:

- Clonar el repositorio desde el apartado de `Git repositories`
- En la sección de ``Package Explorer``, click derecho y darle a _Import_ > _Project from Git (with smart import)_ > _Existing local repository_ y selecciona el repositorio de _BC05-ISO2_.
- Simplemente darle a siguiente en cada pestaña y listo.

### Ramas del proyecto
Para tener las diferentes ramas del proyecto en local utilizando Eclipse se tienen que realizar los siguientes pasos:

- Click derecho en el proyecto > _Team_ > _Switch to_ > _Other..._
- A continuación, en la carpeta de _Remote Tracking_ seleccionar la rama que quieres tener en local y darle a _Check Out..._ y después a _Check out as New Local Branch_
- Ahora en _Team_ > _Switch to_ ya aparecerá la rama en local.

### Solución error _missing directories_ con módulos de Maven
En el caso de haber hecho un _pull_ o clonar el repositorio, puede que algunos módulos de Maven no funcionen correctamente debido a que ciertos directorios no se encuentran. Este fallo ocurre debido a que los directorios vacíos no se incluyen cuando se realiza un _commit_. La solución es crear dichos directorios en los módulos Maven que falle, de la siguiente manera:

- Para saber que directorios faltan: Click derecho en el proyecto > _Build Path_ > _Configure Build Path_. Ahí aparecerán los directorios _missing_ que faltan.
- Click derecho en el proyecto (módulo de Maven que falle) > _New_ > _Other..._ > _Source Folder_
- Hay que crear los directorios que no se encuentren, normalmente son: `src/main/resources`, `src/test/java` y `src/test/resources`

### Solución no aparece el proyecto de una rama distinta a la master en eclipse
Si tras haber hecho un _pull_ del repositorio, y haber cambiado de rama tal y como se explica en uno de los apartados anteriores, no aparece el proyecto correspondiente a la rama a la que hemos cambiado, se recomienda eliminar el repositorio al completo y volver a importarlo. 

Durante el proceso de importación, una vez hayamos pasado la ventana en la que se nos piden los datos del repositorio y usuario y contraseña, y haber seleccionado las ramas que deseamos importar, nos aparecera otra ventana en la que deberemos cambiar la rama inicial. En dicho parámetro aparecerá por defecho "Master", que deberemos cambiar con la rama deseada.

De esta forma nos aparecerán los proyectos que no aparecen de otra forma.
