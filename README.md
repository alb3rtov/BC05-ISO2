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

- Para saber que directorios faltan: Click derecho en el proyecto > _Build Path_ > _Configure Build Path_. Hay aparecerán los directorios _missing_ que faltan.
- Click derecho en el proyecto (módulo de Maven que falle) > _New_ > _Other..._ > _Source Folder_
- Hay que crear tantos directorios como directorios que no se encuentren, normalmente son: `src/main/resources`, `src/test/java` y `src/test/resources`
