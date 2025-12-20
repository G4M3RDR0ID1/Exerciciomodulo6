const matrizGastos = [
    ["Alimentação", 0],
    ["Transporte", 0],
    ["Lazer", 0],
    ["Outros", 0],
    ["Total", 0],
];

//Funcoes utilitarias
const obeterElemento = (id) => document.getElementById(id);
const valorNegativo = (valor) => valor < 0;
const somaValor = (total, valor) => total + valor;
const limparCampos = () => obeterElemento('valor').value = '';
const formataMoeda = (valor) => valor.toFixed(2).replace('.', ',')

//oter valores do formulario
const obterValorInformado = () => parseFloat(obeterElemento('valor').value);
const obterCategoriaInformada = () => obeterElemento('categorias').value

//obter categoria da matriz
const obterCategoria = (matriz, nomeCategoria) => matriz.find((item) =>item[0] === nomeCategoria)

//atualizar valores da matriz
const atuzalizarValoresCategoria = (categoria, valor) => categoria[1] = somaValor(categoria[1], valor)

//atuzalizar interface
const atualizaInterface = () =>{

    matrizGastos.forEach(([nome, valor]) => {
        const elemento = obeterElemento(nome)
        elemento.textContent = `${nome}: R$ ${formataMoeda(valor)}`
    })

}

function adicionarGasto(){
    // Pegar os valores informados pelo Usuario
    const valorInformado = obterValorInformado();
    const categoriaInformada = obterCategoriaInformada();
    //verifica se sao negativos
    if(valorNegativo(valorInformado) || isNaN(valorInformado)){
        alert("Valor invalido. O valor não pode ser negativo.")
        return
    }

    //atualização da matriz
    const categoria = obterCategoria(matrizGastos, categoriaInformada)
    const total = obterCategoria(matrizGastos, "Total")

    atuzalizarValoresCategoria(categoria, valorInformado)
    atuzalizarValoresCategoria(total, valorInformado)

    atualizaInterface()
    limparCampos()
}