<#import "parts/common.ftlh" as c>

<@c.page>
    <div>Hello, ${email}</div>
    <a href="/api/events/all">Events</a>
    <a href="/api/notes/all">Notes</a>
    <a href="/api/todolists/all">To Do Lists</a>
</@c.page>