// Função para adicionar uma linha na tabela
function adicionarLinha(nome, email) {
    const linha = document.createElement("tr");
    const colunaNome = document.createElement("td");
    const colunaEmail = document.createElement("td");
    const colunaBotao = document.createElement("td");

    colunaNome.textContent = nome;
    colunaEmail.textContent = email;
    colunaBotao.innerHTML = `<button type="button">Excluir</button>`;

    linha.appendChild(colunaNome);
    linha.appendChild(colunaEmail);
    linha.appendChild(colunaBotao);

    listaDeCliente.appendChild(linha);
}

// No fetch inicial:
cadastros.forEach(cadastro => {
    adicionarLinha(cadastro.nome, cadastro.email);
});

// Ao cadastrar novo cliente:
.then((novoCadastro) => {
    adicionarLinha(novoCadastro.nome, novoCadastro.email);
})
