import { http } from './api'

export default {

  findAll: () => {
    return http.get('guest');
  },

  findById: (guest) => {
    return http.get(`guest/${guest.id}`, { data: guest });
  },

  save: (guest) => {
    return http.post('guest', guest);
  },

  delete: (guest) => {
    return http.delete(`guest/${guest.id}`, { data: guest });
  },

  update: (guest) => {
    return http.put(`guest`, guest);
  }

}
