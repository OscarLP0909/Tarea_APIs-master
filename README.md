TAREA APIs

En esta tarea he elegido hacerlo sobre los hoteles, para ello, he creado en MongoDB una nueva base de datos llamada hoteles y en ella creado una colección del mismo nombre.

He utilizado las columnas de _id, nombre, ciudad, país, estrellas, precioPorNoche y telefono.

Una vez creado los elementos, me puse a configurar el SpringBoot en mi proyecto, una vez configurado, he procedido con la creación de los Endpoints.

He creado los siguientes:
- /web/ [GET] : En este Endpoint, junto con los archivos html y css, hacemos que nos aparezca una lista con todos los hoteles que haya en la base de datos.

![image](https://github.com/user-attachments/assets/b00319ec-236d-463d-abc2-759a3e1fd9ca)
  

- /web/new [GET] : Aquí, generamos un formulario para que se cree un nuevo hotel.

![image](https://github.com/user-attachments/assets/d5b9f812-44dc-49f9-8c58-a2944e180d0d)

- /web/new [POST] : Esto nos sirve para guardar el hotel que hayamos creado y almacenarelo en la base de datos.

- /web/{id} [GET]: Con este Endpoint obtenemos un hotel en concreto a través de su id.

![image](https://github.com/user-attachments/assets/ca934c5a-ff2c-4bf5-95b1-3011fe6ba021)

- /web/{id}/edit [GET] : Cargamos el formulario para editar los datos de un hotel existente, apareciendo los datos que ya tiene de por sí.

![image](https://github.com/user-attachments/assets/df6254b1-8fb5-441b-9661-0d721b04e874)

- /web/{id}/edit [PUT] : Utilizamos este método para actualizar los datos una vez modificado los campos, una curiodad es que para que esto funcione, al ser un formulario, tenemos que "esconder" el método PUT en un método POST.


- /api/ciudad/{ciudad} [GET] : Obtenemos en formato JSON los hoteles que cumplan con la ciudad que pongamos en el URI.

![image](https://github.com/user-attachments/assets/62eedeb2-25f7-4fbe-a629-b62f263036f9)



- /api/hoteles [GET] : Obtenemos en formato JSON la lista de hoteles que tengamos en la base de datos.

![image](https://github.com/user-attachments/assets/4a5ad19e-f928-4ac4-8991-21a5c38f66b8)
