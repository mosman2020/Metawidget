<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="m" uri="http://metawidget.org/spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link href="<c:url value="/css/common.css" />" rel="stylesheet">

<form:form method="post" action="person" modelAttribute="person" >
<input type="hidden" name="personId" value="${person.id}" />
<input type="hidden" id="childId" name="childId"/>

			
			<m:metawidget path="person" styleClass="data-table" readOnly="${!editable}">
				<m:stub path="childs" >
					<table class="data-table">
						<thead>
							<tr>
								<th>Name</th>
								<th>Gender</th>
								<th>Age</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${person.childs}" var="child" >
								<tr>
										<td>${child.name}</td>
										<td>${child.gender}</td>
										<td>${child.age}</td>
										<td>
											<c:if test="${editable}">
												<input  type="submit" name="deletechild" value="Delete" onclick="document.getElementById('childId').value = '${child.id}';"/> 
											</c:if>
										</td>
									</tr>
								
							</c:forEach>
							
						</tbody>
							<c:if test="${editable}">
								<!-- <input type="submit" name="addchild" value="Add"/> -->
							</c:if>
					</table>
				</m:stub>
				
				<m:facet name="footer">
					
						<c:choose>
							<c:when test="${!editable}">
								<input type="submit" name="edit" value="Edit"/> &nbsp;&nbsp;
								<input type="submit" name="cancel" value="Back"/>
							</c:when>
							<c:otherwise>
					            <input type="submit" name="save" value="Save"/> &nbsp;&nbsp;
								<input type="submit" name="delete" value="Delete"/> &nbsp;&nbsp;
								<input type="submit" name="cancel" value="Cancel"/>
							</c:otherwise>
						</c:choose>
					
				</m:facet>
			</m:metawidget>

</form:form>