<#macro login path button_text login>
    <form action="${path}" method="post">
        <div><label> Login : <input type="text" name="login" value="${login}"/></label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <#nested>
        <input type="submit" value="${button_text}"/>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>
</#macro>