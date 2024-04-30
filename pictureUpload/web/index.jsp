<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<form action="addimgServlet"  method="post"  accept-charset="utf-8" enctype="multipart/form-data">
  <div >
    <img src="" width="150" height="150" id="previewimg">
  </div>
  <div >
    <input type="file" id="img" name="img" onChange="preview(this)"/>
    <span class="add">+</span>
  </div>
  <input  type="submit" id="submit_content" value="commit">
</form>
</body>
<script type="text/javascript">
  function preview(obj){
    var img = document.getElementById("previewimg");
    img.src = window.URL.createObjectURL(obj.files[0]);
  }
</script>
</html>
