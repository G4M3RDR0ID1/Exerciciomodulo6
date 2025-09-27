// Controle de Gastos - Atualiza valores por categoria e total

// Matriz para armazenar os valores das categorias
const matrizGastos = [
    ["Alimentação", 0],
    ["Transporte", 0],
    ["Lazer", 0],
    ["Outros", 0],
    ["Total", 0],
];

// Função para adicionar um gasto
function adicionarGasto() {
    // Pega o valor informado e converte para número
    const valorGasto = Number(document.getElementById("gastos").value);
    // Pega a categoria selecionada
    const categoria = document.getElementById("categorias").value;

    // Impede valores inválidos
    if (valorGasto <= 0 || isNaN(valorGasto)) {
        alert("Digite um número válido e maior que 0");
        document.getElementById('gastos').value = '';
        return;
    }

    // Atualiza o valor na matriz conforme a categoria
    for (let i = 0; i < matrizGastos.length; i++) {
        if (categoria === matrizGastos[i][0]) {
            matrizGastos[i][1] += valorGasto;
            matrizGastos[4][1] += valorGasto; // Atualiza o total
        }
    }

    // Atualiza a interface com os novos valores
    document.getElementById("Total").innerText = `Total: R$ ${matrizGastos[4][1].toFixed(2)}`;
    document.getElementById("Alimentacao").innerText = `Alimentação: R$ ${matrizGastos[0][1].toFixed(2)}`;
    document.getElementById("Transporte").innerText = `Transporte: R$ ${matrizGastos[1][1].toFixed(2)}`;
    document.getElementById("Lazer").innerText = `Lazer: R$ ${matrizGastos[2][1].toFixed(2)}`;
    document.getElementById("Outros").innerText = `Outros: R$ ${matrizGastos[3][1].toFixed(2)}`;

    // Limpa o campo de entrada
    document.getElementById('gastos').value = '';
}