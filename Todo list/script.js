//ciclo de vida: DNS, conexão, requisição, resposta.

// Pegar a lista para poder manipular ela
const tarefas = document.getElementById("listaTarefas")
const url = "https://crudcrud.com/api/b05a11e03e1f48fe87d1570f3e7178bc/tarefas";

fetch(url) //Estabelecer a conexao
.then(resposta => resposta.json()) //Pegar o corpo da resposta e transformar em json
.then((listaDeTarefas)=> { //Pegar o json e manipular
    listaDeTarefas.forEach(tarefa => { //Percorrer o array do json

        const iten = document.createElement("li"); //Criar o elemento da lista para cada tarefa
        iten.innerHTML = `${tarefa.descricao} <button onclick="remove('${tarefa._id}', this)">X</button>`; //Adicionar o conteudo da tarefa no elemento da lista criado acima  
        tarefas.appendChild(iten); //Adicionar o NOVO item na lista de tafefas no HTML
    });
}) 


//Parte PARA ENVIAR e salvar no servidor AO CLICAR EM ADD
document.getElementById("add").addEventListener("click", ()=>{
    const descricao = document. getElementById("tarefa").value;

    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({descricao: descricao})
    })
    .then(resposta => resposta.json())
    .then((tarefa) => {
        const iten = document.createElement("li");
        iten.innerHTML = `${tarefa.descricao} <button onclick="remove(${tarefa._id})">X</button>`;
        tarefas.appendChild(iten);
    });
});

//Funçao para excluir quando clicar no X
function remove(_id, botao){

        fetch(`${url}/${_id}`, {
            method: "DELETE",       
        })    
        .then(()=>{
           botao.parentElement.remove(); // Remove o <li> da tela
        })
    }  
