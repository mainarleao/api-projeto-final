<template>
  <div id="app">




      <figure id="logo">
        <img src="./assets/logo4.png" alt="">
      </figure>




    <div id="texto1">
      <p>Bem vindo ao Hotel Sunshine, localizado na Praia do Barão, é uma das melhores hospedagens do pais.</p>
      <p>Destino de turistas do mundo todo, conta com as melhores acomodaçoes para receber você sua familia.</p>
    </div>






    <div id="texto2">
      <ul class="collection">
        <li class="collection-item">Nossas acomodações contam com:</li>
        <li class="collection-item">Lindas suites com vista para a pra o mar</li>
        <li class="collection-item">Restaurante</li>
        <li class="collection-item">Bar</li>
        <li class="collection-item">Playground</li>
        <li class="collection-item">Piscina</li>
        <li class="collection-item">hidromassagem</li>
        <li class="collection-item">Academia</li>
      </ul>
    </div>






    <div id="galeria">
      <img src="./assets/restaurante.jpg" alt="restaurante" width="350" height="300">
      <img src="./assets/piscina.jpg" alt="piscina" width="350" height="300">
      <img src="./assets/academia.jpg" alt="academia" width="350" height="300">
      <img src="./assets/play.jpg" alt="play" width="350" height="300">
      <img src="./assets/quarto1.jpg" alt="quarto 1" width="350" height="300">
      <img src="./assets/quarto2.jpg" alt="quarto 2" width="350" height="300">
      <img src="./assets/quarto3.jpg" alt="quarto 3" width="350" height="300">
      <img src="./assets/quarto4.jpg" alt="quarto 4" width="350" height="300">
    </div>






    <div id="cadastro">
      <h2>Efetue seu cadastro no nosso hotel:</h2>
      <form @submit.prevent="saveAndUpdateGuest">
          <div class="input-field col s6">
            <label for="name">Nome</label>
            <input type="text" v-model="guest.name" id="name">
          </div>
          <div class="input-field col s6">
            <label for="age">Idade</label>
            <input type="text" v-model="guest.age" id="age">
          </div>
          <div class="input-field col s6">
            <label for="telephone">Telefone</label>
            <input type="text" v-model="guest.telephone" id="telephone">
          </div>
          <div class="input-field col s6">
            <label for="cpf">CPF</label>
            <input type="text" v-model="guest.cpf" id="cpf">
          </div>
          <div class="input-field col s6">
            <label for="registroGeral">Registro Geral</label>
            <input type="text" v-model="guest.registroGeral" id="registroGeral">
          </div>
          <div class="input-field col s6">
            <label for="check_in">Data de check-in</label>
            <input type="text" v-model="guest.check_in" id="check_in">
          </div>
          <div class="input-field col s6">
            <label for="check_out">Data de check-in</label>
            <input type="text" v-model="guest.check_out" id="check_out">
          </div>
          <button class="waves-effect waves-light btn-small">Salvar</button>
          <button v-show="guest.id" @click="cancelUpdate" class="waves-effect waves-light btn-small">Cancelar</button>
      </form>
    </div>




    <h2>buscar hospededes cadastrados:</h2>
    <div v-show="findGuest.id">
      <h1>Hospede encontrado</h1>
      <p>
        Codigo: {{findGuest.id}} <br>
        Nome: {{findGuest.name}} <br>
        Idade: {{findGuest.age}} <br>
        Telefone: {{findGuest.telephone}} <br>
        CPF: {{findGuest.cpf}} <br>
        RG: {{findGuest.registroGeral}} <br>
        Data de Check In: {{findGuest.check_in}} <br>
        Data de Check Out: {{findGuest.check_out}} <br>
      </p>
    </div>
      <form @submit.prevent="findById">
        <div>
          <input type="text" v-model="guest.id" placeholder="Digite o Codigo do cliente que deseja buscar">
        </div>
        <button class="waves-effect waves-light btn-small">Perquisar</button>
      </form>





    <div id="alterar">
    <table>
      <thead>
        <tr>
          <th>Codigo</th>
          <th>Nome</th>
          <th>Idade</th>
          <th>Telefone</th>
          <th>CPF</th>
          <th>RG</th>
          <th>Check In</th>
          <th>Check Out</th>
          <th>Excluir</th>
          <th>alterar</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="guest in guests" :key="guest.id">
          <td>{{guest.id}}</td>
          <td>{{guest.name}}</td>
          <td>{{guest.age}}</td>
          <td>{{guest.telephone}}</td>
          <td>{{guest.cpf}}</td>
          <td>{{guest.registroGeral}}</td>
          <td>{{guest.check_in}}</td>
          <td>{{guest.check_out}}</td>
          <td>
            <button type="button" @click="deleteGuest(guest)" class="waves-effect waves-light btn-small">Excluir</button>
          </td>
          <td>
            <button type="button" @click="updateGuest(guest)" class="waves-effect waves-light btn-small">Alterar</button>
          </td>
        </tr>
    </tbody>
    </table>
    <p>Quantidade de hospedes Cadastrados: {{guests.length}}</p>
    </div>


      <footer>
        <ul>
          <li>Contato:</li>
          <li>Telefone: (98)3528-9874</li>
          <li>Whatsapp: (98) 99824-9801</li>
          <li>e-mail: hotelsunshine@mail.com</li>
        </ul>
        <ul>
          <li>Redes Socias:</li>
          <li>Facebook: Hotel Sunshine</li>
          <li>Instagram: @hotelsunshine</li>
        </ul>

        <figure>
          <img src="./assets/logo4.png" alt="">
        </figure>
      </footer>



