<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="/api/todolists/create" method="post">
        <div><label> Task : <input type="text" name="name"/> </label></div>
        <div><textarea name="toDoList"></textarea></div>
        <div><input type="submit" value="Create"/></div>
    </form>
</@c.page>