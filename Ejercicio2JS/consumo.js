const ligaApi = "https://my-json-server.typicode.com/dp-danielortiz/dptest_jsonplaceholder/items";

const xhr = new XMLHttpRequest();

var mostrarHtml = "";

function respuestaRequest()
{
	if(this.readyState == 4 && this.status == 200)
	{
		const data = JSON.parse(this.response);
		console.log(data);
		for(let i=0; data.length > i; i++)
		{
			if(data[i]["color"] == "red")
			{
				console.log(data[i]);
				mostrarHtml = mostrarHtml + "id: " + data[i]["id"] + " type: " + data[i]["type"] + " color: " + data[i]["color"] + "<br>";
			}
		}
	}
	document.getElementById('resp').innerHTML = mostrarHtml
}
xhr.addEventListener("load", respuestaRequest);
xhr.open('GET',ligaApi);
xhr.send();