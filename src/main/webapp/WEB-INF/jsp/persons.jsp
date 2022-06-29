<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://metawidget.org/spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="mh" uri="http://metawidget.org/html"%>

<link href="<c:url value="/css/common.css" />" rel="stylesheet">

<div id="content">

		<form:form method="post" action="person">
			<m:metawidget path="person">
			<m:facet name="footer">
					<input type="submit" name="add" value="Add Person"/>
				</m:facet>
			</m:metawidget>
		 </form:form>

<table class="data-table">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Name</th>
                    <th>Email</th>
                     <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${persons}" var="person">
                <form:form method="post" action="person" modelAttribute="person">
                	<input type="hidden" name="personId" value="${person.id}" />
                    <tr>
                        <td>${person.title}</td>
                        
                        <td>
							<input type="submit" name="view" class="submitLink" value="${person.name}"/>
                        </td>
                     
                        <td>${person.email}</td>
                        <td> 
                        	<input type="submit" name="edit" value="Edit"/>
					         &nbsp;&nbsp;
                        	<input type="submit" name="delete" value="Delete"/>
                        </td>
                    </tr>
                    </form:form>
                </c:forEach>
            </tbody>
        </table>
   
</div>