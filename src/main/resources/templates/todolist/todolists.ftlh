<#import "../parts/common.ftlh" as c>
<#import "../parts/delete.ftlh" as d>
<@c.page>
    <a href="/api/todolist/create">Create note</a>
    <div>To Do Lists</div>
    <#list response.userToDoLists as todolist>
        <div>
            <a href="/api/todolist/${todolist.id}"><b>${todolist.name}</b></a> <@d.delete "/api/todolist/delete" "${todolist.id}" "${todolist.role}"/>
        </div>
        <br>
    </#list>

</@c.page>