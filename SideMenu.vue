<template>
  <div class="side-menu">
    <h1 class="title">System Health Monitor</h1>
    <ul>
      <!-- Dashboard Menu -->
      <li :class="{ 'active-item': activeMenu === 'dashboard' }" @click="setActiveMenu('dashboard')">
        <router-link to="/system-health" class="side-menu1">Dashboard</router-link>
      </li>

      <!-- Systems Menu -->
      <li 
        :class="{ 'active-item': activeMenu === 'systems' || activeMenu.startsWith('system') }"
        @click="toggleDropdown"
      >
        <a href="#" class="side-menu1">Systems</a>

        <!-- Dropdown list, shown when `showDropdown` is true -->
        <ul v-show="showDropdown" class="dropdown">
          <li v-for="(systemInfo, index) in systemData" :key="index"
              :class="{ 'active-item': activeMenu === `system-${index}` }"
              @click.stop="setActiveMenu(`system-${index}`)">
            <router-link :to="{ name: 'DrawerTable', params: { systemName: systemInfo }}" exact>
              {{ systemInfo }}
            </router-link>
          </li>
        </ul>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeMenu: '',
      showDropdown: false,
      systemData: [
        'Abitha_Info', 
        'Hari_Info',
        'Kirthiga_Info',
        'Mounesh_Info',
        'Pragathi_Info', 
        'Praveen_Info', 
        'Swathi_Info', 
        'Thangavi_Info',
        'Thulasi_Info',
        'Viji_Info'
      ]
    };
  },
  methods: {
    toggleDropdown() {
      this.showDropdown = !this.showDropdown;
      this.activeMenu = this.showDropdown ? 'systems' : '';
    },
    setActiveMenu(menu) {
      this.activeMenu = menu;
      this.showDropdown = menu === 'systems';
    }
  }
};
</script>

<style scoped>
.side-menu {
  width: 250px;
  background-color: #140244;
  color: white;
  padding: 40px;
  position: fixed;
  height: 100vh;
  left: 0;
  top: 0;
  z-index: 100;
}
h1.title {
  font-size: 20px;
}
.side-menu h1 {
  width: 100%;
  margin-top: 0;
  font-size: 23px;
  margin-bottom: 50px;
}
.side-menu ul {
  list-style: none;
  padding: 0;
}
.side-menu li {
  margin: 15px 0;
  font-size: large;
}
.side-menu a {
  color: white;
  font-size: 20px;
  text-decoration: none;
  display: block; /* Ensure a is block-level */
  padding: 10px 20px; /* Add left padding to align text inside */
  margin: 0;
}
a.side-menu1 {
  padding: 10px 20px;
  display: block;
  text-align: left; /* Align text to the left */
}
.active-item a {
  border-radius: 10px;
  background-color: rgb(202, 55, 55);
}
.dropdown {
  list-style: none;
  padding-left: 20px;
}
.dropdown li {
  margin: 10px 0;
}
.dropdown a {
  color: white;
  padding-left: 40px; /* Indent the dropdown items for a better hierarchy */
}
</style>
