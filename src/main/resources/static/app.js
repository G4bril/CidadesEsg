const apiUrl = "http://localhost:8080/api/cidades";

const form = document.getElementById("cidadeForm");
const tableBody = document.querySelector("#cidadesTable tbody");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const cidade = {
        nome: document.getElementById("nome").value,
        estado: document.getElementById("estado").value,
        populacao: document.getElementById("populacao").value,
        indiceEsg: document.getElementById("indiceEsg").value
    };

    const id = document.getElementById("cidadeId").value;

    try {
        const method = id ? "PUT" : "POST";
        const url = id ? `${apiUrl}/${id}` : apiUrl;

        await fetch(url, {
            method,
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(cidade)
        });

        form.reset();
        document.getElementById("cidadeId").value = "";
        await carregarCidades();
    } catch (error) {
        alert("Erro ao salvar cidade: " + error);
    }
});

async function carregarCidades() {
    const response = await fetch(apiUrl);
    const cidades = await response.json();

    tableBody.innerHTML = "";
    cidades.forEach(cidade => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${cidade.id}</td>
            <td>${cidade.nome}</td>
            <td>${cidade.estado}</td>
            <td>${cidade.populacao}</td>
            <td>${cidade.indiceEsg}</td>
            <td>
                <button onclick="editarCidade(${cidade.id})">✏️ Editar</button>
                <button onclick="deletarCidade(${cidade.id})">🗑️ Excluir</button>
            </td>
        `;
        tableBody.appendChild(row);
    });
}

async function editarCidade(id) {
    const response = await fetch(`${apiUrl}/${id}`);
    const cidade = await response.json();

    document.getElementById("cidadeId").value = cidade.id;
    document.getElementById("nome").value = cidade.nome;
    document.getElementById("estado").value = cidade.estado;
    document.getElementById("populacao").value = cidade.populacao;
    document.getElementById("indiceEsg").value = cidade.indiceEsg;
}

async function deletarCidade(id) {
    if (!confirm("Deseja realmente excluir esta cidade?")) return;

    await fetch(`${apiUrl}/${id}`, { method: "DELETE" });
    await carregarCidades();
}

// Inicializa
carregarCidades();
