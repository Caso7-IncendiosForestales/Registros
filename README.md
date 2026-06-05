GET
http://localhost:8087/api/registros

GET
http://localhost:8087/api/registros/{id}

POST
http://localhost:8087/api/registros
{
    "incendioId": 2,
    "familiasAfectadas": 5,
    "resumenIncendio": "Incendio forestal controlado en zona rural",
    "detalleRecursos": "2 camiones aljibe, 1 brigada terrestre",
    "detalleHerramientas": "Palas, rastrillos, motosierras"
}
