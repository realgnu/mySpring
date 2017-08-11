<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="/webjars/adminlte/2.3.11/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="/webjars/adminlte/2.3.11/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/webjars/adminlte/2.3.11/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/webjars/adminlte/2.3.11/dist/css/skins/_all-skins.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">

    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Admin</b>LTE</span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <tiles:insertAttribute name="top" />
    
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <tiles:insertAttribute name="left" />

  <!-- Content Wrapper. Contains page content -->
  <tiles:insertAttribute name="container" />
  <!-- /.content-wrapper -->

  <tiles:insertAttribute name="footer" />

</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="/webjars/adminlte/2.3.11/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/webjars/adminlte/2.3.11/bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/webjars/adminlte/2.3.11/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/webjars/adminlte/2.3.11/dist/js/app.min.js"></script>
<!-- Sparkline -->
<script src="/webjars/adminlte/2.3.11/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="/webjars/adminlte/2.3.11/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="/webjars/adminlte/2.3.11/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="/webjars/adminlte/2.3.11/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS 1.0.1 -->
<script src="/webjars/adminlte/2.3.11/plugins/chartjs/Chart.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/webjars/adminlte/2.3.11/dist/js/pages/dashboard2.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/webjars/adminlte/2.3.11/dist/js/demo.js"></script>
</body>
</html>
