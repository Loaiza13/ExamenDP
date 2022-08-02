<?php
	$datos = json_decode(file_get_contents("https://my-json-server.typicode.com/dp-danielortiz/dptest_jsonplaceholder/items"),true);
	$archivo = fopen("Respuesta1.json", "w+b");

	for($i=0; count($datos) > $i; $i++)
	{
		if($datos[$i]["color"] == "green")
		{
			fwrite($archivo, "id: ".$datos[$i]["id"]."\n");
			fwrite($archivo, "type: ".$datos[$i]["type"]."\n");
			fwrite($archivo, "color: ".$datos[$i]["color"]."\n");
		}
	}

	header("Content-disposition: attachment; filename=Respuesta1.json");
	header("Content-type: MIME");
	readfile("Respuesta1.json");
	fclose($archivo); 
	
?>