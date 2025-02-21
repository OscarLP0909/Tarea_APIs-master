<h1>TAREA APIs</h1>

<p>En esta tarea he elegido hacerlo sobre los hoteles, para ello, he creado en MongoDB una nueva base de datos llamada hoteles y en ella creado una colección del mismo nombre.

He utilizado las columnas de:
<ol>
<li>_id</li> 
<li>nombre</li>
<li>ciudad</li>
<li>país</li>
<li>estrellas</li>
<li>precioPorNoche</li>
<li>telefono</li>
</ol>

<p>Una vez creado los elementos, me puse a configurar el SpringBoot en mi proyecto, una vez configurado, he procedido con la creación de los Endpoints.</p>

He creado los siguientes:
<ul>
<li><strong><i> web/ [GET]</i></strong></li> 
<p>En este Endpoint, junto con los archivos html y css, hacemos que nos aparezca una lista con todos los hoteles que haya en la base de datos.</p>

![image](https://github.com/user-attachments/assets/b00319ec-236d-463d-abc2-759a3e1fd9ca)
  

<li><strong><i>/web/new [GET]</i></strong></li>
<p>Aquí, generamos un formulario para que se cree un nuevo hotel.</p>


![image](https://github.com/user-attachments/assets/d5b9f812-44dc-49f9-8c58-a2944e180d0d)

<li><strong><i>/web/new [POST]</i></strong></li>
<p>Esto nos sirve para guardar el hotel que hayamos creado y almacenarelo en la base de datos.</p>

<li><strong><i>/web/{id} [GET]</i></strong></li>
<p>Con este Endpoint obtenemos un hotel en concreto a través de su id.</p>

![image](https://github.com/user-attachments/assets/ca934c5a-ff2c-4bf5-95b1-3011fe6ba021)

<li><strong><i>/web/{id}/edit [GET]</i></strong></li>
<p>Cargamos el formulario para editar los datos de un hotel existente, apareciendo los datos que ya tiene de por sí.</p>

![image](https://github.com/user-attachments/assets/df6254b1-8fb5-441b-9661-0d721b04e874)

<li><strong><i>/web/{id}/edit [PUT]</i></strong></li>
<p>Utilizamos este método para actualizar los datos una vez modificado los campos, una curiodad es que para que esto funcione, al ser un formulario, tenemos que "esconder" el método PUT en un método POST.</p>


<li><strong><i>/api/ciudad/{ciudad} [GET]</i></strong></li>
<p>Obtenemos en formato JSON los hoteles que cumplan con la ciudad que pongamos en el URI.</p>

![image](https://github.com/user-attachments/assets/62eedeb2-25f7-4fbe-a629-b62f263036f9)



<li><strong><i>/api/hoteles [GET]</i></strong></li>
<p>Obtenemos en formato JSON la lista de hoteles que tengamos en la base de datos.</p>

![image](https://github.com/user-attachments/assets/4a5ad19e-f928-4ac4-8991-21a5c38f66b8)




<li><strong><i>/api/hoteles/estrellas/{estrellas} [GET]</i></strong></li>
<p>En formato JSON obtenemos los hoteles que tengan la cantidad de estrellas que especificamos.</p>

![image](https://github.com/user-attachments/assets/34b07064-1dfb-4e2f-b8cf-70878a7644be)





<li><strong><i>/api/hoteles/{id} [GET]</i></strong></li>
<p>Un JSON que nos muestra el hotel con el ID que pongamos en el URI.</p>

![image](https://github.com/user-attachments/assets/e2744666-5c77-49ad-8311-6e91484bdc6e)
</ul>
