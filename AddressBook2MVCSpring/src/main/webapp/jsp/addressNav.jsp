<%-- 
    Document   : addressNav
    Created on : Oct 15, 2014, 10:56:40 AM
    Author     : apprentice
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id=bs-example-navbar-collapse-1">
            <ul class="nav nav-tabs" role="tablist">
                <li class="${homeActive}"><a href="index">Home</a></li>
                
                <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
                    <li class="${addActive}"><a href="addAddressForm">Add Address</a></li>                       
                <%--</sec:authorize>--%>

                <li class="${searchActive}">
                    <form action="searchAddress" method="get" class="navbar-form navbar-left" role="search">
                        <select name="search" class="form-control">                            
                            <option value="listAll">List All</option>
                            <option value="addressId">Address Id</option>
                            <option value="lastName">Last Name</option>
                            <option value="city">City</option>
                            <option value="state">State</option>
                            <option value="zip">Zip</option>                                                      
                        </select>    
                        <div class="form-group">
                            <input name="searchStr" type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Search</button>
                    </form>
                </li>                 
                <li align="right"> <a href="<c:url value="j_spring_security_logout" />Sign Out</a></li>
            </ul>

        </div>
    </div>                        
</nav>

