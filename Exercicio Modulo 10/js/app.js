import { Cliente } from "./classes.js";
import { criarLinha, transformaEmCliente } from "./utils.js";

//pegar o endpoint "Servidor-BackEnd"
const url = "https://crudcrud.com/api/962d9c16282240c0bcf00a44bc28103b/CadastroCliente"


//Pegar os clientes que estao cadastrados na api
fetch(url)
.then(resposta => resposta.json())
.then((cadastros) =>{
    const clientes = transformaEmCliente(cadastros);
    clientes.forEach(cliente => {
        const linha = criarLinha(cliente, excluirCadastro)
        document.querySelector('#listaCliente').appendChild(linha)
    })
})


//pegar o formulario para poder pegar os dados que o usuario digitar
const formularioDeCadastro = document.querySelector("form");

formularioDeCadastro.addEventListener("submit", (evento) =>{
    evento.preventDefault();
    //pega dos dados informados pelo cliente
    const nomeInformado = formularioDeCadastro.elements.nome.value
    const emailInformado = formularioDeCadastro.elements.email.value
    //Cria uma nova variavel com a classe cliente, passando os dados que foram passados
    const novoCliente = new Cliente(nomeInformado, emailInformado)

    //Envia para a api
    fetch(url, {
        method: "POST",
        headers:{
            "Content-Type": "application/json"
        },
        body: JSON.stringify(novoCliente.toJSON())
    })
    .then(resposta => resposta.json())
    //Depois pega o novo cliente cadastrado e insere no html
    .then((clienteCadastrado) =>{
        const clienteNovo = new Cliente(clienteCadastrado.nome, clienteCadastrado.email, clienteCadastrado._id)
        const linha = criarLinha(clienteNovo, excluirCadastro)
        document.querySelector('#listaCliente').appendChild(linha)
        formularioDeCadastro.reset()
    })
})


//funçao utilizado no botao excluir
function excluirCadastro(_id, botao){
    fetch(`${url}/${_id}`, {
        method : "DELETE",
    })
    .then(()=>{
        botao.closest("tr").remove();
    })
}