<#import "../parts/common.ftlh" as c>
<@c.page>
    <div>
        <a href="/api/main">Main page</a>
    </div>
    <div>
        <a href="/api/todolist/create">Create To Do List</a>
    </div>
    <div>To Do Lists</div>
    <#list response.userToDoLists as todolist>
        <div>
            <form action="/api/todolist/delete/${todolist.id}" method="post">
                <a href="/api/todolist/${todolist.id}"><b>${todolist.name}</b></a> <#if todolist.role=='OWNER'> <input type="submit" value="Delete"/></#if>
            </form>
        </div>
        <br>
    </#list>

</@c.page>