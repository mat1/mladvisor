<template>
  <div id="app">
    <nav>
      <div class="nav-wrapper blue-grey darken-4">
        <a href="#" class="brand-logo" style="padding-left: 20px">ML Advisor</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
          <li>
            <router-link to="/">Home</router-link>
          </li>
          <li>
            <router-link to="/about">About</router-link>
          </li>
        </ul>
      </div>
    </nav>
    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<style lang="scss">
</style>
