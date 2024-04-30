<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Avatar Upload</title>
  <script src="https://cdn.staticfile.net/vue/3.0.5/vue.global.js"></script>
  <style>
    img {
      width: 100px;
      height: auto;
      margin-top: 10px;
    }
  </style>
</head>
<body>
<div id="app">
  <h1>Upload File</h1>
  <form @submit.prevent="uploadFile">
    Select file: <input type="file" @change="fileChanged"><br><br>
    <button type="submit">Upload</button>
    <div v-if="imageUrl">
      <h2>Avatar Preview:</h2>
      <img :src="imageUrl" alt="Avatar">
    </div>
  </form>
</div>

<script>
  const { createApp, ref } = Vue;

  createApp({
    setup() {
      const file = ref(null);
      const imageUrl = ref(null);

      function fileChanged(event) {
        file.value = event.target.files[0];
      }

      function uploadFile() {
        const formData = new FormData();
        formData.append("avatar", file.value);

        fetch("http://localhost:8080/pictureUpload03_war_exploded/upload", {
          method: "POST",
          body: formData,
        })
                .then(response => response.json())
                .then(data => {
                  if (data.status === 'success') {
                    imageUrl.value = data.url;
                  } else {
                    alert('Upload failed');
                  }
                })
                .catch(error => {
                  console.error('Error:', error);
                  alert('Error uploading file');
                });
      }

      return { fileChanged, uploadFile, imageUrl };
    }
  }).mount('#app');
</script>
</body>
</html>
