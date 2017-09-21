<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List
				,com.realgnu.mySpring.security.config.SecurityConst
				,com.realgnu.mySpring.common.mybatis.CustomCamelMap" %>
<%
	List<CustomCamelMap> myMenuList = (List<CustomCamelMap>)session.getAttribute(SecurityConst.SESSION_USER_MENU_LIST);
	String requestUri = (String) session.getAttribute("requestUri");
%>
<c:set var="myMenuList" value="<%=myMenuList%>"/>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="/webjars/adminlte/2.3.11/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Alexander Pierce</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="header">MAIN NAVIGATION</li>
        <c:forEach var="item" varStatus="status" items="${myMenuList}">
        <c:if test="${item.menuNo1 ne prevMenuNo1}">
        	<c:if test="${status.index ne 0}">
          </ul>
        </li>
        	</c:if>
        <li class="treeview <c:if test='${requestUri eq item.uri}'>active</c:if>">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>${item.menuName1}</span>
            <span class="pull-right-container">
               <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
          </c:if>
            <li <c:if test='${requestUri eq item.uri}'>class="active"</c:if>><a href="${item.uri}"><i class="fa fa-circle-o"></i> ${item.menuName2}</a></li>
            <c:set var="prevMenuNo1" value="${item.menuNo1}"/>
        </c:forEach>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>