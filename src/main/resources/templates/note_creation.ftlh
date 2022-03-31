<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="/notes/create" method="post">
        <div><label> Login : <input type="text" name="login"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <div><input type="submit" value="Sign In"/></div>
    </form>
</@c.page>