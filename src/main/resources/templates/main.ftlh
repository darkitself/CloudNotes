<#import "parts/common.ftlh" as c>

<@c.page>
    <div>Hello, ${email}</div>
    <a href="/api/events/">Events</a>
    <a href="/api/notes/">Notes</a>
    <a href="/api/todolists/">To Do Lists</a>
</@c.page>