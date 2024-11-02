<template>
  <div class="side-menu" @click="handleSideMenuClick">
    <div class="logo-container">
      <img src="@/assets/Logo.png" alt="logo" class="logo" />
      <h3 class="title">System Health Monitor</h3>
    </div>

    <ul>
      <!-- Dashboard Menu -->
      <li
        :class="{ 'active-item': activeMenu === 'dashboard' }"
        @click="setActiveMenu('dashboard')"
      >
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
          <li
            v-for="(systemInfo, index) in systemData"
            :key="index"
            :class="{ 'active-item': activeMenu === `system-${index}` }"
            @click.stop="selectSystem(`system-${index}`)"
          >
            <router-link
              :to="{ name: 'DrawerTable', params: { systemName: systemInfo }}"
              exact
            >{{ systemInfo }}</router-link>
          </li>
        
        </ul>
      </li>
        <!-- Logout button -->
      
    </ul>
    
        <button @click="logout" class="side-menu1 logout-button">Logout<i id ="logicon" class="fa-solid fa-arrow-right-from-bracket"></i></button>
    
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeMenu: "",
      showDropdown: false,
      systemData: [
        "Abitha",
        "Dharshini",
        "Hari",
        "Kirthiga",
        "Mounesh",
        "Pragathi",
        "Praveen",
        "Swathi",
        "Swathi_Info",
        "Thangavi",
        "Thulasi"
      ]
    };
  },
  methods: {
    toggleDropdown(event) {
      event.stopPropagation(); // Prevent the click from bubbling up to document
      this.showDropdown = !this.showDropdown;
      this.activeMenu = this.showDropdown ? "systems" : "";
    },
    setActiveMenu(menu) {
      this.activeMenu = menu;
      this.showDropdown = false; // Hide dropdown when a menu is clicked
    },
    selectSystem(menu) {
      this.setActiveMenu(menu);
    },
    handleClickOutside(event) {
      const sideMenu = this.$el;
      // Close dropdown if the click is outside the side menu
      if (!sideMenu.contains(event.target)) {
        this.showDropdown = false;
      }
    },
    handleSideMenuClick(event) {
      const clickedElement = event.target;
      const dropdown = this.$el.querySelector(".dropdown");
      const systemsMenu = this.$el.querySelector(".side-menu1"); // "Systems" menu link

      // Check if the click is on "Systems" menu or inside dropdown, otherwise hide the dropdown
      if (
        clickedElement !== systemsMenu &&
        !dropdown.contains(clickedElement)
      ) {
        this.showDropdown = false;
      }
    },
    logout() {
      // Clear authentication and redirect to login page
      localStorage.removeItem('isAuthenticated');
      this.$router.push('/login');
    },

  },
  mounted() {
    // Add click listener to the document for detecting outside clicks
    document.addEventListener("click", this.handleClickOutside);
  },
  beforeUnmount() {
    // Remove click listener when the component is destroyed
    document.removeEventListener("click", this.handleClickOutside);
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
  text-align: center; /* Align text to the left */
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
a.side-menu1[data-v-79f86886] {
  padding: 10px 20px;
  display: block;
  text-align: center;
  font-size: 25px;
  font-family: Georgia, "Times New Roman";
}

.side-menu[data-v-79f86886] a:hover {
  background-color: rgb(31, 17, 83);
}

.side-menu[data-v-79f86886] a:hover {
  display: block;
}
.logo-container {
  display: flex;
  align-items: center;
  justify-content: flex-start;
  margin-bottom: 30px;
  white-space: nowrap;
}
.logo {
  width: 35px;
  height: 30px;
  margin-right: 10px;
}
.logout-button {
  position: absolute;
  background-color:rgb(31, 17, 83);
  color: white;
  font-size: 20px;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  width: 80%;
  text-align: center;
   bottom:100px;
   left:30px;
  border-radius: 10px;
  /* margin-bottom: ; */
}

.logout-button:hover {
  background-color: #ca3737;
}
#logicon{
  margin-left: 10px;
}
</style>
