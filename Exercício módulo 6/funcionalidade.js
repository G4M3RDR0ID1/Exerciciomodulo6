//Gerar um número aleatório entre 1 e 100
const numeroAleatorio = Math.floor(Math.random() * 100) + 1;
//Numero maximo de tentativas
let tentativas = 10;

console.log(numeroAleatorio)

//Funão para verificar se o palpite esta certo
function verificarPalpite() {

    //Valor que o usuario digitou
    let palpite = document.getElementById("palpite").value;

    //Validar se o numero digitado esta entre 1 e 100
    if (palpite < 1 || palpite > 100) {
        alert("Didigite um numero entre 1 e 100");
    }
    //Se estiver iniciar comparaçao com o numero gerado
    else {

        //Se o usuiario acertar 
        if (palpite == numeroAleatorio) {
            document.getElementById("resultado").textContent = "Acertou";
            alert("Voce acertou Parabens")
            window.location.reload()
        }
        //se o numero secreto for menor
        else if (palpite > numeroAleatorio) {
            document.getElementById("resultado").textContent = "O número secreto é menor";
            tentativas--
        }
        //se o numero secreto for maior
        else {
            document.getElementById("resultado").textContent = "O número secreto é maior";
            tentativas--
        }

        //quantidade de tentativas
        document.getElementById("tentativas").textContent = `Você tem ${tentativas} tentativas`;

        //Se a quantidade chegar a zero reiniciar o jogo
        if (tentativas == 0) {
            alert(`Você perdeu! O número secreto era ${numeroAleatorio}`)
            window.location.reload()
        }

    }


}



