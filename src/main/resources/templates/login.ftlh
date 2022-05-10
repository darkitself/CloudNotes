<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="login_form">
        <h1>Login page</h1>
        <@l.login "/login" "Sign In" "${login}"/>
        <a href="/registration">Registration</a>
    </div>
</@c.page>