
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
 
    <!-- Ensure you're dynamically passing the system name into the router link -->
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
        'viji_info', 
        'Abitha_info',
        'Kirthiga_info',
        'Thulasi_info',
        'Thangavi_info', 
        'Pragathi_info', 
        'praveen_info', 
        'mounish_info',
        'Swathi_info'
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
h1.title{
  font-size: 20px;
}


.side-menu h1 {
  widows: 100%;
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
  /* Removed flex to allow natural block-level alignment */
  padding: 10px 20px;
  display: block;
  text-align: left; /* Align text to the left */
}

.active-item a {
  background-color: rgb(202, 55, 55);
}

.dropdown {
  list-style: none;
  padding-left: 20px;
  /* background-color: #140244; */
}

.dropdown li {
  margin: 10px 0;
  background-color: transparent;
}

.dropdown a {
  color: white;
  padding-left: 40px; /* Indent the dropdown items for a better hierarchy */
}
a.side-menu1[data-v-79f86886] {
    padding: 10px 20px;
    display: block;
    text-align: center;
    font-size: 25px;
    font-family:Georgia, 'Times New Roman';
}
</style>
