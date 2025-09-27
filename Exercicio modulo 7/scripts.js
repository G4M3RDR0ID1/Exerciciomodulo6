
//3.atualizar o tempo na aba de tempo de estacionamento

 class Parquimetro {
    constructor(){
        this.tempo = 0;
        this.troco = 0;
        this.tarifa = 0;
    }

     //1.pegar o valor que o usuario vai digitar
     pegarTarifa(){
        let deposito = parseFloat(document.getElementById("tarifa").value);
        //1.1 se o valor for menor que 1 real, mostrrar "Valor insuficiente"
        if(deposito < 1){
            return alert("Valor insuficiente!");
        }
        else{
            return this.calculoDeTarifa(deposito);
        }
     }

    //2.Efetuar o calculo de quanto tempo ele vai ficar
     calculoDeTarifa(deposito){
        if(deposito < 1.75){
            this.tempo = 30;
             //2.1 Se houver troco, mostrar na tela o troco
            this.troco = deposito - 1;
        }
        else if(deposito < 3){
            this.tempo = 60;
            this.troco = deposito - 1.75;
        }
        else{
            this.tempo = 120;
            this.troco = deposito - 3;
        }

        return this.atualizarValores(this.tempo, this.troco);
     }

     //3.atualizar o tempo na aba de tempo de estacionamento
     atualizarValores(tempo, troco){
        document.getElementById("tempoParquimetro").textContent = `${tempo} minutos`;
        document.getElementById("troco").textContent = `R$${troco.toFixed(2).replace('.', ',')}`;
        document.getElementById("tarifa").value = '';
     }

 }

 const parquimetro = new Parquimetro();