import { useState } from 'react';
import ListaDeTarefas from './Components/ListaDeTarefas';
import Login from './Components/Login';
import { UserContext } from './state/context';
import { TarefaProvider } from './state/TarefaContext';
import './App.css';
import { useRecoilValue } from 'recoil';
import userState from './state/user';

function App() {

  const usuario = useRecoilValue(userState)

  return (
      <TarefaProvider>
        <main>
          <h1>Lista de Tarefas</h1>
          {usuario.estaLogado ? <ListaDeTarefas /> : <Login />}
        </main>
      </TarefaProvider>
  );
}

export default App;
