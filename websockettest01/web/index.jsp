<!DOCTYPE html>
<html lang="en">
<script src="https://cdn.staticfile.net/vue/2.2.2/vue.min.js"></script>
<head>
  <meta charset="UTF-8">
  <title>Vue Chat Room</title>
  <style>
    #app { text-align: center; }
    #log { height: 300px; overflow-y: scroll; border: 1px solid #ccc; padding: 5px; margin-bottom: 10px; }
    #message { width: 80%; }
  </style>
</head>
<body>
<div id="app">
  <div v-if="connected">
    <h2>Chat Room</h2>
    <div id="log">
      <div v-for="msg in messages">{{ msg }}</div>
    </div>
    <input type="text" v-model="message" placeholder="Type your message here..." />
    <button @click="sendMessage">Send</button>
    <button @click="disconnect">Disconnect</button>
  </div>
  <div v-else>
    <button @click="connect">Connect to Chat Room</button>
  </div>
</div>

<script>
  new Vue({
    el: '#app',
    data: {
      ws: null,
      connected: false,
      messages: [],
      message: ''
    },
    created() {
      this.connect();
    },
    methods: {
      connect() {
        this.ws = new WebSocket("ws://localhost:8080/websockettest01_war_exploded/robin");
        this.ws.onmessage = this.onMessage;
        this.ws.onopen = this.onOpen;
        this.ws.onclose = this.onClose;
        this.ws.onerror = this.onError;
      },
      sendMessage() {
        if (this.message !== '') {
          this.ws.send("User says: " + this.message);
          this.message = '';
        }
      },
      onMessage(event) {
        this.messages.push(event.data);
      },
      onOpen() {
        this.connected = true;
      },
      onClose() {
        this.connected = false;
        alert("Connection has been closed.");
      },
      onError() {
        this.connected = false;
        alert("Error during connection.");
      },
      disconnect() {
        this.ws.close();
      }
    }
  });
</script>
</body>
</html>
