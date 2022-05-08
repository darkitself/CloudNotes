<#import "parts/common.ftlh" as c>

<@c.page>
    <div>Hello, ${email}</div>
    <a href="/api/note/all">Notes</a>
    <a href="/api/todolist/all">To Do Lists</a>
</@c.page>