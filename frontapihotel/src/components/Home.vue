<template>
  <div class="home">

    <nav>
      <div class="nav-wrapper blue darken-1">
        <a href="#" class="brand-logo center">Cadastro de clientes</a>
      </div>
    </nav>

    <!-- <form @submit.prevent="saveAndUpdateGuest">
      <div>
        <input type="text" v-model="guest.name" placeholder="Digite seu nome">
      </div>
      <div>
      <input type="text" v-model="guest.age" placeholder="Digite sua idade">
    </div>
    <div>
      <input type="text" v-model="guest.telefhone" placeholder="Digite seu telefone">
    </div>
    <div>
      <input type="text" v-model="guest.cpf" placeholder="Digite seu CPF">
    </div>
    <div>
      <input type="text" v-model="guest.registroGeral" placeholder="Digite seu RG">
    </div>
    <div>
      <input type="text" v-model="guest.check_in" placeholder="Digite sua data de check in">
    </div>
    <div>
      <input type="text" v-model="guest.check_out" placeholder="Digite sua data de Check out">
    </div>
    <button class="waves-effect waves-light btn-small">Salvar</button>
    <button v-show="guest.id" @click="cancelUpdate" class="waves-effect waves-light btn-small">Cancelar</button>
  </form> -->
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
    <input type="text" v-model="guest.id" placeholder="Digite o Codigo que deseja filtrar">
  </div>
  <button class="waves-effect waves-light btn-small">Perquisar</button>
</form>

    <table v-show="guests.length > 0">
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
      <tfoot>
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
      </tfoot>
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

  </div>
</template>

<script>
import GuestService from '../service/guestservice'
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
      guests: []
    }
  },
  name: 'Home',
  components: {
  },
  mounted() {
    this.listGuests();
  },
  methods: {
    listGuests() {
      GuestService . findAll().then(response => {
        this.guest = response.data;
      })
    },
    saveAndUpdateGuest() {
      if(!this.guest.id) {
        GuestService.save(this.guest).then(response => {
          this.listGuests();
          this.guest = {};
          alert("Hospede cadastrdo com sucesso!");
          return response;
        });
      } else {
        GuestService.update(this.guest).then(response => {
          this.listGuests();
          this.guest = {};
          alert("Hospede Atualizado com sucesso!");
          return response;
        });
      }
    },
    cancelUpdate() {
      this.guest = {};
      alert("Alteração cancelada!");
    }
  }
}
</script>

<style>
button {
  margin: 5px;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
