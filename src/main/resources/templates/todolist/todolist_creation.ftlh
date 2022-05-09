<#import "../parts/common.ftlh" as c>

<@c.page>
    <form action="/api/todolist/create" method="post">
        <div><label> Name : <input type="text" name="name"/> </label></div>
        <div><input type="submit" value="Create"/></div>
    </form>
</@c.page>