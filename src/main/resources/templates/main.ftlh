<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>Hello, ${email} <@l.logout/></div>
    <a href="/api/note/all">Notes</a>
    <a href="/api/todolist/all">To Do Lists</a>
    <div><a href="/api/export">Export</a></div>
</@c.page>