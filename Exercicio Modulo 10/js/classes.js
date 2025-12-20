//Classe responsavel por representar o cliente que vai ser cadastrado
export class Cliente{
    #nome;
    #email;

    //Propriedades das Classe
    constructor(nome, email, id = null){
        this.#nome = nome;
        this.#email = email;
        this._id = id
    }

    get nome(){
        return this.#nome
    }

    get email(){
        return this.#email
    }

    get id(){
        return this._id
    }
    
    toJSON(){
        return{
            nome: this.#nome,
            email: this.#email
        }
    }

}