</div>
</template>

<script>
import GuestService from './service/guestservice'

export default {
  data() {
    return {
      guest : {
        id: '',
        name: '',
        age: '',
        telephone: '',
        cpf: '',
        registroGeral: '',
        check_in: '',
        check_out: ''
      },
      findGuest : {
        id: '',
        name: '',
        age: '',
        telephone: '',
        cpf: '',
        registroGeral: '',
        check_in: '',
        check_out: ''
      },
      guests: []
    }
  },
  name: 'App',
  components: {
  },
  mounted() {
    this.listGuests();
  },
  methods: {
    listGuests() {
      GuestService.findAll().then(response => {
        this.guests = response.data;
      });
    },
    saveAndUpdateGuest() {
      if(!this.guest.id) {
        //save
        GuestService.save(this.guest).then(response => {
          this.listGuests();
          this.guest = {};
          alert("Hospede cadastrdo com sucesso!");
          return response;
        });
      } else {
        //update
        GuestService.update(this.guest).then(response => {
          this.listGuests();
          this.guest = {};
          alert("Hospede Atualizado com sucesso!");
          return response;
        });
      }
    },
    deleteGuest(guest) {
      if (confirm("Deseja excluir o Hoespede")) {
        GuestService.delete(guest).then(response => {
          this.listGuests();
          alert("Hospede escluido com sucesso!");
          return response;
        });
      }
    },
    findById() {
      GuestService.findById(this.guest).then(response => {
        this.findGuest = response.data;
      });
    },
    updateGuest(guest) {
      this.guest = guest;
    },
    cancelUpdate() {
      this.guest = {};
      alert("Alteração cancelada!");
    }
  }
}
</script>

<style>
#logo {
  background-color: #fafafa;
  display: block;
  margin: 0;
}
#texto1 {
  margin-left: 20px;
  margin-top: 80px;
  font-size: 25px;
  border-bottom: 1px solid #9e9e9e;
}
button {
  margin: 5px;
}
#app {
  background-color: #eceff1;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
}
#galeria {
  text-align: center;
  margin-top: 50px;
  padding: 5px;
  border-bottom: 1px solid #9e9e9e;
}
  #galeria img:hover {
  -webkit-transform: scale(1.1);
  -moz-transform: scale(1.1);
  -o-transform: scale(1.1);
  -ms-transform: scale(1.1);
  transform: scale(1.1);
  border: 1px solid #e0e0e0;
  text-align: left;
  margin-bottom: 100px;
}

img {
  border-radius: 5px;
  margin: 15px;
}
.collection {
 margin-left: 460px;
 margin-right: 460px;
 font-size: 18px;
}

#cadastro {
  text-align: center;
  width: 1000px;
  margin-top: 50px;
  margin-left: 450px;
  background-color: #eceff1;
}

#alterar {
  margin-bottom: 50px;
  margin-top: 50px;
}

#alterar p {
  text-align: left;
  font-size: 18px;
  border-bottom: 1px solid #9e9e9e;
}

footer ul li {
  font-size: 16px;
}
</style>
