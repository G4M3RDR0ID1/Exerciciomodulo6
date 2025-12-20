import { Cliente } from "./classes.js"

//funçao que vai ficar responsavel por pegar os dados da api e tranformar em um objeto cliente
export const transformaEmCliente = (dados) => {
    return dados.map(clientes => new Cliente(clientes.nome, clientes.email, clientes._id))
}

//funçao responsavel por criar uma nova linha na tabela com os dados de uma variavel que seja da classe cliente, aoExcluir e a funçao que representa o botao excluir e sua funcionalidade
export const criarLinha = (cadastro, aoExcluir) => {
    const linha = document.createElement("tr");
    const linhaNome = document.createElement("td");
    linhaNome.textContent = `${cadastro.nome}`
    const linhaEmail = document.createElement("td");
    linhaEmail.textContent = `${cadastro.email}`

    const linhaBotao = document.createElement("td");
    const botaoExcluir = document.createElement("button");
    botaoExcluir.textContent = "Excluir";
    botaoExcluir.type = "button";

    botaoExcluir.addEventListener("click", () => {
        aoExcluir(cadastro._id, botaoExcluir)
    })

    linhaBotao.appendChild(botaoExcluir);

    linha.appendChild(linhaNome);
    linha.appendChild(linhaEmail);
    linha.appendChild(linhaBotao);
    
    return linha;
}