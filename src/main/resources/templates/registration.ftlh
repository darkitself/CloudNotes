<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <h1>Registration page</h1>
    <@l.login "/registration" "Sign Up" "">
        <div><label> Email: <input type="email" name="email"/> </label></div>
    </@l.login>
    <a href="/login">or Sign In</a>
</@c.page>