<%@ page language="java" %>

<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@page import="ar.com.dailyMarket.model.Image;"%>

<bean:define id="id" property="id" name="UserForm" type="java.lang.Long"/>
<bean:define id="attachId" property="attachId" name="UserForm" type="java.lang.Long"/>

<TABLE class="form" cellSpacing="0" cellPadding="6" border="0">
	<TR> 
	    <TD colspan="4" align="left" valign="top"> 
			<h1 class="formtitle"><bean:message key="EditLayout.main"/></h1>
	    </TD> 
	</TR>
	<TR> 
		<TD colspan="4"> 
			<html:errors/>
		</TD>
	</TR> 
	
	<logic:notEqual name="attachId" value="-1">
		<TR>	
			<TH style="width:100px;padding-left:40px;" rowspan="5">
				&nbsp;
				<div>					
						<%
							Image image = (Image)request.getSession().getAttribute("image");
						%>						
						<img src="image.do?VirtualDispatchName=getImage&isImage=0&imageId=<%=image.getThumbnail().getId().toString()%>" alt="<%=image.getDescription() %>"
							title="<%=image.getDescription() %>" /></a>
							<div class="highslide-caption">																																				
						</div>
				</div>
			</TH>	
			<TD width="100px;"></TD>
			<TH style="width:100px;padding-left:40px;"></TH>
			<TD></TD>
		</TR>
	</logic:notEqual>
	
	<TR> 
		<TH style="width:100px;padding-left:40px;"><bean:message key="UserForm.lastName"/></TH>
		<TD width="100px;"><html:text property="lastName" size="30"  maxlength="20"/></TD>			
	
		<TH style="width:100px;padding-left:40px;"><bean:message key="UserForm.name"/></TH>
		<TD><html:text property="name" size="30"  maxlength="20"/></TD>	
	</TR>
	
	<TR> 
		<TH style="width:100px;padding-left:40px;"><bean:message key="UserForm.user"/></TH>
		<TD width="100px;"><html:text property="user" size="30"  maxlength="20"/></TD>
	
		<TH style="width:100px;padding-left:40px;"><bean:message key="UserForm.password"/></TH>
		<TD><html:text property="password" size="30"  maxlength="20"/></TD>			
	</TR>
	
	<TR> 
		<TH style="width:100px;padding-left:40px;"><bean:message key="UserForm.dni"/></TH>
		<TD><html:text property="dni" size="30"  maxlength="20"/></TD>	
	
		<TH style="width:100px;padding-left:40px;"><bean:message key="UserForm.groupUser"/></TH>
		<TD>
			<html:select property="groupUserId">						
				<html:options collection="groupsUsers" property="id" labelProperty="name" />
			</html:select>
		</TD>
	</TR>	
	
	<logic:notEqual name="id" value="-1">
		<tr>
			<TH colspan="2" style="width:100px;padding-left:40px;"></TH>
				<TABLE align="left" class="buttons" border="0" cellspacing="0" cellpadding="3">
					<TR>	
						<td width="100%">&nbsp;</td>
				        <TD align="right"  width="130px" >        				
				     	   <input width="130px" class="btn" value="Adjuntar Imagen" readonly="readonly"
								 onclick="forms[0].VirtualDispatchName.value='initImage';forms[0].submit();">
				        </TD>	
					</TR>
				</TABLE>
			</th>
		</tr>
	</logic:notEqual>
</TABLE>
