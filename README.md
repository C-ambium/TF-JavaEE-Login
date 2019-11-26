## Login CRUD - JavaEE JSP Servlet Tomcat

Login service test projet.

**You must exclude Filter from build until fix**

**Todo**
* Fix edit mode
* Implement Cookies
* Implement Listeners & Filters
* Fix CSS path

Web XML
``` 
<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

TagsLibs
```
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/res/css/style.css'/>" rel="stylesheet">
```

Context Path
```
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}res/css/style.css" />
```


```
<url-pattern>*.css</url-pattern>
</servlet-mapping>
```